package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Hopital hopital = new Hopital();
        hopital.addService(new Service("Radiologie", 2, new LitAmbulatoire(0, null)));

        Patient albert = new Patient(1, "Albert", 1, 1, hopital);
        Patient robert = new Patient(2, "Robert", 1, 1, hopital);

        hopital.addPatient(albert);
        hopital.addPatient(robert);
        /*
        Thread.sleep(2000);
        System.out.println(hopital.listTempsDepasse());

         */

        System.out.println(hopital.removePatient(albert));

        System.out.println(hopital.getArchives());

        System.out.println(hopital.getTauxOccupationLit(new LitAmbulatoire(0, null)));

        System.out.println(hopital);


    }
}