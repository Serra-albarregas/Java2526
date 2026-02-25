package UT5.Ejemplo.HerenciaAnimal;
import java.util.Objects;

public class Pato{
    private String patosidad;
    private int velocidadNado;



    public Pato() {
    }

    public Pato(String patosidad, int velocidadNado) {
        this.patosidad = patosidad;
        this.velocidadNado = velocidadNado;
    }

    public String getPatosidad() {
        return this.patosidad;
    }

    public void setPatosidad(String patosidad) {
        this.patosidad = patosidad;
    }

    public int getVelocidadNado() {
        return this.velocidadNado;
    }

    public void setVelocidadNado(int velocidadNado) {
        this.velocidadNado = velocidadNado;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pato)) {
            return false;
        }
        Pato pato = (Pato) o;
        return Objects.equals(patosidad, pato.patosidad) && velocidadNado == pato.velocidadNado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patosidad, velocidadNado);
    }

    @Override
    public String toString() {
        return "{" +
            " patosidad='" + getPatosidad() + "'" +
            ", velocidadNado='" + getVelocidadNado() + "'" +
            "}";
    }
 

}