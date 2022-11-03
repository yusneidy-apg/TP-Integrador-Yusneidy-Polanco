package dao;

import modelos.Turno;
import modelos.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDao {

    Usuario crear(Usuario usuario) throws SQLException, ClassNotFoundException;

    List<Usuario> listar();

    void modificar(Usuario usuario);

    void eliminar(int id);
}
