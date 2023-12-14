/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Vista.frmRegistroUsuarios;

/**
 *
 * @author !Core¡
 */
public class UsuariosDAO {
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    Conexion conexion = new Conexion();
    frmRegistroUsuarios frm = new frmRegistroUsuarios();
    
    public int agregarUsuario(Usuarios usuario) {
        int p = 0;
        String sql = "INSERT INTO usuarios (Cedula, Contrasena, Nombre, Apellido1, Apellido2, TipoUsuario) "
                + "VALUES (?, ?, ?, ?, ?, ?);";
        
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, usuario.getCedula());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido1());
            ps.setString(5, usuario.getApellido2());
            ps.setString(6, usuario.getTipoUsuario());
            p = ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("error agregado "+e.getMessage());
        }
        return p;
    }
    
    public int actualizarUsuario(Usuarios usuario) {
        int p = 0;
        String sql = "UPDATE usuarios SET Contrasena=?, Nombre=?, Apellido1=?, Apellido2=?, TipoUsuario=? "
                + "WHERE Cedula=?;";
        
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getContrasena());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido1());
            ps.setString(4, usuario.getApellido2());
            ps.setString(5, usuario.getTipoUsuario());
            ps.setInt(6, usuario.getCedula());
            p = ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        return p;
    }
    
    public int eliminarUsuario(int cedula) {
        int p = 0;
        String sql = "DELETE FROM usuarios WHERE Cedula="+cedula+";";
        
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            p = ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        return p;
    }
    
    public void filtrarPorNombre(JTable table, String filtro) {
        
        String[] title = {"CEDULA", "CONTRASENA", "NOMBRE DE USUARIO", "APELLIDO 1", "APELLIDO 2", "TIPO DE USUARIO"};
        String[] datos = new String[6];
        String sql = "SELECT * FROM usuarios WHERE Nombre LIKE '%"+filtro+"%';";
        DefaultTableModel modelo = new DefaultTableModel(null, title);
        
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            
            while(rs.next()) {
                datos[0] = rs.getString("Cedula");
                datos[1] = rs.getString("Contrasena");
                datos[2] = rs.getString("Nombre");
                datos[3] = rs.getString("Apellido1");
                datos[4] = rs.getString("Apellido2");
                datos[5] = rs.getString("TipoUsuario");
                modelo.addRow(datos);
            }
            
            table.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("ERROR AL BUSCAR"+ e.getMessage());
        }
    }
    
    public boolean login(Usuarios usuario) {
        String sql = "SELECT Nombre, Contrasena, TipoUsuario FROM usuarios WHERE Nombre=?;";
        
        try {
            conn = conexion.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            rs =  ps.executeQuery();
            
            if (rs.next()) {
                if (usuario.getContrasena().equals(rs.getString("Contrasena")) && usuario.getTipoUsuario().equals(rs.getString("TipoUsuario"))){
                    usuario.setNombre(rs.getString("Nombre"));
                    usuario.setTipoUsuario(rs.getString("TipoUsuario"));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
            
        } catch (SQLException e) {
            return false;
        }
    } 
}
