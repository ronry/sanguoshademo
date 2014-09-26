package com.ronry.sanguosha;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

abstract public class AbstractGame {

    private AbstractPlayer       master;

    private List<AbstractPlayer> players;

    public AbstractGame(int playerCnt){
        players = newArrayList();
    }

    public void run() {
        for (AbstractPlayer player : players) {
            player.prepareGrabCard();
            player.grabCard();
            player.play();
        }
    }

    public void addPlayer(AbstractPlayer player) {
        this.players.add(player);
    }

    public void setPlayers(List<AbstractPlayer> players) {
        this.players = players;
    }

    public AbstractPlayer getMaster() {
        return master;
    }

    public void setMaster(AbstractPlayer master) {
        this.master = master;
    }

    public List<AbstractPlayer> getPlayers() {
        return players;
    }

}
