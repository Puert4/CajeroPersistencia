package com.mycompany.cajeropersistencia.DAOS;

import com.mycompany.cajeroentidades.Cuenta;
import com.mycompany.cajeropersistencia.DTO.CuentaNuevaDTO;
import com.mycompany.cajeropersistencia.conexion.Conexion;
import com.mycompany.cajeropersistencia.conexion.IConexion;
import com.mycompany.cajeropersistencia.exceptions.PersistenciaException;
import com.mycompany.cajeropersistencia.exceptions.ValidacionDTOException;
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
public class CuentaDAO implements ICuentaDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    public CuentaDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public Cuenta agregar(CuentaNuevaDTO cuentaNuevaDTO) throws PersistenciaException, ValidacionDTOException {
        String sentenciaSQL = """
            INSERT INTO cuentas(saldo_mxn, estado_cuenta, fecha_apertura)
            VALUES (?, ?, ?);""";
        try (Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setFloat(1, cuentaNuevaDTO.getSaldo_mxn());
            comando.setString(2, cuentaNuevaDTO.getEstado_cuenta());
            comando.setString(3, cuentaNuevaDTO.getFecha_apertura());

            int numeroRegistrosInsertados = comando.executeUpdate();

            logger.log(Level.INFO, "Se agregó {0} cuenta", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Cuenta cuenta = new Cuenta(idsGenerados.getInt(1), cuentaNuevaDTO.getSaldo_mxn(), cuentaNuevaDTO.getEstado_cuenta(), cuentaNuevaDTO.getFecha_apertura());
            return cuenta;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudo guardar la cuenta", e);
            throw new PersistenciaException("No se pudo guardar la cuenta", e);
        }
    }

    @Override
    public void cancelar(int idCuenta) throws PersistenciaException, ValidacionDTOException {
        String sentenciaSQL = "DELETE FROM cuentas WHERE id_cuenta = ?";
        try (Connection conexion = this.conexionBD.obtenerConexion(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
            comando.setInt(1, idCuenta);

            int numeroRegistrosEliminados = comando.executeUpdate();

            logger.log(Level.INFO, "Se canceló {0} cuenta", numeroRegistrosEliminados);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo cancelar la cuenta", ex);
            throw new PersistenciaException("No se pudo cancelar la cuenta", ex);
        }
    }
}
