package db.requeststypes;

import db.connection.DBConnection;
import db.personalRequests.PersonalRequestsModel;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class RequestTypeDAL extends DBConnection {

    public static void main(String[] args) {
        findAll();
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        findBySubType(417);
    }

    @SneakyThrows
    public static void findAll()  {
        Connection connection = getConnection();

        PreparedStatement select =
                connection.prepareStatement("""
                                      SELECT * FROM "Requests"
                                      """);

        List<RequestTypeModel> request = map(select.executeQuery(), RequestTypeModel.class);

        try {
            request.forEach(System.out::println);
        }
        finally {
            connection.close();
        }
    }

    @SneakyThrows
    public static void findBySubType(Integer subTYpe){
        Connection connection = getConnection();

        PreparedStatement select =
                connection.prepareStatement("""
                        SELECT * FROM "Requests"
                        WHERE id = %d
                        """.formatted(subTYpe));

        List<RequestTypeModel> request = map(select.executeQuery(), RequestTypeModel.class);

        try {
            request.forEach(System.out::println);
        }
        finally {
            connection.close();
        }
    }

}
