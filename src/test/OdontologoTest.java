package test;

import modelos.Odontologo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoTest {

    @Test
    void instanciarOdontologoTest(){
        Odontologo odontologo = new Odontologo();
        assertNotNull(odontologo);
    }
}