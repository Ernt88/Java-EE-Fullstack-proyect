/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author poiu0
 */

//jdbc:mysql://localhost:3306/farmacia?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true ESTO ES COMO LO TENIA VANESSA
//jdbc:mysql://localhost:3306/farmacia?zeroDateTimeBehavior=CONVERT_TO_NULL   ASI ES COMO APARECE LA URL DE CONEXION A LA BD EN LOS SERVICIOS DE NETBEANS

public class conexion {    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/farmacia?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Server12";
    
    //guarda y abre la conexion
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    //devuelve los valores
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    //ejecuta la instruccion
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    //guarda la instruccion pero no la ejecuta
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    //cierra la conexion
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}

