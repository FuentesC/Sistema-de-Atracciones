package Modelo;

/**
 *
 * @author dchac
 */
public class Bookeo {

    int paseEspecial;
    String fechaVenta;
    String FechaVisita;
    Double TotalVenta;
    int tiquetesVendidos;
    int totalPersonas;

    public Bookeo() {
    }

    public Bookeo(int paseEspecial, String fechaVenta, String FechaVisita, Double TotalVenta, int tiquetesVendidos, int totalPersonas) {
        this.paseEspecial = paseEspecial;
        this.fechaVenta = fechaVenta;
        this.FechaVisita = FechaVisita;
        this.TotalVenta = TotalVenta;
        this.tiquetesVendidos = tiquetesVendidos;
        this.totalPersonas = totalPersonas;
    }

    public int getPaseEspecial() {
        return paseEspecial;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public String getFechaVisita() {
        return FechaVisita;
    }

    public Double getTotalVenta() {
        return TotalVenta;
    }

    public int getTiquetesVendidos() {
        return tiquetesVendidos;
    }

    public int getTotalPersonas() {
        return totalPersonas;
    }

    public void setPaseEspecial(int paseEspecial) {
        this.paseEspecial = paseEspecial;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setFechaVisita(String FechaVisita) {
        this.FechaVisita = FechaVisita;
    }

    public void setTotalVenta(Double TotalVenta) {
        this.TotalVenta = TotalVenta;
    }

    public void setTiquetesVendidos(int tiquetesVendidos) {
        this.tiquetesVendidos = tiquetesVendidos;
    }

    public void setTotalPersonas(int totalPersonas) {
        this.totalPersonas = totalPersonas;
    }
}
