package UT5.Dado;

public enum NCaras {
    CUATRO(4), SEIS(6), OCHO(8), DIEZ(10), DOCE(12), VEINTE(20), CIEN(100);

    private final int n;

    private NCaras(int n){
        this.n = n;
    }

    public int getN(){
        return n;
    }

    public static NCaras fromN(int n){
        for (NCaras cara : NCaras.values()) {
            if (cara.getN()==n) {
                return cara;
            }
        }
        return null;
    }
}
