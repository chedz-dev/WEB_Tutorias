/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe.utm.service;

import exe.utm.structure.Profesor;
import java.util.List;

public interface ProfesorService {
    public List<Profesor> getAll();
    public Profesor getProfesor(Integer id);
    public void insert (String nombre, String usuario, String correo, String instituto);
    public void update (Integer id, String nombre, String usuario, String correo, String instituto);
    public void delete (Integer id);
}
