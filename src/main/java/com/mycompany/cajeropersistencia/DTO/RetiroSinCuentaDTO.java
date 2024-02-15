package com.mycompany.cajeropersistencia.DTO;

/**
 *
 * @author TeLesheo
 */
public class RetiroSinCuentaDTO {

    private String folio;
    private String estado;

    public RetiroSinCuentaDTO() {
    }

    public RetiroSinCuentaDTO(String folio, String estado) {
        this.folio = folio;
        this.estado = estado;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
