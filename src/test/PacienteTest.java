package test;

import modelos.Odontologo;
import modelos.Paciente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void instanciarPacienteTest(){
        Paciente paciente = new Paciente();
        assertNotNull(paciente);
    }

}