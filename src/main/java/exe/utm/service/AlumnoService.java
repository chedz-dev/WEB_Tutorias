/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe.utm.service;

import exe.utm.structure.Alumno;
import java.util.List;

public interface AlumnoService {
    public List<Alumno> getAll();
    public Alumno getAlumno (Integer id);
    public void updateTutor (Integer alumnoId, Integer tutorId);
    public String getTutor (Integer id);
    public void insert (String matricula, String nombre, String apellidos, String foto, String correo);
    public void update (Integer id, String matricula, String nombre, String apellidos, String foto, String correo);
    public void delete (Integer id);
}
