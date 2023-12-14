/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuarios;
import Modelo.UsuariosDAO;
import Vista.frmRegistroUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author !Core¡
 */
public class ControladorUsuarios implements  ActionListener{
    
    frmRegistroUsuarios frmR = new frmRegistroUsuarios();
    UsuariosDAO udao = new UsuariosDAO();
    Usuarios u = new Usuarios();
    
    public ControladorUsuarios(frmRegistroUsuarios frm) {
        frmR = frm;
        this.frmR.btnGuardar.addActionListener(this);
        this.frmR.btnActualizar.addActionListener(this);
        this.frmR.btnCancelar.addActionListener(this);
        this.frmR.btnEliminar.addActionListener(this);
        this.frmR.btnBuscar.addActionListener(this);
        this.frmR.btnRefrescar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmR.btnCancelar) {
            limpiar();
        }
        
        if (e.getSource() == frmR.btnEliminar) {
            eliminarUsuario();
        }
        
        if (e.getSource() == frmR.btnBuscar) {
            filtrarPorNombre(frmR.tableUsuarios, frmR.txtBuscarPorNombre.getText());
        }
        
        if (e.getSource() == frmR.btnRefrescar) {
            filtrarPorNombre(frmR.tableUsuarios, "");
            limpiar();
        }
        
        if (e.getSource() == frmR.btnGuardar) {
            if (frmR.txtCedula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese la cedula del usuario");
            } else if (frmR.txtContrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese la contraseña del usuario");
            } else if (frmR.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese el nombre de usuario");
            }else if (frmR.txtApellido1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese el primer apellido del usuario");
            } else if (frmR.txtApellido2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese el segundo apellido del usuario");
            } else {
                guardarUsuario();
            }
        }
        
        if (e.getSource() == frmR.btnActualizar) {
            if (frmR.txtCedula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese la cedula del usuario");
            } else if (frmR.txtContrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese la contraseña del usuario");
            }  else if (frmR.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese el nombre de usuario");
            }else if (frmR.txtApellido1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese el primer apellido del usuario");
            } else if (frmR.txtApellido2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmR, "Ingrese el segundo apellido del usuario");
            } else {
                actualizarUsuario();
            }
        }
    }
    
    public void guardarUsuario() {
        int cedula = Integer.parseInt(frmR.txtCedula.getText());
        String contrasena = frmR.txtContrasena.getText();
        String nombre = frmR.txtNombre.getText();
        String apellido1 = frmR.txtApellido1.getText();
        String apellido2 = frmR.txtApellido2.getText();
        String tipoUsuario = frmR.cbTipoUsuario.getSelectedItem().toString();
        u.setCedula(cedula);
        u.setContrasena(contrasena);
        u.setNombre(nombre);
        u.setApellido1(apellido1);
        u.setApellido2(apellido2);
        u.setTipoUsuario(tipoUsuario);
        int o = udao.agregarUsuario(u);
        
        if (o == 1) {
            JOptionPane.showMessageDialog(frmR, "El usuario se guardó correctamente");
            filtrarPorNombre(frmR.tableUsuarios, "");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(frmR, "El usuario no se pudo guardar");
        }
    }
    
    public void actualizarUsuario() {
        int cedula = Integer.parseInt(frmR.txtCedula.getText());
        String contrasena = frmR.txtContrasena.getText();
        String nombre = frmR.txtNombre.getText();
        String apellido1 = frmR.txtApellido1.getText();
        String apellido2 = frmR.txtApellido2.getText();
        String tipoUsuario = frmR.cbTipoUsuario.getSelectedItem().toString();
        u.setCedula(cedula);
        u.setContrasena(contrasena);
        u.setNombre(nombre);
        u.setApellido1(apellido1);
        u.setApellido2(apellido2);
        u.setTipoUsuario(tipoUsuario);
        int o = udao.actualizarUsuario(u);
        
        if (o == 1) {
            JOptionPane.showMessageDialog(frmR, "El usuario se actualizó correctamente");
            filtrarPorNombre(frmR.tableUsuarios, "");
            limpiar();
        } else {
         JOptionPane.showMessageDialog(frmR, "El usuario no se pudo actualizar");
        }   
    }
    
    public void eliminarUsuario() {
        int fila = frmR.tableUsuarios.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(frmR, "Seleccione un usuario para eliminar");
        } else {
            int cedula = Integer.parseInt(frmR.tableUsuarios.getValueAt(fila, 0).toString());
            int o = udao.eliminarUsuario(cedula);
            if (o == o) {
                JOptionPane.showMessageDialog(frmR, "Usuario eliminado correctamente");
                filtrarPorNombre(frmR.tableUsuarios, "");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(frmR, "El usuario no se pudo eliminar");
            }
        }
    }
    
    public void limpiar() {
        frmR.txtCedula.setText(null);
        frmR.txtContrasena.setText(null);
        frmR.txtNombre.setText(null);
        frmR.txtApellido1.setText(null);
        frmR.txtApellido2.setText(null);
        frmR.cbTipoUsuario.setSelectedIndex(0);
        frmR.txtBuscarPorNombre.setText(null);
    }
    
    public void inicio(){
        filtrarPorNombre(frmR.tableUsuarios, "");
        limpiar();
    }
    
    public void filtrarPorNombre(JTable table, String filtro) {
        udao.filtrarPorNombre(table, filtro);
    }
    
}
