package db.extraRequestData;

import db.connection.DBConnection;
import db.personalRequests.PersonalRequestsModel;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ExtraRequestDataDAL extends DBConnection {

    public static void main(String[] args) {
//        findAll();
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        findOneById(2);
//        deleteRequestsById("8390524");
    }

    @SneakyThrows
    public static void findAll()  {
        Connection conn = getConnection();

        PreparedStatement select =
                conn.prepareStatement("""
                                      SELECT * FROM "ExtraRequestData"
                                      """);

        List<ExtraRequestDataModel> users = map(select.executeQuery(), ExtraRequestDataModel.class);

        try {
            users.forEach(System.out::println);
        }
        finally {
            conn.close();
        }
    }

    @SneakyThrows
    public static void findOneById(Integer id){
        Connection connection = getConnection();

        PreparedStatement select =
                connection.prepareStatement("""
                        SELECT * FROM "ExtraRequestData"
                        WHERE black_id = %d
                        """.formatted(id));

        List<ExtraRequestDataModel> request = map(select.executeQuery(), ExtraRequestDataModel.class);

        try {
            request.forEach(System.out::println);
        }
        finally {
            connection.close();
        }
    }


    @SneakyThrows
    public static void deleteAllRequestsByPersonalId(String personalId) {
        Connection connection = getConnection();

        connection.prepareStatement("""
                DELETE FROM "ExtraRequestData"
                where black_id in (SELECT black_id
                FROM "PersonalRequests" where pernr = '%s')
                       """.formatted(personalId)).execute();
        try {
        } finally {
            connection.close();
        }
    }
}