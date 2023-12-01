package org.example;

import java.util.ArrayList;

public class Hopital {

    private ArrayList<Service> services = new ArrayList<Service>();
    public Hopital() {
    }

    public boolean addPatient(int numSecuriteSocial,String nom, int souhaitChambre , int numService) {
        Patient p = new Patient(numSecuriteSocial,nom,souhaitChambre,numService, this);
        return addPatient(p);
    }

    public boolean addPatient(Patient p) {
        for (Service s : services){
            if (s.getNumService() == p.getNumService()) {
                s.addPatient(p);
                return true;
            }
        }
        return false;
    }

    public String removePatient(Patient p) {
        p.partirChambre();
        return "La facture est de : " + p.getFacture();
    }

    public void addService(Service service){
        if (this.services.size() > 9) {
            throw new IllegalArgumentException("Can't add more services");
        }
        services.add(service);
    }

    public double getTauxOccupationLit(Lit lit) {
        int nbrLitTot = 0;
        int nbrLitOccupe = 0;
        for (Service s : services) {
            if (lit.getClass().getName().equals(s.getLitType().getClass().getName())) {
                nbrLitTot += s.nbrLitTot();
            }
        }
        throw  new UnsupportedOperationException();
    }

    public Hopital(ArrayList<Service> services) {
        this.services = services;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("Hopital \n");
        for (Service s: services) {
            ret.append(s).append("\n");
        }
           return ret.toString();
    }
}
