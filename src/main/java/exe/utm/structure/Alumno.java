package exe.utm.structure;

import java.util.List;

public class Alumno {
    private Integer id;
    private String matricula;
    private String nombre;
    private String apellidos;
    private String foto;
    private String correo;
    private Integer tutorId;
    private List<Calificacion> califList;

    public Alumno() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }

    public List<Calificacion> getCalifList() {
        return califList;
    }

    public void setCalifList(List<Calificacion> califList) {
        this.califList = califList;
    }
    
}
