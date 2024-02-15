/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Cliente;
import com.mycompany.cajeropersistencia.DTO.ClienteNuevoDTO;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
//import java.util.List;

/**
 *
 * @author TeLesheo
 */
public interface IClientesDAO {
       Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException;
//    List<Cliente> consultar() throws PersistenciaException;
       Cliente actualualizar_datos(ClienteNuevoDTO clienteNuevo) throws PersistenciaException;
}
