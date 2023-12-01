package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public abstract class Lit {
    private int tarifJour;
    private Chambre chambre;
    private Patient patient;
    private ArrayList<Patient> historiquePatient = new ArrayList<Patient>();

    public Lit(int tarif, Chambre chambre) {
        this.tarifJour = tarif;
        this.chambre = chambre;
    }

    public boolean litIsEmplty() {
        return patient == null;
    }

    public int getTarifJour() {
        return tarifJour;
    }

    public void addPatientToLit(Patient p) {
        if (patient != null) {
            throw new IllegalArgumentException("lit deja occupe");
        }
        patient = p;
        historiquePatient.add(p);
    }


    public int removePatient() {
        int retTarif = getTarif();
        patient = null;
        return retTarif;
    }

    public int getTarif() {
        LocalDateTime Temps = LocalDateTime.now();
        System.out.println(ChronoUnit.SECONDS.between(patient.getHeureArrive(), Temps));
        int tarifTemp = (int) (tarifJour * (ChronoUnit.SECONDS.between(patient.getHeureArrive(), Temps) + 1));
        if (chambre.getNbrLit() != patient.getSouhaitChambre() || patient.getSouhaitChambre() == 2) {
            tarifTemp = tarifTemp / 2;
        }

        return tarifTemp + 10;
    }

    public abstract long tempsOccupationMax();

    public boolean tempsDepasser() {
        boolean result = true;
        LocalDateTime Temps = LocalDateTime.now();
        if (patient != null) {
            if (ChronoUnit.SECONDS.between(patient.getHeureArrive(), Temps) >= this.tempsOccupationMax()) {
                result = false;
            }
        }
        return result;
    }

    public ArrayList<Patient> getHistoriquePatient() {
        return historiquePatient;
    }

    @Override
    public String toString() {
        return "Lit{" +
                "patient=" + patient +
                '}';
    }

}

