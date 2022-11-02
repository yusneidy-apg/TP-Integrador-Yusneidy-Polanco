package dao.implementacion_dao;

import dao.IOdontologoDao;
import modelos.Odontologo;
import org.apache.log4j.Logger;
import utilidad.ConexionBaseDeDatos;

import java.sql.*;
import java.util.List;

public class OdontologoDaoImpH2 implements IOdontologoDao {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoImpH2.class);

    private final static String CREATE_TABLE_ODONTOLOGO = "create table if not exists odontologo " +
            "(idOdontologo int auto_increment primary key," +
            "nombre varchar(255)," +
            "apellido varchar(255),"+
            "matricula varchar(255),";

    public Connection getConexcion() throws SQLException, ClassNotFoundException {
        return ConexionBaseDeDatos.obtenerConexion();
    }

    @Override
    public Odontologo crear(Odontologo odontologo) throws SQLException, ClassNotFoundException {

        Statement stmtCrearTabla = getConexcion().createStatement();
        stmtCrearTabla.execute(CREATE_TABLE_ODONTOLOGO);


        PreparedStatement queryInsert = getConexcion().prepareStatement("INSERT INTO odontologo " +
                "(nombre,apellido,matricula) " +
                "VALUES(?, ?, ?)");

        queryInsert.setString(1, odontologo.getNombre());
        queryInsert.setString(2, odontologo.getApellido());
        queryInsert.setString(3, odontologo.getMatricula());


        queryInsert.execute();
        LOGGER.info("¡Odontologo creado con exito!");
        queryInsert.close();
        getConexcion().close();

        return null;
    }

    @Override
    public List<Odontologo> listar() {
        return null;
    }

    @Override
    public void modificar(int id) {

    }

    @Override
    public void eliminar(int id) {

    }
}
