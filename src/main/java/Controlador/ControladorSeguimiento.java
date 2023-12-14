
package Controlador;

import Modelo.seguimientoAtracciones;
import Modelo.seguimientoAtraccionesDAO;
import Vista.frmSeguimiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorSeguimiento implements ActionListener{
    seguimientoAtracciones seguiAtracciones = new seguimientoAtracciones();
    seguimientoAtraccionesDAO seguiAtraccionesDAO = new seguimientoAtraccionesDAO();
    frmSeguimiento frmS = new frmSeguimiento();
    
    public ControladorSeguimiento( frmSeguimiento frm){
        frmS = frm;
        this.frmS.btnCancelar.addActionListener(this);
        this.frmS.btnSeguimiento.addActionListener(this);
        this.frmS.btnEliminar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmS.btnSeguimiento) {
            if (frmS.txtAtraccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmS, "Ingrese la el nombre de la atracción para continuar");
            } else if (frmS.txtFecha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmS, "Ingrese la fecha en la que se da el seguimiento");
            } else if (frmS.txtError.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmS, "Ingres el error de la atracción");
            } else if (frmS.txtComentario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmS, "Ingrese un comentario para continuar");
            }else {
                guardarError();
            }
        }
        
        if (e.getSource() == frmS.btnCancelar) {
            limpiar();
        }
        
        if (e.getSource()== frmS.btnEliminar) {
            eliminar();
        }
    }

    private void eliminar() {
        int fila = frmS.tableErrores.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(frmS, "Seleccione un seguimiento para eliminar");
        } else {
            String nombre = frmS.tableErrores.getValueAt(fila, 0).toString();
            int p = seguiAtraccionesDAO.eliminarAtraccion(nombre);
            if (p == p) {
                JOptionPane.showMessageDialog(frmS, "Seguimiento eliminado correctamente");
                inicio2();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(frmS, "El seguimiento no se pudo eliminar");
            }
        }
    }
    
    private void limpiar() {
        frmS.txtAtraccion.setText(null);
        frmS.cbTipoUsuario.setSelectedIndex(0);
        frmS.txtFecha.setText(null);
        frmS.txtError.setText(null);
        frmS.txtComentario.setText(null);
    }
    

    private void guardarError() {
        String atraccion = frmS.txtAtraccion.getText();
        String revisor = frmS.cbTipoUsuario.getSelectedItem().toString();
        String fecha = frmS.txtFecha.getText();
        String error = frmS.txtError.getText();
        String comentario = frmS.txtComentario.getText();
        seguiAtracciones.setAtraccion(atraccion);
        seguiAtracciones.setEnteRevisor(revisor);
        seguiAtracciones.setFechaRevision(fecha);
        seguiAtracciones.setDescripcionError(error);
        seguiAtracciones.setComentario(comentario);
        int o = seguiAtraccionesDAO.agregarErrores(seguiAtracciones);
        
        if (o == 1) {
            JOptionPane.showMessageDialog(frmS, "Se dió seguimiento a una atracción");
            limpiar();
            inicio2();
        } else {
            JOptionPane.showMessageDialog(frmS, "No se pudo dar seguimiento a la atracción");
        }
    }
    
    public void inicio() {
        seguiAtraccionesDAO.mostrarAtracciones(frmS.tableAtracciones, "");
    }
    
    public void inicio2() {
        seguiAtraccionesDAO.tablaErrores(frmS.tableErrores, "");
    }
}
