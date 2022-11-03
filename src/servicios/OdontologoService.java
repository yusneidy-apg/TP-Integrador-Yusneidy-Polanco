package servicios;

import dao.IOdontologoDao;
import dao.implementacion_dao.OdontologoDaoImpH2;
import modelos.Odontologo;

import java.sql.SQLException;
import java.util.List;

public class OdontologoService {

    IOdontologoDao odontologo;

    public OdontologoService() {
        this.odontologo = new OdontologoDaoImpH2();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) throws SQLException, ClassNotFoundException {
        return this.odontologo.crear(odontologo);
    }

    public List<Odontologo> listarTodosOdontologos(){
        return odontologo.listar();
    }


    public void modificarOdontologo(Odontologo odontologo){
        this.odontologo.modificar(odontologo);
    }

    public void eliminarOdontologo(int id){
        odontologo.eliminar(id);
    }
}
