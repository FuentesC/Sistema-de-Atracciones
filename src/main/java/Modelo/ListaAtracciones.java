
package Modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Vista.frmListaAtracciones;

public class ListaAtracciones extends javax.swing.JInternalFrame implements ActionListener {
    
    ResultSet rs;
    PreparedStatement ps;
    Connection con;
    Conexion conectar = new Conexion();
    frmListaAtracciones frmLA = new frmListaAtracciones();
    
    public ListaAtracciones (frmListaAtracciones frm) {   
        this.frmLA = frm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLA.lblListado) {
            inicio();
        }
    }
    
    public void mostrarListaAtracciones(JTable table, String filtro){
        
        String[] titulos = {"NOMBRE ATRACCIÓN", "IDENTIFICACIÓN", "FECHA DE INSTALACIÓN", "CAPACIDAD", "SECCIÓN", 
            "EDAD PERMITIDA", "PRECIO INDIVIDUAL"};
        String[] datos = new String[7];
        String sql = "SELECT * FROM atracciones WHERE Identificador LIKE '%"+filtro+"%';";
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
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
            System.out.println("Error al traer los datos"+e.getMessage());
        }
    }
    
    public void inicio() {
        mostrarListaAtracciones(frmLA.tableListaAtracciones, "");
    }
}
