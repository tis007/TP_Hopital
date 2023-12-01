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
    public Patient(int numSecuriteSocial,String nom, int souhaitChambre , int numService){
        this.nom = nom;
        this.numSecuriteSocial = numSecuriteSocial;
        this.souhaitChambre = souhaitChambre;
        this.numService = numService;
        heureArrive = LocalDateTime.now();
    }

    public LocalDateTime getHeureArrive() {
        return heureArrive;
    }
}
