package db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DBConnection {

    private static final String CONNECTION_STRING = "jdbc:postgresql://tash-nonprod.postgres.database.azure.com:5432/postgres";
    private static final String SERVER_USERNAME = "tashadmin@tash-nonprod";
    private static final String SERVER_PASSWORD = "Rt14725836s!@";

    private static final ThreadLocal<Connection> conn = new ThreadLocal<>();

    private static HikariConfig config;

    private static HikariDataSource dataSource;

    // TODO: Lazy-create DataSources
    static {
        config = new HikariConfig();
        config.setJdbcUrl(CONNECTION_STRING);
        config.setUsername(SERVER_USERNAME);
        config.setPassword(SERVER_PASSWORD);
        config.setIdleTimeout(15);
        config.setMaximumPoolSize(5);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        dataSource = new HikariDataSource(config);
    }

    protected static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    protected static synchronized <T> List<T> map(ResultSet set, Class<T> clazz) {
        try {
            List<T> results = new ArrayList<>();

            // For each row in the result set
            while (set.next()) {
                // Create an instance of the type
                T dto = clazz.getConstructor().newInstance();

                // For each field in the type
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    Column column = field.getAnnotation(Column.class);

                    if (column != null) {
                        String name = column.value();
                        String value = set.getString(name);

                        // Set the field's value according to the field's type
                        field.set(dto, parseStringToField(field, value));
                    }
                }
                // Add the result
                results.add(dto);
            }

            return results;
        }
        catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static synchronized Object parseStringToField(Field field, String value) {
        if (value == null) {
            return null;
        }

        if (LocalDate.class.equals(field.getType())) {
            return LocalDate.parse(value);
        }

        if (LocalDateTime.class.equals(field.getType())) {
            return LocalDateTime.parse(value.replace(" ", "T"));
        }

        if (Integer.class.equals(field.getType())) {
            return Integer.valueOf(value);
        }

        if (Boolean.class.equals(field.getType())) {
            return "1".equals(value);
        }

        try {
            return field.getType().getConstructor(String.class).newInstance(value);
        }
        catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static synchronized String parseFieldToString(Field field, Object object) {
        try {
            Object fieldValue  = field.get(object);
            Class<?> fieldType = field.getType();

            if (fieldValue != null) {
                // Check for data which needs to be wrapped in quotes ('')
                if (String.class.equals(fieldType) ||
                        LocalDateTime.class.equals(fieldType) ||
                        LocalDate.class.equals(fieldType)) {

                    return StringUtil.quoteOrNull(fieldValue);
                }
                else if (Boolean.class.equals(fieldType)) {
                    return String.valueOf(((boolean) fieldValue) ? 1 : 0);
                }
                // Call a default toString()
                else {
                    return field.get(object).toString();
                }
            }
            else {
                return null;
            }
        }
        catch (IllegalAccessException ex) {
            log.info("Field '%s' is inaccessible".formatted(field.getName()));
            throw new RuntimeException(ex);
        }
    }

    /**
     * Add the given object to the given table.
     * This method does not establish or close the connection to the database.
     * This method ignores columns / fields named 'id' (case insensitive).
     * @param tableName the table to add the object to
     * @param object the object to be added
     */
    protected static synchronized <T> void add(String tableName, T object) {
        if (conn == null) {
            throw new NullPointerException("Before calling methods, you must first establish a connection.");
        }

        StringBuilder queryString = new StringBuilder();

        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Column column = field.getAnnotation(Column.class);

            if (column != null) {
                if ("id".equals(column.value().toLowerCase())) {
                    continue;
                }

                columns.append(column.value())
                        .append(",");

                values.append(parseFieldToString(field, object))
                        .append(",");
            }
        }
        columns.deleteCharAt(columns.lastIndexOf(","))
                .append(")");
        values.deleteCharAt(values.lastIndexOf(","))
                .append(")");

        queryString.append("INSERT INTO ").append(tableName).append(columns.toString())
                .append(" VALUES").append(values.toString());

//        execute(queryString.toString());
    }
}
