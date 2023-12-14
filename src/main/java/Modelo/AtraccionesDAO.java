/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dchac
 */
public class AtraccionesDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion();

    public int agregarAtraccion(Atracciones atrac) {
        int r = 0;
        String sql = "INSERT INTO atracciones (NombreAtraccion, Identificador, FechaInstalacion, Capacidad, Seccion, EdadPermitida, PrecioxPersona)"
                + " VALUES (?,?,?,?,?,?,?);";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, atrac.getNombreAtraccion());
            ps.setInt(2, atrac.getIdAtraccion());
            ps.setString(3, atrac.getFechaInstalacion());
            ps.setDouble(4, atrac.getCapacidad());
            ps.setString(5, atrac.getSeccion());
            ps.setInt(6, atrac.getRangoEdad());
            ps.setDouble(7, atrac.getPrecioxPersona());
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public int actualizarAtraccion(Atracciones atrac) {
        int r = 0;
        String sql = "UPDATE atracciones SET NombreAtraccion=?, FechaInstalacion=?, Capacidad=?, Seccion=?,"
                + " EdadPermitida=?, "
                + "PrecioxPersona=?  WHERE Identificador=?";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, atrac.getNombreAtraccion());
            ps.setDouble(3, atrac.getCapacidad());
            ps.setInt(5, atrac.getRangoEdad());
            ps.setString(4, atrac.getSeccion());
            ps.setDouble(6, atrac.getPrecioxPersona());
            ps.setString(2, atrac.getFechaInstalacion());
            ps.setInt(7, atrac.getIdAtraccion());
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public int eliminarAtraccion(int id) {

        int r = 0;
        String sql = "DELETE FROM atracciones WHERE Identificador=" + id;

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public void filtrarTabla(JTable table, String Id) {

        String[] titulos = {"NOMBRE ATRACCION", "IDENTIFICADOR", "FECHA DE INSTALACION", "CAPACIDAD","SECCION", "EDAD PERMITIDA", "PRECIO INDIVIDUAL"};
        String[] datos = new String[7];
        String sql = "SELECT * FROM atracciones WHERE Identificador LIKE '%" + Id + "%'";
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                datos[0] = rs.getString("NombreAtraccion");
                datos[1] = rs.getString("Identificador");
                datos[2] = rs.getString("FechaInstalacion");
                datos[3] = rs.getString("Capacidad");
                datos[4] = rs.getString("Seccion");
                datos[5] = rs.getString("EdadPermitida");
                datos[6] = rs.getString("PrecioxPersona");
                modelo.addRow(datos);
            }

            table.setModel(modelo);

        } catch (SQLException e) {
            System.out.println("ERROR AL BUSCAR DATOS" + e.getMessage());
        }
    }
}
