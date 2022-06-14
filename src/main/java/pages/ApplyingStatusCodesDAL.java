package pages;

import db.DBConnection;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ApplyingStatusCodesDAL extends DBConnection {

    public static void main(String[] args) {
        a();
    }


    @SneakyThrows
    public static void a()  {
        Connection conn = getConnection();

        PreparedStatement select =
                conn.prepareStatement("""
                                      SELECT * FROM "ApplyingStatusCodes"
                                      """);

        List<ApplyingStatusCodes> users = map(select.executeQuery(), ApplyingStatusCodes.class);

        try {
            users.forEach(System.out::println);
        }
        finally {
            conn.close();
        }
    }
}
