package UT5.Contador;


public class Contador {
    private String nombre;
    private int valor;
    private int min;
    private int max;
    private int step;
    private final int DEFAULTMIN = 0;
    private final int DEFAULTMAX = 100;
    private final int DEFAULTSTEP = 1;

    private String [] historial;
    private final int TAMHISTORIAL = 100;
    private int indiceHistorial;

    public Contador(String nombre) {
        this.nombre = nombre;
        this.valor = DEFAULTMIN;
        this.min = DEFAULTMIN;
        this.max = DEFAULTMAX;
        this.step = DEFAULTSTEP;
        this.historial = new String[TAMHISTORIAL];
        this.indiceHistorial = 0;
    }

    public Contador(String nombre, int min, int max, int step) {
        this.nombre = nombre;
        this.valor = min;
        this.min = min;
        this.max = max;
        if (max < min) {
            this.min = max;
            this.max = min;
        }
        if (step > 0) {
            this.step = step;
        } else {
            this.step = DEFAULTSTEP;
        }
        this.historial = new String[TAMHISTORIAL];
        this.indiceHistorial = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        if (min < max){
            this.min = min;
        }
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        if (max>min){
            this.max = max;
        }
    }

    public int getStep() {
        return this.step;
    }

    public void setStep(int step) {
        if (step > 0) {
            this.step = step;
        } else {
            this.step = DEFAULTSTEP;
        }
    }

    public void incrementar(){
        if (valor + step <= max){
            valor += step;
        } else {
            valor = max;
        }
        agregarEnHistorial("El valor se ha incrementado. Valor:" + valor);
    }

    public void decrementar(){
        if (valor - step >= min){
            valor -= step;
        } else {
            valor = min;
        }
        agregarEnHistorial("El valor se ha decrementado. Valor:" + valor);
    }

    public void reiniciar(){
        valor = min;
        agregarEnHistorial("El valor se ha reiniciado. Valor:" + valor);
    }

    @Override
    public String toString() {
        agregarEnHistorial("El valor se ha mostrado. Valor:" + valor);
        return nombre + ": " + valor;
    }

    public String barraCarga() {
        String barra = "";
        int barraStep = (max - min)/50;
        for (int i = min; i < valor; i += barraStep) {
            barra += "=";
        }
        for (int i = valor; i < max; i += barraStep) {
            barra += "-";
        }

        return barra;
    }

    public void agregarEnHistorial(String entrada) {
        historial[indiceHistorial] = entrada;
        indiceHistorial++;
    }
}
