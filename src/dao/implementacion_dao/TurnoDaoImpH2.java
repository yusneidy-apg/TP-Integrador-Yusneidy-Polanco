package dao.implementacion_dao;

import dao.ITurnoDao;
import modelos.Turno;
import org.apache.log4j.Logger;
import utilidad.ConexionBaseDeDatos;

import java.sql.*;
import java.util.List;

public class TurnoDaoImpH2 implements ITurnoDao {

    private static final Logger LOGGER = Logger.getLogger(TurnoDaoImpH2.class);

    private final static String CREATE_TABLE_TURNO = "create table if not exists turno " +
            "(idTurno int auto_increment primary key," +
            "idOdontologo int," +
            "idPaciente int,"+
            "fechaTurno DATE);";

    public Connection getConexcion() throws SQLException, ClassNotFoundException {
        return ConexionBaseDeDatos.obtenerConexion();
    }

    @Override
    public Turno crear(Turno turno) throws SQLException, ClassNotFoundException {
        Statement stmtCrearTabla = getConexcion().createStatement();
        stmtCrearTabla.execute(CREATE_TABLE_TURNO);

        PreparedStatement queryInsert = getConexcion().prepareStatement("INSERT INTO turno " +
                "(idOdontologo,idPaciente,fechaTurno) " +
                "VALUES(?, ?, ?)");

        queryInsert.setString(1, turno.getIdOdontologo());
        queryInsert.setString(2, turno.getIdPaciente());
        queryInsert.setTimestamp(3, Timestamp.valueOf(turno.getFechaTurno()));

        queryInsert.execute();
        LOGGER.info("¡Turno creado con exito!");
        queryInsert.close();
        getConexcion().close();

        return null;
    }

    @Override
    public List<Turno> listar() {
        return null;
    }

    @Override
    public void modificar(int id) {

    }

    @Override
    public void eliminar(int id) {

    }
}
