
package Modelo;


public class seguimientoAtracciones {
    
    private String atraccion;
    private String enteRevisor;
    private String fechaRevision;
    private String descripcionError;
    private String comentario;
    
    public seguimientoAtracciones() {
        
    }

    public seguimientoAtracciones(String atraccion, String enteRevisor, String fechaRevision, String descripcionError, String comentario) {
        this.atraccion = atraccion;
        this.enteRevisor = enteRevisor;
        this.fechaRevision = fechaRevision;
        this.descripcionError = descripcionError;
        this.comentario = comentario;
    }

    public String getAtraccion() {
        return atraccion;
    }

    public void setAtraccion(String atraccion) {
        this.atraccion = atraccion;
    }

    public String getEnteRevisor() {
        return enteRevisor;
    }

    public void setEnteRevisor(String enteRevisor) {
        this.enteRevisor = enteRevisor;
    }

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
