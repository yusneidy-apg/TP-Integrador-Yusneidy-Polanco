package dao;

import modelos.Turno;
import modelos.Usuario;

import java.util.List;

public interface IUsuarioDao {

    Usuario crear(Usuario usuario);

    List<Usuario> listar();

    void modificar(int id);

    void eliminar(int id);
}
