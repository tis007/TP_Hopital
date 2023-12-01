package org.example;

public class LitLongSejour extends Lit{


    public LitLongSejour(int tarif) {
        super(tarif);
    }

    @Override
    public long tempsOccupationMax() {
        return 30*24*60*60;
    }
}
