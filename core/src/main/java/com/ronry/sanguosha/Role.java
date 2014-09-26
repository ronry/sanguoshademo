package com.ronry.sanguosha;

import java.util.List;

public abstract class Role {

    protected String name;

    public abstract void prepareGrabCard(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager);

    public abstract void grabCard(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager);

    public abstract void paly(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager);

    public abstract void postGrabCard(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
