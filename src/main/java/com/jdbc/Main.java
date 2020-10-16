package com.jdbc;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/usersdb?useSSL=false&serverTimezone=UTC";
    private static final String LoginName = "root";
    private  static final String Password = "rootroot";

    public  Main() {
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver = new FabricMySQLDriver ( );
        try {
            DriverManager.registerDriver(driver);
        }
        catch (SQLException ex) {
            System.out.println ("Не удалось зарегистрировать драйвер!");
            return;
        }
        try {
            connection = DriverManager.getConnection(URL, LoginName, Password);
            System.out.println("code");
        }
        catch (SQLException ex){
            System.out.println("Не удалось создать соединение!");

        }
        finally {
            if (connection !=null) {
                connection.close ();
            }
        }
              executeUpdate();
            createCustomerTable();

    }

    private static void executeUpdate() {
    }


    private static void executeUpdate(String query) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, LoginName, Password);
            Statement statement = getStatement (connection);
            /* Для Insert, Update, Delete */
            statement.executeUpdate (query);
        }
        catch (SQLException ex){
            System.out.println("Не удалось создать соединение!");

        }

    }

    private static Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement ( );
    }


    private static void createCustomerTable() {
        String customerTableQuery = "CREATE TABLE customers " +
                "(id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
        String customerEntryQuery = "INSERT INTO customers " +
                "VALUES (73, 'Brian', 33)";
        executeUpdate (customerTableQuery);
        executeUpdate (customerEntryQuery);
    }

}

