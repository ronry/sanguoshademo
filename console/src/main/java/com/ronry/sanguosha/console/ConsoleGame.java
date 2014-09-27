package com.ronry.sanguosha.console;

import com.ronry.sanguosha.AbstractGame;
import com.ronry.sanguosha.IdentityDistributor;
import com.ronry.sanguosha.RandomIdentityDistributor;
import com.ronry.sanguosha.enums.Identity;
import com.ronry.sanguosha.event.ShowEvent;


public class ConsoleGame extends AbstractGame {

    public ConsoleGame(int playerCnt){
        super(playerCnt);
    }

    public void init() throws Exception {
        IdentityDistributor identityDistributor = new RandomIdentityDistributor(playerCnt);
        for (int i = 1; i <= playerCnt; i++) {
            Identity identity = identityDistributor.next();
            ConsolePlayer player = new ConsolePlayer("player-" + i, identity, this);
            boolean isMaster = Identity.ZHUGONG.equals(identity);
            if (isMaster) {
                player.setMaster(true);
                this.setMaster(player);
            }
            player.fireEvent(new ShowEvent("游戏开始，你的身份是" + identity.getName() + (isMaster ? "" : "等待主公选将")));
            this.addPlayer(player);
        }
    }

    public static void main(String[] args) throws Exception {

        int playerCnt = Integer.parseInt(System.getProperty("playerCnt", "4"));

        ConsoleGame game = new ConsoleGame(playerCnt);
        game.init();
        game.selectRole();
        game.start();
    }

}
