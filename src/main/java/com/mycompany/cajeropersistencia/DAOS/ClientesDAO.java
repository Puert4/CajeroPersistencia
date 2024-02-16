package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Cliente;
import com.mycompany.cajeropersistencia.DTO.ClienteNuevoDTO;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import com.mycompany.cajeropersistencia.conexion.IConexion;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeLesheo
 */
public class ClientesDAO implements IClientesDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public ClientesDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public Cliente agregar(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
        //Hacer un SP Aqui
        //o transactiondasdasdasdasdasdasdasdasdasdasda
        String sentenciaSQL = """
            INSERT INTO socios(nombres,apellido_paterno,apellido_materno, fecha_nacimiento)
            VALUES (?, ?, ?,?);""";
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, clienteNuevo.getNombres());
            comando.setString(2, clienteNuevo.getApellido_paterno());
            comando.setString(3, clienteNuevo.getApellido_materno());
            comando.setString(4, clienteNuevo.getFecha_nacimiento());

            int numeroRegistrosInsertados = comando.executeUpdate();

            logger.log(Level.INFO, "Se agregaro {0} cliente", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Cliente cliente = new Cliente(idsGenerados.getInt(1), clienteNuevo.getNombres(), clienteNuevo.getApellido_paterno(), clienteNuevo.getApellido_materno(), clienteNuevo.getFecha_nacimiento());
            return cliente;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo guardar el cliente", ex);
            throw new PersistenciaException("No se pudo guardar el cliente", ex);
        }

    }

    @Override
    public Cliente actualualizar_datos(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {

        String sentenciaSQL = """               
            UPDATE clientes SET nombres = ?,apellido_paterno = ?, apellido_materno = ? , fecha_nacimiento = ?
            WHERE id_cliente = ?""";
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, clienteNuevo.getNombres());
            comando.setString(2, clienteNuevo.getApellido_paterno());
            comando.setString(3, clienteNuevo.getApellido_materno());
            comando.setString(4, clienteNuevo.getFecha_nacimiento());

            int numeroRegistrosInsertados = comando.executeUpdate();

            logger.log(Level.INFO, "Se agregaro {0} cliente", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Cliente cliente = new Cliente(idsGenerados.getInt(1), clienteNuevo.getNombres(), clienteNuevo.getApellido_paterno(), clienteNuevo.getApellido_materno(), clienteNuevo.getFecha_nacimiento());
            return cliente;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo guardar el cliente", ex);
            throw new PersistenciaException("No se pudo guardar el cliente", ex);
        }
    }

}
