package UT5.Ejemplo.HerenciaAnimal;

public class AnimalesMain {
    public static void main(String[] args) {
        Ornitorrinco o = new Ornitorrinco("Perri", "Omniman", 102, "fedora", 54, true);
        Ornitorrinco o2 = new Ornitorrinco("Perri", "Omniman", 102, "fedora", 54, true);
        Animal a2 = new Ornitorrinco();
        Animal a3 = new Animal();

        System.out.println(o==o2);


        Animal[] animales = new Animal[3];

        animales[0] = o;
        animales[1] = a2;
        animales[2] = a3;

        for (Animal animal : animales) {
            animal.hacerSonido();
        }
    }
}
