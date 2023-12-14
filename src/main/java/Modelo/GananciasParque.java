/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Vista.frmGananciasParque;

/**
 *
 * @author jobrizue
 */


public class GananciasParque extends javax.swing.JInternalFrame implements ActionListener {
    
    ResultSet rs;
    PreparedStatement ps;
    Connection con;
    Conexion conectar = new Conexion();
    frmGananciasParque frmGP = new frmGananciasParque();
    
    public GananciasParque (frmGananciasParque frm) {   
        this.frmGP = frm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmGP.lblGananciasParque) {
            inicio();
        }
    }
    
    public void mostrarGananciasParque(JTable table){
        
        String[] titulos = {"NOMBRE DE ATRACCIÓN", "ID DE ATRACCIÓN"};
        String[] datos = new String[2];
        String sql = "SELECT NombreAtraccion, Identificador FROM atracciones;";
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos[0] = rs.getString("NombreAtraccion");
                datos[1] = rs.getString("Identificador");
                modelo.addRow(datos);
            }
            table.setModel(modelo);
            
        } catch (SQLException e) {
            System.out.println("Error 1 al traer los datos"+e.getMessage());
        }
    }
    
    public void mostrarTablaBookeo (JTable table) {
        
        String[] titulos = {"FECHA DE VISITA", "CANTIDAD DE TIQUETES", "CANTIDAD DE PASES ESPECIALES"
        , "RECAUDACIÓN TOTAL", "TOTAL DE PERSONAS"};
        String[] datos = new String[5];
        String sql = "SELECT FechaVisita, TiquetesVendidos, PaseEspecial, TotalVenta, TotalPersonas "
                + "FROM bookeoatraccion;";
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                datos[0] = rs.getString("FechaVisita");
                datos[1] = rs.getString("TiquetesVendidos");
                datos[2] = rs.getString("PaseEspecial");
                datos[3] = rs.getString("TotalVenta");
                datos[4] = rs.getString("TotalPersonas");
                modelo.addRow(datos);
            }
            table.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("Error 2 al trar los datos");
        }
    }
    
    public void inicio() {
        mostrarGananciasParque(frmGP.tableAtracciones);
    }
    
    public void inicio2() {
        mostrarTablaBookeo(frmGP.tableBookeo);
    }
}
