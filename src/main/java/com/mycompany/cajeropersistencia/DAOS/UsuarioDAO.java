package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Usuario;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
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
public class UsuarioDAO implements IUsuarioDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public UsuarioDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public Usuario agregaUsuario(UsuarioNuevoDTO usuarioNuevo) throws PersistenciaException {
        String sentenciaSQL = """
            INSERT INTO Usuarios(email, passcode)
            VALUES (?, ?);""";
        try (
                Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, usuarioNuevo.getEmail());
            comando.setString(2, usuarioNuevo.getPasscode_usuario());

            int numeroRegistrosInsertados = comando.executeUpdate();

            logger.log(Level.INFO, "Se agregaro {0} usuario", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();

            Usuario usuario = new Usuario(idsGenerados.getInt(1), usuarioNuevo.getPasscode_usuario(), usuarioNuevo.getEmail());
            return usuario;

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "No se pudo guardar el usuario", e);
            throw new PersistenciaException("No se pudo guardar el usuario", e);
        } 

    }

}
