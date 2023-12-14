/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.frmBookeo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dchac
 */
public class BookeoDAO {

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    Conexion conectar = new Conexion();
    frmBookeo frmb = new frmBookeo();

    public void mostrarAtracciones(JTable table, String filtro) {

        String[] titulos = {"NOMBRE ATRACCIÓN", "IDENTIFICACIÓN", "FECHA DE INSTALACIÓN", "CAPACIDAD", "SECCIÓN",
            "EDAD PERMITIDA", "PRECIO INDIVIDUAL"};
        String[] datos = new String[7];
        String sql = "SELECT * FROM atracciones WHERE Identificador LIKE '%" + filtro + "%';";
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);

        try {
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
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
            System.out.println("Error al traer los datos");
        }
    }

    public int agregarventa(Bookeo bookeo) {
        int p = 0;
        String sql = "INSERT INTO bookeoatraccion (PaseEspecial, FechaVenta, FechaVisita, TotalVenta, TiquetesVendidos, "
                + "TotalPersonas) "
                + "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bookeo.getPaseEspecial());
            ps.setString(2, bookeo.getFechaVenta());
            ps.setString(3, bookeo.getFechaVisita());
            ps.setDouble(4, bookeo.getTotalVenta());
            ps.setInt(5, bookeo.getTiquetesVendidos());
            ps.setInt(6, bookeo.getTotalPersonas());
            p = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return p;
    }

}
