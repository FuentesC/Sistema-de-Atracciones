/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Atracciones;
import Modelo.AtraccionesDAO;
import Vista.frmMantenimientoAtracciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dchac
 */
public class ControladorAtracciones implements ActionListener {
    
    frmMantenimientoAtracciones vistaAtracciones = new frmMantenimientoAtracciones();
    Atracciones a = new Atracciones();
    AtraccionesDAO dao = new AtraccionesDAO();
    
    public ControladorAtracciones(frmMantenimientoAtracciones frm) {
        
        this.vistaAtracciones = frm;
        this.vistaAtracciones.btnAgregar.addActionListener(this);        
        this.vistaAtracciones.btnBuscarTabla.addActionListener(this);
        this.vistaAtracciones.btnCancelarAtraccion.addActionListener(this);
        this.vistaAtracciones.btnActualizar.addActionListener(this);
        this.vistaAtracciones.btnRefrescar.addActionListener(this);
        this.vistaAtracciones.btnEliminarRegistro.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaAtracciones.btnAgregar) {
            if (vistaAtracciones.txtNombreAtraccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe agregar el nombre de la atracción");
            } else if (vistaAtracciones.txtIdAtraccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar el Id de la atracción");
            } else if (vistaAtracciones.txtCapacidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar la capacidad de la atrcción");
            } else if (vistaAtracciones.txtEdad.getText().isEmpty()){
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar la edad permitada para acceder a la atracción");
            } else if (vistaAtracciones.txtSeccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar la sección donde se encuentra la atracción");
            } else if (vistaAtracciones.txtPrecio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar el precio para acceder a la atracción");
            } else if (vistaAtracciones.txtFechaInstalacion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar la fecha de la instalación");
            }else {    
                agregarAtraccion();                
            }
        }
        
        if (e.getSource() == vistaAtracciones.btnActualizar) {
            if (vistaAtracciones.txtNombreAtraccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe de ingresar el nombre de la atraccion");
            } else if (vistaAtracciones.txtIdAtraccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar el Id de la atracción");
            } else if (vistaAtracciones.txtCapacidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar la capacidad de la atracción");
            } else if (vistaAtracciones.txtEdad.getText().isEmpty()){
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar la edad permitada para acceder a la atracción");
            } else if (vistaAtracciones.txtSeccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar la sección donde se encuentra la atracción");
            } else if (vistaAtracciones.txtPrecio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar el precio para acceder a la atracción");
            } else if (vistaAtracciones.txtFechaInstalacion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Debe ingresar la fecha de la instalación");
            }else {
                actualizarAtraccion();
            }
        }
        
        if (e.getSource() == vistaAtracciones.btnBuscarTabla) {
            String dato = JOptionPane.showInputDialog("Digite la identificacion de la atraccion");
            if (!dato.isEmpty()) {
                filtrarTabla(vistaAtracciones.tblAtracciones, dato);                
            }
        }
        
        if (e.getSource() == vistaAtracciones.btnRefrescar) {
            filtrarTabla(vistaAtracciones.tblAtracciones, "");
            limpiarCampos();
        }
        
        if (e.getSource() == vistaAtracciones.btnEliminarRegistro) {
            eliminarAtraccion();
        }
        if (e.getSource() == vistaAtracciones.btnCancelarAtraccion) {
            limpiarCampos();
        }
    }
    
    public void agregarAtraccion() {
        
        String nombreAtraccion = vistaAtracciones.txtNombreAtraccion.getText();        
        int Identificador = (Integer.parseInt(vistaAtracciones.txtIdAtraccion.getText()));        
        String fechaInstalacion = vistaAtracciones.txtFechaInstalacion.getText();
        double capacidad = (Double.parseDouble(vistaAtracciones.txtCapacidad.getText()));
        String seccion = vistaAtracciones.txtSeccion.getText();
        int rangoEdad = (Integer.parseInt(vistaAtracciones.txtEdad.getText()));
        double precioxPersona = (Double.parseDouble(vistaAtracciones.txtPrecio.getText()));        
        a.setNombreAtraccion(nombreAtraccion);
        a.setIdAtraccion(Identificador);
        a.setFechaInstalacion(fechaInstalacion);
        a.setCapacidad(capacidad);
        a.setSeccion(seccion);
        a.setRangoEdad(rangoEdad);
        a.setPrecioxPersona(precioxPersona);
        int r = dao.agregarAtraccion(a);
        
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaAtracciones, "ATRACCION AGREGADO CORRECTAMENTE ");
            filtrarTabla(vistaAtracciones.tblAtracciones, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaAtracciones, "ATRACCION NO AGREGADO CORRECTAMENTE ");
        }
    }
    
    public void actualizarAtraccion() {
        if (vistaAtracciones.txtIdAtraccion.getText().equals("")) {
            JOptionPane.showMessageDialog(vistaAtracciones, "Debe de seleccionar un registro en la tabla");
        } else {
            
            int identificador = (Integer.parseInt(vistaAtracciones.txtIdAtraccion.getText()));
            String nombreAtraccion = vistaAtracciones.txtNombreAtraccion.getText();
            String fechaInstalacion = vistaAtracciones.txtFechaInstalacion.getText();
            double capacidad = (Double.parseDouble(vistaAtracciones.txtCapacidad.getText()));
            String seccion = vistaAtracciones.txtSeccion.getText();
            Integer rangoEdad = (Integer.parseInt(vistaAtracciones.txtEdad.getText()));
            double precioxPersona = (Double.parseDouble(vistaAtracciones.txtPrecio.getText()));
            a.setIdAtraccion(identificador);
            a.setNombreAtraccion(nombreAtraccion);
            a.setFechaInstalacion(fechaInstalacion);
            a.setCapacidad(capacidad);
            a.setSeccion(seccion);
            a.setRangoEdad(rangoEdad);
            a.setPrecioxPersona(precioxPersona);
            int r = dao.actualizarAtraccion(a);
            if (r == 1) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Atracción actualizada con exito");
                filtrarTabla(vistaAtracciones.tblAtracciones, "");
                limpiarCampos();
                
            } else {
                JOptionPane.showMessageDialog(vistaAtracciones, "Atracción no actualizado con exito");
                
            }
        }
    }
    
    public void eliminarAtraccion() {
        
        int fila = vistaAtracciones.tblAtracciones.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaAtracciones, "Debe seleccionar un registro en la tabla");
        } else {
            int id = Integer.parseInt(vistaAtracciones.tblAtracciones.getValueAt(fila, 1).toString());
            int r = dao.eliminarAtraccion(id);
            if (r == 1) {
                JOptionPane.showMessageDialog(vistaAtracciones, "Se elimino un registro de la tabla");
                filtrarTabla(vistaAtracciones.tblAtracciones, "");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vistaAtracciones, "No se elimino un registro de la tabla");
            }
            
        }
        
    }
    
    public void limpiarCampos() {
        
        vistaAtracciones.txtIdAtraccion.setText("");
        vistaAtracciones.txtCapacidad.setText("");
        vistaAtracciones.txtIdAtraccion.setText("");
        vistaAtracciones.txtFechaInstalacion.setText("");
        vistaAtracciones.txtNombreAtraccion.setText("");
        vistaAtracciones.txtPrecio.setText("");
        vistaAtracciones.txtSeccion.setText("");
        vistaAtracciones.txtEdad.setText("");
    }

    public void filtrarTabla(JTable table, String filtro) {
        dao.filtrarTabla(table, filtro);
    }
    
    public void inicio() {
        filtrarTabla(vistaAtracciones.tblAtracciones, "");
    }
    
}
