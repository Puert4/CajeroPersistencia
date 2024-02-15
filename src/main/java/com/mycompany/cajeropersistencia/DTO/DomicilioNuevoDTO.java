package com.mycompany.cajeropersistencia.DTO;

/**
 *
 * @author TeLesheo
 */
public class DomicilioNuevoDTO {

    private String calle;
    private int numero_interior;
    private int numero_exterior;
    private int id_cliente;
    private int codigo_postal;

    public DomicilioNuevoDTO() {
    }

    public DomicilioNuevoDTO(String calle, int numero_interior, int numero_exterior, int id_cliente, int codigo_postal) {
        this.calle = calle;
        this.numero_interior = numero_interior;
        this.numero_exterior = numero_exterior;
        this.id_cliente = id_cliente;
        this.codigo_postal = codigo_postal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero_interior() {
        return numero_interior;
    }

    public void setNumero_interior(int numero_interior) {
        this.numero_interior = numero_interior;
    }

    public int getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(int numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

}
