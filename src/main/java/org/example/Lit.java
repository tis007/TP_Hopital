package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public abstract class Lit {
    private int tarifJour;
    private Patient patient;

    public Lit(int tarif) {
        this.tarifJour = tarif;
    }

    public int getTarifJour() {
        return tarifJour;
    }

    public abstract long tempsOccupationMax();

    public boolean tempsDepasser(){
        boolean result = true;
        LocalDateTime Temps = LocalDateTime.now();
        if (ChronoUnit.SECONDS.between(Temps, patient.getHeureArrive()) >= this.tempsOccupationMax()){
            result = false;
        }
        return result;
    }
}

