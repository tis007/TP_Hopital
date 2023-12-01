package org.example;

import java.util.ArrayList;

public class Chambre {
    private int numChambre;
    private int nbrLit;
    private ArrayList<Lit> lits;

    public Chambre(int numChambre, int nbrLit, Lit litType) {
        if (nbrLit > 2) {
            throw new IllegalArgumentException("can't have more than 2 beds in \"chambre\"");
        }
        this.numChambre = numChambre;
        this.nbrLit = nbrLit;
        lits = new ArrayList<>();
        for (int i = 0; i < nbrLit; i++) {
            if (litType instanceof LitAmbulatoire) {
                lits.add(new LitAmbulatoire());
            }
            if (litType instanceof  LitMoyenSejour) {
                lits.add(new LitMoyenSejour());
            }
            if (litType instanceof  LitLongSejour) {
                lits.add(new LitLongSejour());
            }
        }

    }

    public int getNumChambre() {
        return numChambre;
    }

    public int getNbrLit() {
        return nbrLit;
    }
}
