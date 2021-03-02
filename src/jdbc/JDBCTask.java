package jdbc;

import streams.StreamTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class JDBCTask {

    public static String URL = "jdbc:postgresql://localhost:5432/";
    public static String DRIVER = "org.postgresql.Driver";
    public static String DB_NAME = "test";
    public static String USER_NAME = "test";
    public static String PASSWORD = "test";

    public static void start(){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * FROM Sellers " +
                "WHERE id = ?");
            print(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void print(PreparedStatement statement) throws SQLException {
        if (new Random().nextBoolean()){
            statement.setInt(1, 1);
            System.out.println("qqq");
        } else {
            statement.setInt(1, 2);
            System.out.println("www");
        }

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getRow() + " " + resultSet.getString("name"));
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DB_NAME, USER_NAME, PASSWORD);
    }
}
