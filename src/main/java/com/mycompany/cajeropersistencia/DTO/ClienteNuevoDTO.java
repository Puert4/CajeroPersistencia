package com.mycompany.cajeropersistencia.DTO;

/**
 *
 * @author TeLesheo
 */
public class ClienteNuevoDTO {

    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;

    ClienteNuevoDTO() {
    }

    public ClienteNuevoDTO(String nombres, String apellido_paterno, String apellido_materno) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

}
