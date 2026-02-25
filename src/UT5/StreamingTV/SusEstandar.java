package UT5.StreamingTV;

public class SusEstandar extends Suscripcion {

    private static final int limDispositivos = 2;
    private static final double precioEstandar = 24.99;

    public SusEstandar(String usuario, int duracionMeses) {
        super(usuario, duracionMeses);
        precio = precioEstandar;
        if (duracionMeses >=6) descuentoPorcentaje = 5;
    }

    @Override
    public void agregarDispositivo() {
        dispositivosActivos++;
        if (dispositivosActivos>limDispositivos) {
            recargo = (dispositivosActivos-limDispositivos) * 5;
        }
    }

    @Override
    public void eliminarDispositivo() {
        dispositivosActivos--;
        if (dispositivosActivos<=limDispositivos) {
            recargo = 0;
        }
    }

    public int getLimDispositivos(){
        return limDispositivos;
    }
}
