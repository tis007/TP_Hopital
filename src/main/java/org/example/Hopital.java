package org.example;

import java.util.ArrayList;

public class Hopital {

    private ArrayList<Service> services = new ArrayList<Service>();
    public Hopital() {
    }

    public void addService(Service service){
        if (this.services.size() > 9) {
            throw new IllegalArgumentException("Can't add more services");
        }
        services.add(service);
    }

    public Hopital(ArrayList<Service> services) {
        this.services = services;
    }
}
