package com.ronry.sanguosha.role;

import java.util.List;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.CardManager;
import com.ronry.sanguosha.event.Changeable;
import com.ronry.sanguosha.event.SkillEvent;
import com.ronry.sanguosha.skill.Skill;

public class ZhenJi extends BaseRole {

    private boolean simayiIn;

    public ZhenJi(){
        super.name = "甄姬";
    }

    @Override
    public void prepareGrabCard(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager) {
        /*
         * Event nextEvent; while ((nextEvent = currentPalyer.next()) != null) { nextCard =
         * cardManager.distributeCard(1).get(0); LuoShenEvent luoshenEvent = new LuoShenEvent();
         * luoshenEvent.setCard(nextCard); luoshenEvent.setTriggerPlayer(currentPalyer); if (simayiIn) { Event
         * resultEvent = currentPalyer.getJudger().sync(luoshenEvent, players); if (resultEvent != null) { nextCard =
         * resultEvent.getCard(); } }else{ currentPalyer.getJudger().parallelSync(luoshenEvent, players); } // FIXME
         * 如果是黑桃 currentPalyer.getCards().add(nextCard); // 否则跳出循环 }
         */

    }

    public void setSimayiIn(boolean simayiIn) {
        this.simayiIn = simayiIn;
    }

    public static class LuoShenEvent extends SkillEvent implements Changeable {

    }

    public static class LuoShen extends Skill {

    }

}
