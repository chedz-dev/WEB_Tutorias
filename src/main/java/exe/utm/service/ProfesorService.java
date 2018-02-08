/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe.utm.service;

import exe.utm.structure.Materia;
import java.util.List;

public interface ProfesorService {
    public List<Materia> getAll();
    public Materia getMateria(Integer id);
    public void insert (String nombre);
    public void update (Integer id, String nombre);
    public void delete (Integer id);
}
