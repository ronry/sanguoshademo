package com.ronry.sanguosha.event;

import com.ronry.sanguosha.Player;
import com.ronry.sanguosha.card.Card;
import com.ronry.sanguosha.enums.EventType;

public class Event {

    private EventType type;

    private Player    triggerPlayer;

    private Player    targerPalyer;

    private Card      card;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Player getTriggerPlayer() {
        return triggerPlayer;
    }

    public void setTriggerPlayer(Player triggerPlayer) {
        this.triggerPlayer = triggerPlayer;
    }

    public Player getTargerPalyer() {
        return targerPalyer;
    }

    public void setTargerPalyer(Player targerPalyer) {
        this.targerPalyer = targerPalyer;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
