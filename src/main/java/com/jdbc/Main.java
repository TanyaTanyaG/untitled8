package com.jdbc;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC";
    private static final String LoginName = "root";
    private  static final String Password = "rootroot";
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver;
        driver = new FabricMySQLDriver();
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
    }

    private int executeUpdate() throws SQLException {
        return executeUpdate ();
    }

    private int executeUpdate(String query) throws SQLException {
        Connection connection = null;
        assert false;
        Statement statement = connection.createStatement();
        // Для Insert, Update, Delete
        return statement.executeUpdate(query);
    }
    private void createCustomerTable() {
        String customerTableQuery = "CREATE TABLE customers " +
                "(id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
        String customerEntryQuery = "INSERT INTO customers " +
                "VALUES (73, 'Brian', 33)";
        executeUpdate (customerTableQuery);
        executeUpdate (customerEntryQuery);
    }

    private void executeUpdate(String customerTableQuery) {
    }


}

