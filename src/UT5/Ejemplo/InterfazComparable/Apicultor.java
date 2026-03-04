package UT5.Ejemplo.InterfazComparable;

public class Apicultor implements Comparable<Apicultor>, Cloneable {
    private String nombre;
    private int nAbejas;

    public Apicultor() {
    }

    public Apicultor(String nombre, int nAbejas) {
        this.nombre = nombre;
        this.nAbejas = nAbejas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNAbejas() {
        return this.nAbejas;
    }

    public void setNAbejas(int nAbejas) {
        this.nAbejas = nAbejas;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", nAbejas='" + getNAbejas() + "'" +
            "}";
    }

    @Override
    public int compareTo(Apicultor o) {
        int comparacion = Integer.compare(this.nAbejas, o.getNAbejas());
        return comparacion != 0 ? comparacion : this.nombre.compareTo(o.getNombre());
    }

    @Override
    public Apicultor clone() {
        return new Apicultor(this.nombre, this.nAbejas);
    }
}