package UT5.StreamingTV;
import java.util.Objects;

public abstract class Suscripcion {
    protected String usuario;
    protected double precio;
    protected int descuentoPorcentaje;
    protected int recargo;
    protected int dispositivosActivos;
    protected int duracionMeses;
    protected int mesActual;
    protected boolean enPausa;
    protected boolean haPausado;
    protected boolean bloqueado;
    protected Cobro[] historial;
    protected int contHistorial;


    public Suscripcion() {
    }

    public Suscripcion(String usuario, int duracionMeses) {
        this.usuario = usuario;
        this.descuentoPorcentaje = 0;
        this.recargo = 0;
        this.dispositivosActivos = 0;
        this.duracionMeses = duracionMeses;
        this.mesActual = 0;
        this.enPausa = false;
        this.haPausado = false;
        this.bloqueado = false;
        this.historial = new Cobro[duracionMeses];
        this.contHistorial = 0;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDescuentoPorcentaje() {
        return this.descuentoPorcentaje;
    }

    public void setDescuentoPorcentaje(int descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    public int getRecargo() {
        return this.recargo;
    }

    public void setRecargo(int recargo) {
        this.recargo = recargo;
    }

    public int getDispositivosActivos() {
        return this.dispositivosActivos;
    }

    public void setDispositivosActivos(int dispositivosActivos) {
        this.dispositivosActivos = dispositivosActivos;
    }

    public int getDuracionMeses() {
        return this.duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public int getMesActual() {
        return this.mesActual;
    }

    public void setMesActual(int mesActual) {
        this.mesActual = mesActual;
    }

    public boolean isEnPausa() {
        return this.enPausa;
    }

    public boolean getEnPausa() {
        return this.enPausa;
    }

    public void setEnPausa(boolean enPausa) {
        this.enPausa = enPausa;
    }

    public boolean isHaPausado() {
        return this.haPausado;
    }

    public boolean getHaPausado() {
        return this.haPausado;
    }

    public void setHaPausado(boolean haPausado) {
        this.haPausado = haPausado;
    }

    public boolean isBloqueado() {
        return this.bloqueado;
    }

    public boolean getBloqueado() {
        return this.bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Cobro[] getHistorial() {
        return this.historial;
    }

    public void setHistorial(Cobro[] historial) {
        this.historial = historial;
    }

    public int getContHistorial() {
        return this.contHistorial;
    }

    public void setContHistorial(int contHistorial) {
        this.contHistorial = contHistorial;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Suscripcion)) {
            return false;
        }
        Suscripcion suscripcion = (Suscripcion) o;
        return Objects.equals(usuario, suscripcion.usuario) && precio == suscripcion.precio && descuentoPorcentaje == suscripcion.descuentoPorcentaje && recargo == suscripcion.recargo && dispositivosActivos == suscripcion.dispositivosActivos && duracionMeses == suscripcion.duracionMeses && mesActual == suscripcion.mesActual && enPausa == suscripcion.enPausa && haPausado == suscripcion.haPausado && bloqueado == suscripcion.bloqueado && Objects.equals(historial, suscripcion.historial) && contHistorial == suscripcion.contHistorial;
    }

    @Override
    public String toString() {
        return "{" +
            " usuario='" + getUsuario() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", descuentoPorcentaje='" + getDescuentoPorcentaje() + "'" +
            ", recargo='" + getRecargo() + "'" +
            ", dispositivosActivos='" + getDispositivosActivos() + "'" +
            ", duracionMeses='" + getDuracionMeses() + "'" +
            ", mesActual='" + getMesActual() + "'" +
            ", enPausa='" + isEnPausa() + "'" +
            ", haPausado='" + isHaPausado() + "'" +
            ", bloqueado='" + isBloqueado() + "'" +
            ", historial='" + getHistorial() + "'" +
            ", contHistorial='" + getContHistorial() + "'" +
            "}";
    }    

    public void nuevoMes(){
        mesActual ++;
        Cobro cobro;
        if (enPausa){
            cobro = new Cobro(TipoCobro.PAUSA,0);
        } else {
            double precioFinal = calcularPrecioFinal();
            if (descuentoPorcentaje!=0){
                cobro = new Cobro(TipoCobro.DESCUENTO, precioFinal);
            } else {
                cobro = new Cobro(TipoCobro.NORMAL, precioFinal);
            }
        }
        historial[contHistorial] = cobro;
        contHistorial++;
    }

    public boolean pausar(){
        if (duracionMeses>=6 && !haPausado) {
            enPausa = true;
        }
        return enPausa;
    }

    public void cancelarPausa(){
        enPausa = false;
    }

    public abstract void agregarDispositivo();

    public abstract void eliminarDispositivo();

    public double calcularPrecioFinal() {
        return precio * (1 + recargo/100 - descuentoPorcentaje/100);
    }

    public String verHistorial(){
        String historial = "";
        for (Cobro cobro : this.historial) {
            historial += cobro;
        }

        return historial;
    }
}
