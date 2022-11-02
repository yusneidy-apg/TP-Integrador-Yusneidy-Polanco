package test;

import modelos.Paciente;
import modelos.Turno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {

    @Test
    void instanciarTurnoTest(){
        Turno turno1 = new Turno();
        assertNotNull(turno1);
    }

}