package com.mycompany.cajeropersistencia.DTO;

/**
 *
 * @author TeLesheo
 */
public class TransferenciaNuevaDTO {

    private int id_remitente;
    private int id_destino;

    public TransferenciaNuevaDTO() {
    }

    public TransferenciaNuevaDTO(int id_remitente, int id_destino) {
        this.id_remitente = id_remitente;
        this.id_destino = id_destino;
    }

    public int getId_remitente() {
        return id_remitente;
    }

    public void setId_remitente(int id_remitente) {
        this.id_remitente = id_remitente;
    }

    public int getId_destino() {
        return id_destino;
    }

    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
    }

}
