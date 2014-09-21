package com.ronry.sanguosha.role;

import java.util.List;

import com.ronry.sanguosha.CardManager;
import com.ronry.sanguosha.Player;
import com.ronry.sanguosha.Role;


public abstract class AbstractRole implements Role {

    @Override
    public void prepareGrabCard(Player currentPalyer, List<Player> players, CardManager cardManager) {

    }

    @Override
    public void grabCard(Player currentPalyer, List<Player> players, CardManager cardManager) {

    }

    @Override
    public void paly(Player currentPalyer, List<Player> players, CardManager cardManager) {

    }

    @Override
    public void postGrabCard(Player currentPalyer, List<Player> players, CardManager cardManager) {

    }

}
