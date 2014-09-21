package com.ronry.sanguosha;

import java.util.List;

public interface Role {

    public void prepareGrabCard(Player currentPalyer, List<Player> players, CardManager cardManager);

    public void grabCard(Player currentPalyer, List<Player> players, CardManager cardManager);

    public void paly(Player currentPalyer, List<Player> players, CardManager cardManager);

    public void postGrabCard(Player currentPalyer, List<Player> players, CardManager cardManager);

}
