package org.example;

import java.util.ArrayList;
import java.util.Arrays;
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

    public int nbrLitTot(){
        int nbrLit = 0;
        for (Chambre c : chambres) {
            nbrLit += c.getNbrLit();
        }
        return nbrLit;
    }

    public int getNbrLitLibre() {
        int nbr = 0;
        for (Chambre c : chambres) {
            nbr += c.getNbrLitLibre();
        }
        return nbr;
    }

    public void addPatient(Patient p ) {
        boolean isAdded = false;
        for (Chambre c : chambres) {
            if(c.havePlace() && c.getNbrLit() == p.getSouhaitChambre() && !isAdded){
                c.addPatient(p);
                isAdded = true;
            }
        }
        if (!isAdded) {
            for (Chambre c : chambres) {
                if(c.havePlace() && !isAdded){
                    c.addPatient(p);
                    isAdded = true;
                }
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
    public ArrayList<Lit> tempsDepasse(){
        ArrayList<Lit> listLitTempsDepasse = new ArrayList<Lit>();
        for(Chambre c : chambres){
            listLitTempsDepasse.addAll(c.tempsDepasse());
        }
        return listLitTempsDepasse;
    }
}
