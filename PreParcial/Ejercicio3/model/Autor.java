package Ejercicio3.model;

import java.io.Serializable;

public class Autor implements Serializable {

    private String nombre;
    private String apellido;
    private String cedula;
    private String programa;
    private String tituloProfesional;

    public Autor(String nombre, String apellido, String cedula, String programa, String tituloProfesional) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.programa = programa;
        this.tituloProfesional = tituloProfesional;
    }

    public Autor() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor autor)) return false;

        return getCedula() != null ? getCedula().equals(autor.getCedula()) : autor.getCedula() == null;
    }

    @Override
    public int hashCode() {
        return getCedula() != null ? getCedula().hashCode() : 0;
    }

    @Override
    public String toString() {
        return
                nombre +
                "@" + apellido +
                "@" + cedula +
                "@" + programa +
                "@" + tituloProfesional +"@" ;
    }
}
