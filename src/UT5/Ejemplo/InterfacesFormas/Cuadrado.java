package UT5.Ejemplo.InterfacesFormas;

public class Cuadrado implements Forma{
    private int lado;

    @Override
    public float calcularArea() {
        return lado * lado;
    }

    @Override
    public float calcularPerimetro() {
        return 4*lado;
    }
}
