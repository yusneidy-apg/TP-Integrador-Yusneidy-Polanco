import dao.IPacienteDao;
import dao.implementacion_dao.PacienteDaoImplH2;
import modelos.Paciente;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        try{
            Paciente paciente = new Paciente("Prueba", "Prueba", "Carre23", "12345", LocalDateTime.parse("2022-11-01T12:00:00"));
            IPacienteDao crearPaciente = new PacienteDaoImplH2();
            crearPaciente.crear(paciente);

        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }
}