package dao;

import modelos.Odontologo;

import java.sql.SQLException;
import java.util.List;

public interface IOdontologoDao {

    Odontologo crear(Odontologo odontologo) throws SQLException, ClassNotFoundException;

    List<Odontologo> listar();

    void modificar(int id);

    void eliminar(int id);
}
