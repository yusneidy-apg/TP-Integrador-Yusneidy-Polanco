package servicios;

import dao.ITurnoDao;
import dao.implementacion_dao.TurnoDaoImpH2;
import modelos.Turno;

import java.sql.SQLException;
import java.util.List;

public class TurnoService {

    ITurnoDao turno;

    public TurnoService() {
        this.turno = new TurnoDaoImpH2();
    }

    public Turno guardarTurno(Turno turno) throws SQLException, ClassNotFoundException {
        return this.turno.crear(turno);
    }

    public List<Turno> listarTodosTurnos(){
        return turno.listar();
    }


    public void modificarTurno(Turno turno){
        this.turno.modificar(turno);
    }

    public void eliminarTurno(int id){
        turno.eliminar(id);
    }
}
