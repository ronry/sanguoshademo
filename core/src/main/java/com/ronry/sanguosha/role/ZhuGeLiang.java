package com.ronry.sanguosha.role;

import java.util.List;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.CardManager;
import com.ronry.sanguosha.card.Card;
import com.ronry.sanguosha.event.SkillEvent;
import com.ronry.sanguosha.skill.Skill;

public class ZhuGeLiang extends BaseRole {

    public ZhuGeLiang(){
        super.name = "诸葛亮";
        super.baseCardCnt = 3;
        super.baseHp = 3;
    }

    @Override
    public void prepareGrabCard(AbstractPlayer currentPalyer, List<AbstractPlayer> players, CardManager cardManager) {
        /*
         * if (currentPalyer.doHumanDecide("使用技能")) { int alivePalyerCnt = 0; for (Player player : players) { if
         * (player.isAlive()) { alivePalyerCnt++; } } List<Card> seenCards = cardManager.distributeCard(alivePalyerCnt);
         * GuanXingEvent event = new GuanXingEvent(); event.setTriggerPlayer(currentPalyer);
         * event.setSeenCards(seenCards); currentPalyer.getJudger().parallelSync(event, players); }
         */
    }
    
    public static class GuanXingEvent extends SkillEvent {

        private List<Card> seenCards;

        public List<Card> getSeenCards() {
            return seenCards;
        }

        public void setSeenCards(List<Card> seenCards) {
            this.seenCards = seenCards;
        }

    }

    public static class GuanXing extends Skill {
        
    }

}
