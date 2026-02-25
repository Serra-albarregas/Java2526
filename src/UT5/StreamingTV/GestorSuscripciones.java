package UT5.StreamingTV;

public class GestorSuscripciones {

    private Suscripcion[] suscripciones;
    private int contador;

    public GestorSuscripciones(int tamaño) {
        suscripciones = new Suscripcion[tamaño];
        contador = 0;
    }

    public void agregarSuscripcion(Suscripcion s) {
        if (contador < suscripciones.length) {
            suscripciones[contador] = s;
            contador++;
        }
    }

    public boolean eliminarSuscripcion(Suscripcion s) {
        int posicion = -1;
        for (int i = 0; i < contador; i++) {
            if (suscripciones[i].getUsuario().equals(s.getUsuario())){
                posicion = i;
            }
        }
        if (posicion!=-1) {
            for (int i = posicion; i < contador-1; i++) {
                suscripciones[i] = suscripciones[i+1];
            }
            contador--;
            return true;
        } else {
            return false;
        }
    }

    public Suscripcion buscarPorUsuario(String usuario) {
        for (int i = 0; i < contador; i++) {
            if (suscripciones[i].usuario.equals(usuario)) {
                return suscripciones[i];
            }
        }
        return null;
    }

    public void pasarMes() {
        for (int i = 0; i < contador; i++) {
            suscripciones[i].nuevoMes();
        }
    }
}
