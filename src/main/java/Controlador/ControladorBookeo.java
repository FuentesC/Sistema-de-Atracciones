/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bookeo;
import Modelo.BookeoDAO;
import Vista.frmBookeo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author dchac
 */
public class ControladorBookeo implements ActionListener {

    Bookeo b = new Bookeo();
    BookeoDAO dao = new BookeoDAO();
    frmBookeo frmb = new frmBookeo();

    public ControladorBookeo(frmBookeo frm) {

        this.frmb = frm;
        this.frmb.btnAgregarCompra.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmb.btnAgregarCompra) {
            if (frmb.txtFechaVenta.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmb, "Debe agregar los pases especiales");
            } else if (frmb.txtFechaVenta.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmb, "Debe agregar la fecha de venta");
            } else if (frmb.txtFechaVisita.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmb, "Debe agregar la fecha de visita");
            } else {
                AgregarVenta();
            }
        }

    }

    public void AgregarVenta() {

        int paseEspecial = (Integer.parseInt(frmb.txtTotalPases.getText()));
        String FechaVenta = frmb.txtFechaVenta.getText();
        String FechaVisita = frmb.txtFechaVisita.getText();
        double TotalVenta = (Double.parseDouble(frmb.txtTotalVenta.getText()));
        int tiquetesVendidos = (frmb.jsTickets.getComponentCount()) + 1;
        int totalPersonas = paseEspecial + tiquetesVendidos;
        b.setPaseEspecial(paseEspecial);
        b.setFechaVenta(FechaVenta);
        b.setFechaVisita(FechaVisita);
        b.setTotalVenta(TotalVenta);
        b.setTiquetesVendidos(tiquetesVendidos);
        b.setTotalPersonas(totalPersonas);
        int c = dao.agregarventa(b);
        if (c == 1) {
            JOptionPane.showMessageDialog(frmb, "La venta se guardó correctamente");
            filtrarTabla(frmb.tableListaAtracciones, "");
        } else {
            JOptionPane.showMessageDialog(frmb, "La venta no se puedo agregar ");
        }
    }

    public void filtrarTabla(JTable table, String filtro) {
        dao.mostrarAtracciones(table, filtro);
    }

    public void inicio() {
        filtrarTabla(frmb.tableListaAtracciones, "");
    }

}
