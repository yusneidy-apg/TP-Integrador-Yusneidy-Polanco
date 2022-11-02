package dao;

import modelos.Paciente;
import modelos.Turno;

import java.util.List;

public interface ITurnoDao {

    Turno crear(Turno turno);

    List<Turno> listar();

    void modificar(int id);

    void eliminar(int id);
}
