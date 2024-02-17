/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeroentidades.DomicilioCliente;
import static com.mycompany.cajeropersistencia.DAOS.CuentaDAO.logger;
import com.mycompany.cajeropersistencia.DTO.DomicilioNuevoDTO;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import com.mycompany.cajeropersistencia.conexion.IConexion;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    public DomicilioCliente agregar(DomicilioNuevoDTO domicilioNuevoDTO) throws PersistenciaException {
        String sentenciaSQL = """
                INSERT INTO domiciliosclientes(codigo_postal,calle,numero_exterior,numero_interno,id_cliente) 
                VALUES (?,?,?,?,?);              
                              """;

        try (Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setInt(1, domicilioNuevoDTO.getCodigo_postal());
            comando.setString(2, domicilioNuevoDTO.getCalle());
            comando.setInt(2, domicilioNuevoDTO.getNumero_exterior());
            comando.setInt(3, domicilioNuevoDTO.getNumero_interior());
            comando.setInt(4, domicilioNuevoDTO.getId_cliente());

            int numeroRegistrosInsertados = comando.executeUpdate();

            logger.log(Level.INFO, "Se agregó {0} cuenta", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            DomicilioCliente domicilioCliente = new DomicilioCliente
        (idsGenerados.getInt(1),domicilioNuevoDTO.getCalle(),domicilioNuevoDTO.getNumero_interior(),
                domicilioNuevoDTO.getNumero_exterior(),domicilioNuevoDTO.getId_cliente(),domicilioNuevoDTO.getCodigo_postal());
            return domicilioCliente;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudo guardar la cuenta", e);
            throw new PersistenciaException("No se pudo guardar la cuenta", e);
        }

    }

    @Override
    public DomicilioCliente actualizar_domicilio(DomicilioNuevoDTO DomicilioNuevo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
