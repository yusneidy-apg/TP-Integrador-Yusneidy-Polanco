package servicios;

import dao.IPacienteDao;
import dao.implementacion_dao.PacienteDaoImplH2;
import modelos.Paciente;

import java.sql.SQLException;
import java.util.List;

public class PacienteService {

    IPacienteDao paciente;

    public PacienteService() {
        this.paciente = new PacienteDaoImplH2();
    }

    public Paciente guardarPaciente(Paciente paciente) throws SQLException, ClassNotFoundException {
        return this.paciente.crear(paciente);
    }

    public List<Paciente> listarTodosPaciente(){
        return paciente.listar();
    }


    public void modificarPaciente(Paciente paciente){
        this.paciente.modificar(paciente);
    }

    public void eliminarPaciente(int id){
        paciente.eliminar(id);
    }
}
