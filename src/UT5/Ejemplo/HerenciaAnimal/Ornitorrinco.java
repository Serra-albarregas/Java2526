package UT5.Ejemplo.HerenciaAnimal;

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

    @Override
    public void hacerSonido(){
        System.out.println("Grrrrr");
    }

    @Override
    public String toString() {
        return super.toString() + " sombrero: " + this.sombrero + " Huevos: " + nHuevosPuestos + " Veneno: " + tieneVeneno;
    }
}
