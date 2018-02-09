/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe.utm.service;

import exe.utm.structure.Alumno;
import exe.utm.structure.Entrevista;
import exe.utm.structure.Profesor;
import java.util.List;

public interface TutoriaService {
    public List<Entrevista> getAll();
    public Entrevista getEntrevista (Integer id);
    public List<Entrevista> getEntrevistaByAlumno (Integer id);
    public List<Alumno> getTutoradosByProfesor (Integer profesorId);
    public void insert (String nombre, String usuario, String correo, String instituto);
}
