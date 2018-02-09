package exe.utm.structure;

import java.sql.Date;

public class Entrevista {
    private Integer id;
    private Integer alumnoId;
    private Date date;
    private String entrevistador;
    private String notas;

    public Entrevista() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(String entrevistador) {
        this.entrevistador = entrevistador;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
}
