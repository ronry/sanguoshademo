package com.ronry.sanguosha.console;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.ronry.sanguosha.AbstractGame;
import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.IdentityDistributor;
import com.ronry.sanguosha.RandomIdentityDistributor;
import com.ronry.sanguosha.Role;
import com.ronry.sanguosha.enums.Identity;
import com.ronry.sanguosha.event.SelectRoleEvent;
import com.ronry.sanguosha.event.ShowEvent;
import com.ronry.sanguosha.role.ZhenJi;
import com.ronry.sanguosha.role.ZhuGeLiang;


public class ConsoleGame extends AbstractGame {

    public ConsoleGame(int playerCnt){
        super(playerCnt);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int playerCnt = Integer.parseInt(System.getProperty("playerCnt", "4"));

        ConsoleGame game = new ConsoleGame(playerCnt);

        IdentityDistributor identityDistributor = new RandomIdentityDistributor(playerCnt);
        for (int i = 1; i <= playerCnt; i++) {
            Identity identity = identityDistributor.next();
            ConsolePlayer player = new ConsolePlayer("player-" + i, identity, game);
            
            boolean isMaster=Identity.ZHUGONG.equals(identity);
            if (isMaster) {
                player.setMaster(true);
                game.setMaster(player);
            }
            player.fireEvent(new ShowEvent("游戏开始，你的身份是" + identity.getName() + (isMaster ? "" : "等待主公选将")));
            game.addPlayer(player);
        }

        List<Role> candidators = newArrayList();
        candidators.add(new ZhenJi());
        candidators.add(new ZhuGeLiang());

        SelectRoleEvent sEvent = new SelectRoleEvent(candidators);
        game.getMaster().fireEvent(sEvent);

        Role selectedRole = sEvent.getFuture().get();

        for (AbstractPlayer player : game.getPlayers()) {
            if (!player.isMaster()) {
                player.fireEvent(new ShowEvent("主公选择的是" + selectedRole.getName()));
                player.fireEvent(new SelectRoleEvent(candidators));
            }
        }

    }

}
