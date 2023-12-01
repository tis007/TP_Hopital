package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.Date;

public class LitAmbulatoire extends Lit{
    public LitAmbulatoire(int tarif) {
        super(tarif);
    }

    @Override
    public long tempsOccupationMax() {
        return 86400;
    }
}
