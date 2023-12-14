/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author !Core¡
 */
public class Conexion {
    
    private Connection cnn = null;
    private Statement st = null; 
    
    public Conexion() { 
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atracciones?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    , "root", "andres123");
            st = cnn.createStatement();
            System.out.println("Conexión buena");
        } catch (SQLException e) {
            System.out.println("Error 1: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error 2: "+e.getMessage());
        }
    }
    
    public Connection getConnection() {
        return cnn;
    }
    
    public void desconnection() {
        try {
            cnn.close();
            System.exit(0);
        } catch (SQLException e) {
            System.out.println("Error 3: "+e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Conexion co = new Conexion();
    }
}
