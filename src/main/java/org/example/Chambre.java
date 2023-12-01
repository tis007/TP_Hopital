package org.example;

import java.util.ArrayList;

public class Chambre {
    private int numChambre;
    private int nbrLit;
    private ArrayList<Lit> lits;

    public Chambre(int numChambre, int nbrLit, Lit litType) {
        if (nbrLit > 2 || nbrLit <= 0) {
            throw new IllegalArgumentException("illegal number of bed in \"chambre\"");
        }
        this.numChambre = numChambre;
        this.nbrLit = nbrLit;
        lits = new ArrayList<>();
        for (int i = 0; i < nbrLit; i++) {
            if (litType instanceof LitAmbulatoire) {
                lits.add(new LitAmbulatoire((15 * 2) / nbrLit, this));
            }
            if (litType instanceof LitMoyenSejour) {
                lits.add(new LitMoyenSejour((20 * 2) / nbrLit, this));
            }
            if (litType instanceof LitLongSejour) {
                lits.add(new LitLongSejour((25 * 2) / nbrLit, this));
            }
        }
    }

    public void addPatient(Patient p) {
        boolean isAdded = false;
        for (Lit l : lits) {
            if (l.litIsEmplty() && !isAdded) {
                l.addPatientToLit(p);
                p.addLit(l);
                isAdded = true;
            }
        }
    }

    public ArrayList<Lit> getLits() {
        return lits;
    }

    public boolean havePlace() {
        for (Lit l : lits) {
            if (l.litIsEmplty()) {
                return true;
            }
        }
        return false;
    }

    public int getNumChambre() {
        return numChambre;
    }

    public int getNbrLit() {
        return nbrLit;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "numChambre=" + numChambre +
                ", nbrLit=" + nbrLit +
                ", lits=" + lits +
                '}';
    }
    public ArrayList<Lit> tempsDepasse(){
        ArrayList<Lit> litTempDepasse = new ArrayList<Lit>();
        for (Lit l : lits){
            if (!l.tempsDepasser()){
                litTempDepasse.add(l);
            }
        }
        return litTempDepasse;
    }
}
