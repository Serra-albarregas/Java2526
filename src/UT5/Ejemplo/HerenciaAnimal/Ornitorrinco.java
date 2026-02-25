package UT5.Ejemplo.HerenciaAnimal;
import java.util.Objects;

public class Ornitorrinco extends Animal {
    String sombrero;
    int nHuevosPuestos;
    boolean tieneVeneno;

    public Ornitorrinco(){
        super();
        this.sombrero="";
        this.nHuevosPuestos=0;
        this.tieneVeneno=true;
    }

    public Ornitorrinco(String nombre, String tipoAlimentacion, int edad, String sombrero, int nHuevosPuestos, boolean tieneVeneno){
        super(nombre, tipoAlimentacion, edad);
        this.sombrero = sombrero;
        this.nHuevosPuestos = nHuevosPuestos;
        this.tieneVeneno = tieneVeneno;
    }

    public String getSombrero() {
        return this.sombrero;
    }

    public void setSombrero(String sombrero) {
        this.sombrero = sombrero;
    }

    public int getNHuevosPuestos() {
        return this.nHuevosPuestos;
    }

    public void setNHuevosPuestos(int nHuevosPuestos) {
        this.nHuevosPuestos = nHuevosPuestos;
    }

    public boolean isTieneVeneno() {
        return this.tieneVeneno;
    }

    public boolean getTieneVeneno() {
        return this.tieneVeneno;
    }

    public void setTieneVeneno(boolean tieneVeneno) {
        this.tieneVeneno = tieneVeneno;
    }

    @Override
    public void hacerSonido(){
        System.out.println("Grrrrr");
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) {
            return true;
        }
        if (!(o instanceof Ornitorrinco)) {
            return false;
        }
        Ornitorrinco ornitorrinco = (Ornitorrinco) o;

        return super.equals(ornitorrinco) && this.sombrero == ornitorrinco.getSombrero() && this.tieneVeneno == ornitorrinco.getTieneVeneno() && this.nHuevosPuestos == ornitorrinco.getNHuevosPuestos();
    }

    @Override
    public String toString() {
        return super.toString() + " sombrero: " + this.sombrero + " Huevos: " + nHuevosPuestos + " Veneno: " + tieneVeneno;
    }
}
