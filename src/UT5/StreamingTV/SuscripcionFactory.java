package UT5.StreamingTV;

public class SuscripcionFactory {
    public static Suscripcion getSuscripcion(String tipoSuscripcion, String usuario, int duracion) {
        Suscripcion suscripcion = null;
        switch (tipoSuscripcion) {
            case "basica":
                suscripcion = new SusBasica(usuario, duracion);
                break;
            case "estandar":
                suscripcion = new SusEstandar(usuario, duracion);
                break;
            case "premium":
                suscripcion = new SusPremium(usuario, duracion);
                break;
        }

        return suscripcion;
    }
}
