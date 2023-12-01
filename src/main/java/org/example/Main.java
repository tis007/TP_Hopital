package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Hopital hopital = new Hopital();
        hopital.addService(new Service("Radiologie", 2, new LitAmbulatoire(0)));
        System.out.println(hopital);

    }
}