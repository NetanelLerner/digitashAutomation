package db.PersonalDocumets;

import db.connection.DBConnection;
import db.personalRequests.PersonalRequestsModel;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PersonalDocumentsDAL extends DBConnection {
    public static void main(String[] args) {
        findAll();
    }

    @SneakyThrows
    public static void findAll() {
        Connection connection = getConnection();

        PreparedStatement select =
                connection.prepareStatement("""
                        SELECT * FROM "PersonalDocuments"
                        """);

        System.out.println(select);
        List<PersonalDocumentsModel> request = map(select.executeQuery(), PersonalDocumentsModel.class);

        try {
            request.forEach(System.out::println);
        } finally {
            connection.close();
        }
    }
}
