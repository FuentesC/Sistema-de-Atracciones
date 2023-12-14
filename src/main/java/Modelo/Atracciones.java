/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



/**
 *
 * @author dchac
 */
public class Atracciones {
    
    Integer idAtraccion;
    String nombreAtraccion;
    String fechaInstalacion;
    Double capacidad;
    String seccion;
    Integer RangoEdad;
    Double precioxPersona;

    public Atracciones() {
    }
    
    

    public Atracciones(String nombreAtraccion, Integer idAtraccion,String fechaInstalacion, Double capacidad, String seccion, Integer RangoEdad, Double precioxPersona) {
        this.nombreAtraccion = nombreAtraccion;
        this.idAtraccion = idAtraccion;
        this.fechaInstalacion = fechaInstalacion;
        this.capacidad = capacidad;
        this.seccion = seccion;
        this.RangoEdad = RangoEdad;
        this.precioxPersona = precioxPersona;
    }

    public String getNombreAtraccion() {
        return nombreAtraccion;
    }

    public Integer getIdAtraccion() {
        return idAtraccion;
    }

    public String getFechaInstalacion() {
        return fechaInstalacion;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public String getSeccion() {
        return seccion;
    }

    public Integer getRangoEdad() {
        return RangoEdad;
    }

    public Double getPrecioxPersona() {
        return precioxPersona;
    }

    public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }

    public void setIdAtraccion(Integer idAtraccion) {
        this.idAtraccion = idAtraccion;
    }

    public void setFechaInstalacion(String fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setRangoEdad(Integer RangoEdad) {
        this.RangoEdad = RangoEdad;
    }

    public void setPrecioxPersona(Double precioxPersona) {
        this.precioxPersona = precioxPersona;
    }
    
    
    
    
    
    
}
