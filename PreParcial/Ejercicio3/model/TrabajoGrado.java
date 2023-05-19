package Ejercicio3.model;

import java.io.Serializable;
import java.util.ArrayList;

public class TrabajoGrado implements Serializable {

    private String codigo;
    private String fecha;
    private String descripcion;
    private String titulo;
    private ArrayList<Autor> listaAutores = new ArrayList<>();

    public TrabajoGrado(String codigo, String fecha, String descripcion, String titulo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    public TrabajoGrado() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(ArrayList<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrabajoGrado that)) return false;

        return getCodigo() != null ? getCodigo().equals(that.getCodigo()) : that.getCodigo() == null;
    }

    @Override
    public int hashCode() {
        return getCodigo() != null ? getCodigo().hashCode() : 0;
    }

    @Override
    public String toString() {
        return
                codigo +
                "@" + fecha +
                "@" + descripcion +
                "@" + titulo +
                "@" + listaAutores + "@"+"["+listaAutores.toString()+"]" ;
    }
}
