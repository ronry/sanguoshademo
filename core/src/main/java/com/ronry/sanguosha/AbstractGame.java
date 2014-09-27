package com.ronry.sanguosha;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.ronry.sanguosha.event.SelectRoleEvent;
import com.ronry.sanguosha.event.ShowEvent;
import com.ronry.sanguosha.impl.DefaultJudger;
import com.ronry.sanguosha.role.ZhenJi;
import com.ronry.sanguosha.role.ZhuGeLiang;

abstract public class AbstractGame {

    protected int                  playerCnt;

    protected AbstractPlayer     master;

    protected List<AbstractPlayer> players;

    protected Judger               judger;

    protected CardManager          cardManager;

    public AbstractGame(int playerCnt){
        this.playerCnt = playerCnt;
        players = newArrayList();
        setJudger(new DefaultJudger());
        cardManager = new DefaultCardManager();
    }

    public void init() throws Exception {

    }

    public void selectRole() throws Exception {
        List<Role> candidators = newArrayList();
        candidators.add(new ZhenJi());
        candidators.add(new ZhuGeLiang());

        SelectRoleEvent sEvent = new SelectRoleEvent(candidators);
        getMaster().fireEvent(sEvent);

        Role selectedRole = sEvent.getFuture().get();

        List<AbstractPlayer> commonPlayers=getPlayerExclueOne(getMaster());
        judger.parallelSync(new ShowEvent("主公选择的是" + selectedRole.getName()), commonPlayers);
        List<Role> roles = judger.parallelSync(new SelectRoleEvent(candidators), commonPlayers);
        for (int i = 0; i < commonPlayers.size(); i++) {
            judger.parallelSync(new ShowEvent(commonPlayers.get(i).getName() + "选择的是" + roles.get(i).getName()),
                                getPlayerExclueOne(commonPlayers.get(i)));
        }
    }

    public void start() {
        for (AbstractPlayer player : players) {
            player.addCards(cardManager.distributeCard(player.getRole().getBaseCardCnt() + (player.isMaster() ? 1 : 0)));
        }
    }

    public List<AbstractPlayer> getPlayerExclueOne(final AbstractPlayer excluedPlayer) {
        return newArrayList(Collections2.filter(players, new Predicate<AbstractPlayer>() {
            @Override
            public boolean apply(AbstractPlayer input) {
                return !excluedPlayer.equals(input);
            }

        }));
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

    public Judger getJudger() {
        return judger;
    }

    public void setJudger(Judger judger) {
        this.judger = judger;
    }

}
