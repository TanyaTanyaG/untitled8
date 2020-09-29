package com.jdbc;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    }

