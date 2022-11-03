package dao.implementacion_dao;

import dao.ITurnoDao;
import modelos.Paciente;
import modelos.Turno;
import org.apache.log4j.Logger;
import utilidad.ConexionBaseDeDatos;

import java.sql.*;
import java.util.ArrayList;
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

        queryInsert.setInt(1, turno.getIdOdontologo());
        queryInsert.setInt(2, turno.getIdPaciente());
        queryInsert.setTimestamp(3, Timestamp.valueOf(turno.getFechaTurno()));

        queryInsert.execute();
        LOGGER.info("¡Turno creado con exito!");
        queryInsert.close();
        getConexcion().close();

        return null;
    }

    @Override
    public List<Turno> listar() {

        List<Turno> turnos = new ArrayList<>();

        try(Statement stmt = getConexcion().createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * FROM turno");
            while (rs.next()){
               Turno turno = new Turno();
               turno.setIdPaciente(rs.getInt(1));
               turno.setIdOdontologo(rs.getInt(2));
               turno.setFechaTurno(rs.getTimestamp(3).toLocalDateTime());
               turnos.add(turno);

            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return turnos;

    }

    @Override
    public void modificar(Turno turno) {

        try (PreparedStatement stmt = getConexcion().prepareStatement("UPDATE turno set idPaciente = ?, idOdontologo= ?, fechaTurno = ?,  where idTurno = ?")){
            stmt.setInt(1, turno.getIdPaciente());
            stmt.setInt(2, turno.getIdOdontologo());
            stmt.setTimestamp(3, Timestamp.valueOf(turno.getFechaTurno()));
            stmt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        LOGGER.info("¡Turno actualizado con exito!");
    }

    @Override
    public void eliminar(int id) {

        try (PreparedStatement stmt = getConexcion().prepareStatement("DELETED FROM turno WHERE idTurno = ?")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        LOGGER.info("¡Turno eliminado con éxito!");
    }
}
