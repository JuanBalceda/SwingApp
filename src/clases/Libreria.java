/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jbalceda
 */
public class Libreria {

    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static String driver = "com.mysql.jdbc.Driver";
    static String cadena = "jdbc:mysql://localhost:3306/sesion13?"
            + "useUnicode=true&"
            + "useJDBCCompliantTimezoneShift=true&"
            + "useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";
    static String usuario = "root";
    static String clave = "";

    public static Connection conexion(Connection conn) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(cadena, usuario, clave);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver");
        } catch (SQLException e) {
            System.out.println("Error al conectar la base de datos");
        }
        return conn;
    }

    public static Statement sentencia(Statement s) {
        try {
            connection = conexion(connection);
            s = connection.createStatement();
        } catch (SQLException e) {
        }
        return s;
    }

    public static ResultSet consulta(ResultSet rs) {
        try {
            statement = sentencia(statement);
            rs = statement.executeQuery("SELECT * FROM alumnos WHERE matricula = 1");
        } catch (SQLException e) {
        }
        return rs;
    }
}
