/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Usuario;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;

/**
 *
 * @author TeLesheo
 */
public interface IUsuarioDAO {
     public Usuario agregaUsuario(UsuarioNuevoDTO usuarioNuevo) throws PersistenciaException;
}
