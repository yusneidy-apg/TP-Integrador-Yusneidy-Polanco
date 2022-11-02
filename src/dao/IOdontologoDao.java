package dao;

import modelos.Odontologo;

import java.util.List;

public interface IOdontologoDao {

    Odontologo crear(Odontologo odontologo);

    List<Odontologo> listar();

    void modificar(int id);

    void eliminar(int id);
}
