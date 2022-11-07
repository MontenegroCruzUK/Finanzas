/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;

/**
 *
 * @author montenegro
 */
public class ConexionDB {

    Connection connection;
    String url = "jdbc:mysql://localhost:3306/db_finanzas";
    String user = "root";
    String password = "";

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion genial");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error ewn la conexion\n" + e);
            return connection;
        }
    }

}
