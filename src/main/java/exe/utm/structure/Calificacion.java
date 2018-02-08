/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe.utm.structure;

/**
 *
 * @author Exequetor
 */
public class Calificacion {
    private Integer id;
    private Integer alumnoId;
    private Integer materiaId;
    private String materiaName;
    private Double p1;
    private Double p2;
    private Double p3;
    private Double fin;
    private Double ex1;
    private Double ex2;
    private Double ex3;

    public Calificacion() {
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

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public Double getP1() {
        return p1;
    }

    public void setP1(Double p1) {
        this.p1 = p1;
    }

    public Double getP2() {
        return p2;
    }

    public void setP2(Double p2) {
        this.p2 = p2;
    }

    public Double getP3() {
        return p3;
    }

    public void setP3(Double p3) {
        this.p3 = p3;
    }

    public Double getFin() {
        return fin;
    }

    public void setFin(Double fin) {
        this.fin = fin;
    }

    public Double getEx1() {
        return ex1;
    }

    public void setEx1(Double ex1) {
        this.ex1 = ex1;
    }

    public Double getEx2() {
        return ex2;
    }

    public void setEx2(Double ex2) {
        this.ex2 = ex2;
    }

    public Double getEx3() {
        return ex3;
    }

    public void setEx3(Double ex3) {
        this.ex3 = ex3;
    }

    public String getMateriaName() {
        return materiaName;
    }

    public void setMateriaName(String materiaName) {
        this.materiaName = materiaName;
    }
    
}
