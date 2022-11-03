package servicios;

import dao.IUsuarioDao;
import dao.implementacion_dao.UsuarioDaoImpH2;
import modelos.Usuario;

import java.util.List;

public class UsuarioService {

    IUsuarioDao usuario;

    public UsuarioService() {
        this.usuario = new UsuarioDaoImpH2();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return this.usuario.crear(usuario);
    }

    public List<Usuario> listarTodosUsuarios(){
        return usuario.listar();
    }


    public void modificarUsuario(Usuario usuario){
        this.usuario.modificar(usuario);
    }

    public void eliminarUsuario(int id){
        usuario.eliminar(id);
    }
}
