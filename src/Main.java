import modelos.Odontologo;
import modelos.Paciente;
import org.apache.log4j.Logger;
import servicios.OdontologoService;
import servicios.PacienteService;
import utilidad.ConexionBaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) throws ClassNotFoundException {

        try(Connection conn = ConexionBaseDeDatos.obtenerConexion()){

            Paciente paciente = new Paciente("Cata", "Rodriguez", "Carrerta 23", "CC1234", LocalDateTime.parse("2022-11-01T12:00:00"));
            PacienteService pacienteServicio = new PacienteService();
            pacienteServicio.guardarPaciente(paciente);


            Odontologo o1 = new Odontologo("Lalo", "Mena", "A1234");
            Odontologo o2 = new Odontologo("Jhon", "Doe", "B1234");

            OdontologoService odontologoServicio = new OdontologoService();
            odontologoServicio.guardarOdontologo(o1);
            odontologoServicio.guardarOdontologo(o2);
            odontologoServicio.listarTodosOdontologos().forEach(o -> System.out.println(o.getNombre() + " | " + o.getApellido()));

        }catch (SQLException e){
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }
}