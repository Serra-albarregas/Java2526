package UT5.Persona;

import java.util.Arrays;

public class GestorPersona {
    private Persona[] personas;
    private final int MAX = 100;
    private int cantidad;

    public GestorPersona(){
        this.personas = new Persona[MAX];
        this.cantidad = 0;
    }

    public boolean insertarPersona(Persona persona){
        if (cantidad<MAX){
            personas[cantidad] = persona;
            cantidad++;
            return true;
        }
        return false;
    }

    public Persona buscarPorDNI(String dni){
        for (int i = 0; i < cantidad; i++) {
           if (personas[i].getDNI().equals(dni)) {
                return personas[i];
           }
        }
        return null;
    }

    public int buscarIndicePorDNI(String dni){
        for (int i = 0; i < cantidad; i++) {
           if (personas[i].getDNI().equals(dni)) {
                return i;
           }
        }
        return -1;
    }

    public Persona[] buscarPorRangoEdad(int edadMin, int edadMax){
        if (edadMax<edadMin){
            int aux = edadMax;
            edadMax=edadMin;
            edadMin=aux;
        }

        Persona[] personasBusqueda = new Persona[MAX];
        int j = 0;

        for (int i = 0; i < cantidad; i++) {
            int edad = personas[i].getEdad();
            if (edadMin<=edad && edad<=edadMax) {
                personasBusqueda[j] = personas[i];
                j++;
            }
        }

        return Arrays.copyOf(personasBusqueda, j);
    }

    public boolean eliminarPersona(String dni) {
        int posicion = buscarIndicePorDNI(dni);
        if (posicion!=-1){
            for (int i = posicion+1; i < cantidad; i++) {
                personas[i-1] = personas[i];
            }
            return true;
        }
        return false;
    }
}
