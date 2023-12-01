package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.time.*;

public class Patient {
    private int numSecuriteSocial;
    private String nom;
    private int souhaitChambre;
    private int numService;
    private LocalDateTime heureArrive;
    private ArrayList<Chambre> chambres;
    private Service service;
    private Chambre c;
    private int facture = 0;
    private Hopital hopital;

    public Patient(int numSecuriteSocial,String nom, int souhaitChambre , int numService, Hopital hopital){
        if (souhaitChambre>2 || souhaitChambre<=0){
            throw new IllegalArgumentException("Chambre souhaite n'existe pas");
        }
        this.nom = nom;
        this.numSecuriteSocial = numSecuriteSocial;
        this.souhaitChambre = souhaitChambre;
        this.numService = numService;
        heureArrive = LocalDateTime.now();
        this.hopital = hopital;


    }

    public int getSouhaitChambre() {
        return souhaitChambre;
    }

    public void partirChambre(){
        //TODO : implet
        throw new UnsupportedOperationException();
    }

    public LocalDateTime getHeureArrive() {
        return heureArrive;
    }
}
