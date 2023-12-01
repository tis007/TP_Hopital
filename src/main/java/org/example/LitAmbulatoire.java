package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.Date;

public class LitAmbulatoire extends Lit{
    public LitAmbulatoire(int tarif, Chambre c) {
        super(tarif, c);
    }

    @Override
    public long tempsOccupationMax() {
        return 86400;
    }
}
