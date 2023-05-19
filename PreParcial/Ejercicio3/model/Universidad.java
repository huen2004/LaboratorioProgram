package Ejercicio3.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidad implements Serializable {

    private String nombre;
    private ArrayList<TrabajoGrado> listaTrabajosGrado = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public Universidad() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<TrabajoGrado> getListaTrabajosGrado() {
        return listaTrabajosGrado;
    }

    public void setListaTrabajosGrado(ArrayList<TrabajoGrado> listaTrabajosGrado) {
        this.listaTrabajosGrado = listaTrabajosGrado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Universidad that)) return false;

        return getNombre() != null ? getNombre().equals(that.getNombre()) : that.getNombre() == null;
    }

    @Override
    public int hashCode() {
        return getNombre() != null ? getNombre().hashCode() : 0;
    }

    @Override
    public String toString() {
        return
                "@" + nombre  +
                "@" + listaTrabajosGrado;
    }
}
