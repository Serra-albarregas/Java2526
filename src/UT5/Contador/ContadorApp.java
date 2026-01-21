package UT5.Contador;

public class ContadorApp {
    public static void main(String[] args) {
        Contador contador = new Contador("Cronos", 20, 500, 2);
        contador.incrementar();
        System.out.println(contador.toString());
        contador.incrementar();
        System.out.println(contador.toString());
        contador.setStep(50);
        contador.incrementar();
        System.out.println(contador.barraCarga());
    }
}
