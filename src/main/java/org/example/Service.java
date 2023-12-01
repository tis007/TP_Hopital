package org.example;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private String nomService;
    private int numService;
    private static int numServiceTot = 1;
    private int nbrChambres;
    private ArrayList<Chambre> chambres = new ArrayList<Chambre>();
    private Lit litType;

    public Service(String nomService, int nbrChambres, Lit litType) {
        if (nbrChambres > 99) {
            throw new IllegalArgumentException("Can't have more than 99 \"chambres\"");
        }
        this.nomService = nomService;
        this.nbrChambres = nbrChambres;
        this.litType = litType;
        numService = numServiceTot;
        numServiceTot++;

        for (int i = 0; i < nbrChambres; i++) {
            chambres.add(new Chambre(Integer.valueOf("" + numService + String.format("%02d", i + 1)), (i % 2) + 1, litType));
        }
    }

    public int nbrChambreOccupe() {
        //TODO : implement method
        throw new UnsupportedOperationException();
    }

    public int nbrLitTot(){
        int nbrLit = 0;
        for (Chambre c : chambres) {
            nbrLit += c.getNbrLit();
        }
        return nbrLit;
    }

    public void addPatient(Patient p ) {
        for (Chambre c : chambres) {
            if(c.havePlace()){
                c.addPatient(p);
            }
        }
    }

    public String getNomService() {
        return nomService;
    }

    public int getNumService() {
        return numService;
    }

    public int getNbrChambres() {
        return nbrChambres;
    }

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public Lit getLitType() {
        return litType;
    }

    @Override
    public String toString() {
        StringBuilder ret =
                new StringBuilder("\n     nomService='" + nomService + "'"+
                        "\n     numService=" + numService +
                        "\n     nbrChambres=" + nbrChambres +
                        "\n     litType=" + litType.getClass().getName());
        for (Chambre c : chambres) {
            ret.append("\n          ").append(c);
        }
        return ret.toString();
    }
}
