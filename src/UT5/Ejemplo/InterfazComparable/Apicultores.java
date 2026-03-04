package UT5.Ejemplo.InterfazComparable;

import java.util.Arrays;
import java.util.Iterator;

public class Apicultores implements Iterable<Apicultor>{
    Apicultor[] apicultores;
    private int lleno;
    private static final int TAM = 100;

    public Apicultores() {
        apicultores = new Apicultor[TAM];
        lleno = 0;
    }

    public void nuevaApicultor(Apicultor p) {
        if (lleno<TAM){
            apicultores[lleno] = p;
            lleno++;
        }
    }

    public void ordenar(){
        Apicultor[] apicultoresAux = Arrays.copyOf(apicultores, lleno);
        Arrays.sort(apicultoresAux);
        apicultores = Arrays.copyOf(apicultoresAux, TAM);
    }

    public Apicultores(Apicultor[] apicultores) {
        this.apicultores = apicultores;
    }

    public Apicultor[] getApicultores() {
        return this.apicultores;
    }

    public void setApicultores(Apicultor[] apicultores) {
        this.apicultores = apicultores;
    }

    @Override
    public String toString() {
        String apicultores = "";
        for (int i = 0; i < lleno; i++) {
            apicultores+=this.apicultores[i] + "\n";
        }
        return apicultores;
    }

    @Override
    public Iterator<Apicultor> iterator() {
        return new ApicultorIterator();
    }

    public class ApicultorIterator implements Iterator<Apicultor>{
        int indice = 0;
        @Override
        public boolean hasNext() {
            return indice < lleno;
        }

        @Override
        public Apicultor next() {
            return apicultores[indice++];
        }
        
    }
    
    public static void main(String[] args) {
        Apicultores apicultores = new Apicultores();
        apicultores.nuevaApicultor(new Apicultor("Juan el abejero", 3));
        apicultores.nuevaApicultor(new Apicultor("Mario agijon", 1));
        apicultores.nuevaApicultor(new Apicultor("Jose Pedro Amarilla", 10));
        apicultores.nuevaApicultor(new Apicultor("Lucia Polen", 5));
        apicultores.nuevaApicultor(new Apicultor("Carla Zangana", 5));

        System.out.println(apicultores);
        apicultores.ordenar();
        System.out.println(apicultores);


        for (Apicultor apicultor : apicultores) {
            System.out.println(apicultor);
        }
    }


}
