package org.example;

public abstract class Lit {
    private int tarifJour;

    public Lit(int tarif) {
        this.tarifJour = tarif;
    }

    public int getTarifJour() {
        return tarifJour;
    }

    public abstract int tempsOccupationMax();
}
