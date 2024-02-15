package com.mycompany.cajeropersistencia.DTO;

/**
 *
 * @author TeLesheo
 */
public class TransaccionNuevaDTO {

    String fecha_hora;
    float cantidad;

    public TransaccionNuevaDTO() {
    }

    public TransaccionNuevaDTO(String fecha_hora, float cantidad) {
        this.fecha_hora = fecha_hora;
        this.cantidad = cantidad;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

}
