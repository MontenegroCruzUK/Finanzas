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
public class LoginDado {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    ConexionDB conexionDB = new ConexionDB();
    Login login = new Login();

    public Login setLogin(String correo, String password) {
        System.out.println("setLogin Inicindo");
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
        try {
            connection = conexionDB.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, correo);
            ps.setString(2, password);
            
            rs = ps.executeQuery();

            System.out.println("Empieza el if");
            if (rs.next()) {
                System.out.println("if se esta ejecutando");
                login.setId(rs.getInt("id"));
                login.setNombre(rs.getString("nombre"));
                login.setApellido(rs.getString("apellido"));
                login.setCorreo(rs.getString("correo"));
                login.setPassword(rs.getString("password"));
                
                System.out.println("Mostrando datos almacenados");
                login.mostrarDatosAlmacenados();

            }
            System.out.println("Final del If");
        } catch (SQLException e) {
            System.out.println("Error en set login error\n" + e.toString());
        }
        return login;
    }

}
