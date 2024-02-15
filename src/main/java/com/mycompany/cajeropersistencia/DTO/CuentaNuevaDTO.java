package com.mycompany.cajeropersistencia.DTO;

/**
 *
 * @author TeLesheo
 */
public class CuentaNuevaDTO {

    private float saldo_mxn;
    private String estado_cuenta;
    private String fecha_apertura;

    public CuentaNuevaDTO() {
    }

    public CuentaNuevaDTO(float saldo_mxn, String estado_cuenta, String fecha_apertura) {
        this.saldo_mxn = saldo_mxn;
        this.estado_cuenta = estado_cuenta;
        this.fecha_apertura = fecha_apertura;
    }

    public float getSaldo_mxn() {
        return saldo_mxn;
    }

    public void setSaldo_mxn(float saldo_mxn) {
        this.saldo_mxn = saldo_mxn;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

}
