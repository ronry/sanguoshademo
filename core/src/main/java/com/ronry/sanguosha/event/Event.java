package com.ronry.sanguosha.event;

import com.google.common.util.concurrent.SettableFuture;
import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.card.Card;
import com.ronry.sanguosha.enums.EventType;

public class Event<T> {

    private EventType type;

    private AbstractPlayer    triggerPlayer;

    private AbstractPlayer    targerPalyer;

    private Card      card;

    private SettableFuture<T> future = SettableFuture.create(); ;

    public SettableFuture<T> getFuture() {
        return future;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public AbstractPlayer getTriggerPlayer() {
        return triggerPlayer;
    }

    public void setTriggerPlayer(AbstractPlayer triggerPlayer) {
        this.triggerPlayer = triggerPlayer;
    }

    public AbstractPlayer getTargerPalyer() {
        return targerPalyer;
    }

    public void setTargerPalyer(AbstractPlayer targerPalyer) {
        this.targerPalyer = targerPalyer;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
