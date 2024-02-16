/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.DomicilioCliente;
import com.mycompany.cajeropersistencia.DTO.DomicilioNuevoDTO;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;

/**
 *
 * @author TeLesheo
 */
public interface IDomicilioDAO {
    DomicilioCliente agregar(DomicilioNuevoDTO DomicilioNuevo)throws PersistenciaException;
    DomicilioCliente actualizar_domicilio(DomicilioNuevoDTO DomicilioNuevo) throws PersistenciaException;
}
