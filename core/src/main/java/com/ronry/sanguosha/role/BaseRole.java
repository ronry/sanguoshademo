package com.ronry.sanguosha.role;

import java.util.List;

import com.ronry.sanguosha.CardManager;
import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.Role;


public abstract class BaseRole extends Role {

    @Override
    public void prepareGrabCard(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager) {

    }

    @Override
    public void grabCard(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager) {

    }

    @Override
    public void paly(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager) {

    }

    @Override
    public void postGrabCard(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager) {

    }

}
