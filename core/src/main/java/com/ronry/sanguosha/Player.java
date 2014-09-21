package com.ronry.sanguosha;

import java.util.List;

import com.ronry.sanguosha.enums.Identity;
import com.ronry.sanguosha.event.Event;
import com.ronry.sanguosha.event.EventResult;
import com.ronry.sanguosha.event.handler.EventHandlerManager;

public abstract class Player {

    private boolean             alive = true;

    private Identity     identity;

    private Role         role;
	
	private List<Player> anotherPlays;
	
    private List<PlayStrategy>      cards;

    private CardManager  cardManager;

    private Judger              judger;

    private EventHandlerManager eventHandlerManager;

    // FIXME 加上超时机制
    public boolean humanDecide(String msg) {
        return this.doHumanDecide(msg);
    }

    /**
     * 此方法需要以异步的方式实现
     * 
     * @param msg
     * @return
     */
    public abstract boolean doHumanDecide(String msg);

    public abstract PlayStrategy next();

    public void prepareGrabCard() {
        role.prepareGrabCard(this, anotherPlays, cardManager);
    }

    public void grabCard() {
        role.grabCard(this, anotherPlays, cardManager);
    }

    public void paly() {
        PlayStrategy strategy;
        while ((strategy = this.next()) != null) {
            
        }
        role.paly(this, anotherPlays, cardManager);
    }

    public void postGrabCard() {
        role.postGrabCard(this, anotherPlays, cardManager);
    }

    public EventResult fireEvent(Event event) {
        return eventHandlerManager.doFireEvent(this, event);
    }

    public List<Player> getAnotherPlays() {
        return anotherPlays;
    }

    public void setAnotherPlays(List<Player> anotherPlays) {
        this.anotherPlays = anotherPlays;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<PlayStrategy> getCards() {
        return cards;
    }

    public void setCards(List<PlayStrategy> cards) {
        this.cards = cards;
    }

    public CardManager getCardManager() {
        return cardManager;
    }

    public void setCardManager(CardManager cardManager) {
        this.cardManager = cardManager;
    }

    public EventHandlerManager getEventHandlerManager() {
        return eventHandlerManager;
    }

    public void setEventHandlerManager(EventHandlerManager eventHandlerManager) {
        this.eventHandlerManager = eventHandlerManager;
    }

    public Judger getJudger() {
        return judger;
    }

    public void setJudger(Judger judger) {
        this.judger = judger;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
