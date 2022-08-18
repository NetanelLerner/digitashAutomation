package api.framework;

import lombok.SneakyThrows;
import org.testng.IExecutionListener;

import java.io.InputStream;
import java.util.Properties;

public final class Config implements IExecutionListener {
    private final static String HOST_DEV = "dev.host";
    private final static String HOST_TEST = "test.host";

    private final static String API_DEV = "api.dev";
    private final static String API_TEST = "api.test";

    private final static String API_KEY = "api.key";

    private final static String DB_NAME_DEV = "db.name.dev";
    private final static String SERVER_USERNAME_DEV = "server.username.dev";
    private final static String SERVER_PASSWORD_DEV = "server.password.dev";

    private final static String DB_NAME_TEST = "db.name.test";
    private final static String SERVER_USERNAME_TEST = "db.username.test";
    private final static String SERVER_PASSWORD_TEST = "db.password.test";
    private final static String DB_CONNECTION_STRING = "db.connection.string";

    static {
        loadPropertiesFile();
    }

    public final static String apiKey = System.getProperty(API_KEY);
    public final static String dbConnectionString = System.getProperty(DB_CONNECTION_STRING);

    public static String serverPassword = System.getProperty(SERVER_PASSWORD_DEV);
    public static String serverUsername = System.getProperty(SERVER_USERNAME_DEV);
    public static String apiHost;
    public static String url;
    public static String dbName;

    @Override
    public void onExecutionStart() {
        if ("test".equals(System.getProperty("env"))) {
            apiHost = System.getProperty(API_TEST);
            url = System.getProperty(HOST_TEST);
            dbName = System.getProperty(DB_NAME_TEST);
            serverPassword = System.getProperty(SERVER_PASSWORD_TEST);
        } else {
            apiHost = System.getProperty(API_TEST);
            url = System.getProperty(HOST_TEST);

            apiHost = System.getProperty(API_DEV);
            url = System.getProperty(HOST_DEV);

            dbName = System.getProperty(DB_NAME_DEV);
            serverPassword = System.getProperty(SERVER_PASSWORD_DEV);
        }
    }


    @SneakyThrows
    private static void loadPropertiesFile() {
        ClassLoader loader = Config.class.getClassLoader();
        InputStream inputStream = loader.getResourceAsStream("config.properties");
        Properties properties = new Properties();

        properties.load(inputStream);

        setSystemProperty(properties,
                HOST_DEV,
                HOST_TEST,
                API_DEV,
                API_TEST,
                API_KEY,
                DB_NAME_DEV,
                SERVER_USERNAME_DEV,
                SERVER_PASSWORD_DEV,
                DB_NAME_TEST,
                DB_CONNECTION_STRING);
    }

    private static void setSystemProperty(Properties properties, String... propertyKeys) {
        for (String key : propertyKeys) {
            System.setProperty(key, properties.getProperty(key));
        }
    }
}