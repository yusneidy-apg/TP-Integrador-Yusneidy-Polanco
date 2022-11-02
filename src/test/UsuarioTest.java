package test;

import modelos.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    void instanciarUsuarioTest(){
        Usuario usuario1 = new Usuario();
        assertNotNull(usuario1);
    }

}