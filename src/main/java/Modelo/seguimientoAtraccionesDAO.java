
package Modelo;

import Vista.frmSeguimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class seguimientoAtraccionesDAO {
    
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    Conexion conectar = new Conexion();
    frmSeguimiento frmS = new frmSeguimiento();
    
    public int eliminarAtraccion(String nombre) {
        int o = 0;
        String sql = "DELETE FROM seguimientoatraccion WHERE Atraccion='"+nombre+"';";
        
        try {
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            o = ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar "+e.getMessage());
        }
        return o;
    }
    
    public int agregarErrores(seguimientoAtracciones SeguimientoAtracciones){
        int p = 0;
        String sql = "INSERT INTO seguimientoatraccion (Atraccion, Revisor, FechaRevision, DescripcionError, Comentario) "
                + "VALUES (?, ?, ?, ?, ?);";
        try {
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,SeguimientoAtracciones.getAtraccion());
            ps.setString(2, SeguimientoAtracciones.getEnteRevisor());
            ps.setString(3, SeguimientoAtracciones.getFechaRevision());
            ps.setString(4, SeguimientoAtracciones.getDescripcionError());
            ps.setString(5, SeguimientoAtracciones.getComentario());
            p = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("seguimiento incorrecto"+e.getMessage());
        }
        return p;
    }

    public void mostrarAtracciones(JTable table, String filtro) {
        
        String[] titulos = {"NOMBRE ATRACCIÓN", "IDENTIFICACIÓN", "FECHA DE INSTALACIÓN", "CAPACIDAD", "SECCIÓN", 
            "EDAD PERMITIDA", "PRECIO INDIVIDUAL"};
        String[] datos = new String[7];
        String sql = "SELECT * FROM atracciones WHERE Identificador LIKE '%"+filtro+"%';";
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        
        try {
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
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
            System.out.println("Error al traer los datos");
        }
    }
    
    public void tablaErrores(JTable tabla, String filt) {
        String[] titulos = {"ATRACCIÓN", "REVISOR", "FECHA", "ERROR", "COMENTARIO"};
        String[] datos = new String[5];
        String sql = "SELECT * FROM seguimientoatraccion WHERE Atraccion LIKE '%"+filt+"%';";
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        
        try {
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                datos[0] = rs.getString("Atraccion");
                datos[1] = rs.getString("Revisor");
                datos[2] = rs.getString("FechaRevision");
                datos[3] = rs.getString("DescripcionError");
                datos[4] = rs.getString("Comentario");
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            
        } catch (SQLException e) {
            System.out.println("Error al traer los datos");
        }
    }
}


