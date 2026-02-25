package UT5.StreamingTV;

public class SusBasica extends Suscripcion{

    protected static final int limDispositivos = 1;
    protected static final double precioBasica = 19.99;

    public SusBasica(String usuario, int duracionMeses) {
        super(usuario, duracionMeses);
        precio = precioBasica;
    }

    @Override
    public void agregarDispositivo() {
        dispositivosActivos++;
        if (dispositivosActivos > limDispositivos) {
            bloqueado = true;
        }
    }

    @Override
    public void eliminarDispositivo() {
        dispositivosActivos--;
        if (dispositivosActivos <= limDispositivos) {
            bloqueado = false;
        }
    }

    public int getLimDispositivos(){
        return limDispositivos;
    }
}
