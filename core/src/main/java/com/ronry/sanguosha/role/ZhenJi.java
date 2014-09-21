package com.ronry.sanguosha.role;

import java.util.List;

import com.ronry.sanguosha.CardManager;
import com.ronry.sanguosha.Player;
import com.ronry.sanguosha.card.Card;
import com.ronry.sanguosha.event.Event;
import com.ronry.sanguosha.event.JudgeEvent;

public class ZhenJi extends AbstractRole {

    private boolean simayiIn;

    @Override
    public void prepareGrabCard(Player currentPalyer, List<Player> players, CardManager cardManager) {
        Card nextCard;
        JudgeEvent judgeEvent;
        while (currentPalyer.doHumanDecide("使用技能")) {
            nextCard = cardManager.distributeCard(1).get(0);
            judgeEvent = new JudgeEvent();
            judgeEvent.setCard(nextCard);
            judgeEvent.setTriggerPlayer(currentPalyer);
            
            if (simayiIn) {
                Event resultEvent = currentPalyer.getJudger().sync(judgeEvent, players);

                if (resultEvent != null) {
                    nextCard = resultEvent.getCard();
                }
            }else{
                currentPalyer.getJudger().parallelSync(judgeEvent, players);
            }

            // FIXME 如果是黑桃
            currentPalyer.getCards().add(nextCard);

            // 否则跳出循环
        }

    }

    public void setSimayiIn(boolean simayiIn) {
        this.simayiIn = simayiIn;
    }

}
