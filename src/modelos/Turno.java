package modelos;

import java.time.LocalDateTime;

public class Turno {

    private int idTurno;
    private int idOdontologo;
    private int idPaciente;
    private LocalDateTime fechaTurno;

    public Turno() {
    }

    public Turno(int idTurno, int idOdontologo, int idPaciente, LocalDateTime fechaTurno) {
        this.idTurno = idTurno;
        this.idOdontologo = idOdontologo;
        this.idPaciente = idPaciente;
        this.fechaTurno = fechaTurno;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(int idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDateTime fechaTurno) {
        this.fechaTurno = fechaTurno;
    }
}
