package org.example;

public class LitMoyenSejour extends Lit {

    public LitMoyenSejour(int tarif, Chambre c) {
        super(tarif, c);
    }

    @Override
    public long tempsOccupationMax() {
        return 14*24*60*60;
    }
}
