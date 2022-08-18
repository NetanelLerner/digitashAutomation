package db.personalRequests;

import db.connection.DBConnection;
import db.extraRequestData.ExtraRequestDataDAL;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class PersonalRequestsDAL extends DBConnection {

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
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        findOneById(2);
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
//        System.out.println(".");
//        System.out.println(".");
//        findOneBySubType(462);
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
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        createNewRequest(null, "9026284", 462, "16/08/2022",
//                "01", "01", "01", "01",
//                "02:45");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        deleteAllRequestsByPersonalId("8872491");
    }
    @SneakyThrows
    public static void findAll() {
        Connection connection = getConnection();

        PreparedStatement select =
                connection.prepareStatement("""
                        SELECT * FROM "PersonalRequests"
                        """);

        List<PersonalRequestsModel> request = map(select.executeQuery(), PersonalRequestsModel.class);

        try {
            request.forEach(System.out::println);
        } finally {
            connection.close();
        }
    }

    @SneakyThrows
    public static void findOneById(Integer id) {
        Connection connection = getConnection();

        PreparedStatement select =
                connection.prepareStatement("""
                        SELECT * FROM "PersonalRequests"
                        WHERE black_id = %d
                        """.formatted(id));

        List<PersonalRequestsModel> request = map(select.executeQuery(), PersonalRequestsModel.class);

        try {
            request.forEach(System.out::println);
        } finally {
            connection.close();
        }
    }

    @SneakyThrows
    public static void findOneBySubType(Integer SubType) {
        Connection connection = getConnection();

        PreparedStatement select =
                connection.prepareStatement("""
                        SELECT * FROM "PersonalRequests"
                        WHERE subty = %d
                        """.formatted(SubType));

        List<PersonalRequestsModel> request = map(select.executeQuery(), PersonalRequestsModel.class);

        try {
            request.forEach(System.out::println);
        } finally {
            connection.close();
        }
    }

    @SneakyThrows
    public static void createNewRequest(String req_id, String personalNumber, Integer subType,
                                        String beginningDate, String essenceRequest, String requestStatus
                                        , String requestReasonSubmitting, String black_status, String hour) {
        Connection conn = getConnection();

        PreparedStatement statement = conn.prepareStatement("""
                INSERT INTO "PersonalRequests"
                (
                req_id, 
                pernr, 
                subty, 
                begda, 
                req_kind, 
                req_stat, 
                req_class, 
                black_status, 
                hour, 
                send_to_red_status
                )
                VALUES
                ('%s',
                '%s',
                %d,
                '%s',
                '%s',
                '%s',
                '%s',
                '%s',
                '%s',
                '1'
                );
                              """.formatted(
                  req_id
                , personalNumber
                , subType
                , beginningDate
                , essenceRequest
                , requestStatus
                , requestReasonSubmitting
                , black_status
                , hour
        ), RETURN_GENERATED_KEYS);
        System.out.println(statement);
        statement.execute();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        System.out.println(resultSet.getInt(1));
        conn.close();
    }

    @SneakyThrows
    public static void deleteAllRequestsByPersonalId(String personalId) {
        ExtraRequestDataDAL.deleteAllRequestsByPersonalId(personalId);

        Connection connection = getConnection();

                connection.prepareStatement("""
                        DELETE FROM "PersonalRequests"
                        WHERE pernr = '%s'
                        """.formatted(personalId)).execute();
        try {
        } finally {
            connection.close();
        }
    }
}
