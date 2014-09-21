package com.ronry.sanguosha.role;

import java.util.List;

import com.ronry.sanguosha.CardManager;
import com.ronry.sanguosha.Player;

public class ZhuGeLiang extends AbstractRole {

    @Override
    public void prepareGrabCard(Player currentPalyer, List<Player> players, CardManager cardManager) {
        if (currentPalyer.doHumanDecide("使用技能")) {
            int alivePalyerCnt = 0;
            for (Player player : players) {
                if (player.isAlive()) {
                    alivePalyerCnt++;
                }
            }
        }
    }

}
