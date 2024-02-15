package com.mycompany.cajeropersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author TeLesheo
 */
public interface IConexion {

    Connection obtenerConexion() throws SQLException;
}
