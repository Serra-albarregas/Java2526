package UT5.StreamingTV;
import java.util.Objects;

public class Cobro {
    TipoCobro tipoCobro;
    double cantidad;


    public Cobro() {
    }

    public Cobro(TipoCobro tipoCobro, double cantidad) {
        this.tipoCobro = tipoCobro;
        this.cantidad = cantidad;
    }

    public TipoCobro getTipoCobro() {
        return this.tipoCobro;
    }

    public void setTipoCobro(TipoCobro tipoCobro) {
        this.tipoCobro = tipoCobro;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cobro)) {
            return false;
        }
        Cobro cobro = (Cobro) o;
        return Objects.equals(tipoCobro, cobro.tipoCobro) && cantidad == cobro.cantidad;
    }

    @Override
    public String toString() {
        return "{" +
            " tipoCobro='" + getTipoCobro().name() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            "}";
    }
    
}
