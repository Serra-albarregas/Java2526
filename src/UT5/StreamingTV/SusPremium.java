package UT5.StreamingTV;

public class SusPremium extends Suscripcion {
    private static final int limDispositivos = 4;
    private static final double precioPremium = 29.99;


    public SusPremium(String usuario, int duracionMeses) {
        super(usuario, duracionMeses);
        precio = precioPremium;
        descuentoPorcentaje = 10;
        if (duracionMeses >=12) descuentoPorcentaje = 15;
    }

    @Override
    public void agregarDispositivo() {
        dispositivosActivos++;
    }

    @Override
    public void eliminarDispositivo() {
        dispositivosActivos--;
    }

    public int getLimDispositivos(){
        return limDispositivos;
    }
}
