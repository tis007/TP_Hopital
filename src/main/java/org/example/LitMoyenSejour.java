package org.example;

public class LitMoyenSejour extends Lit {

    public LitMoyenSejour(int tarif) {
        super(tarif);
    }

    @Override
    public long tempsOccupationMax() {
        return 14*24*60*60;
    }
}
