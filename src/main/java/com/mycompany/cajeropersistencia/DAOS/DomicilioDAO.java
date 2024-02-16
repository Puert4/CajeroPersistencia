/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.DomicilioCliente;
import static com.mycompany.cajeropersistencia.DAOS.CuentaDAO.logger;
import com.mycompany.cajeropersistencia.DTO.DomicilioNuevoDTO;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import com.mycompany.cajeropersistencia.conexion.IConexion;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeLesheo
 */
public class DomicilioDAO implements IDomicilioDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public DomicilioDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public DomicilioCliente agregar(DomicilioNuevoDTO DomicilioNuevo) throws PersistenciaException {
        String sentenciaSQL = """
                INSERT INTO domiciliosclientes(codigo_postal,calle,numero_exterior,numero_interno) 
                VALUES (?,?,?,?,?);              
                              """;

        try (Connection conexion = this.conexionBD,.obtenerConexion(); 
                ) {
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudo guardar domicilio", e);
            throw new PersistenciaException("No se pudo guardar el domicilio", e);
        }

        return null;

    }

    @Override
    public DomicilioCliente actualizar_domicilio(DomicilioNuevoDTO DomicilioNuevo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
