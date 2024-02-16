/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Usuario;
import com.mycompany.cajeropersistencia.DTO.UsuarioNuevoDTO;
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
public class UsuarioDAO implements IUsuarioDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public UsuarioDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public Usuario agregaUsuario(UsuarioNuevoDTO usuarioNuevo) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO Usuario (email,passcode) VALUES(?,?)";
        try {

            Connection conexion = conexionBD.obtenerConexion();
            PreparedStatement statement = conexion.prepareStatement(sentenciaSQL);
            statement.setString(1, usuarioNuevo.getEmail());
            statement.setString(2, usuarioNuevo.getPasscode());

        } catch (SQLException e) {

            logger.log(Level.SEVERE, "Error al ejecutar la consulta SQL", e);
            throw new PersistenciaException("Error al ejecutar la consulta SQL", e);
        } finally {

            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    logger.log(Level.SEVERE, "Error al cerrar la conexión a la base de datos", e);
                }
            }

        }
