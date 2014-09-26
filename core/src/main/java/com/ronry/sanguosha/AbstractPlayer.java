package com.ronry.sanguosha;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import com.ronry.sanguosha.card.Card;
import com.ronry.sanguosha.enums.Identity;
import com.ronry.sanguosha.event.Event;
import com.ronry.sanguosha.event.handler.EventHandlerManager;

public abstract class AbstractPlayer {

    private boolean             alive = true;

    private boolean              master;

    private Identity     identity;

    private Role         role;
	
	private List<AbstractPlayer> anotherPlays;
	
    private List<PlayStrategy>      cards;

    private CardManager  cardManager;

    private AbstractGame         game;

    private Judger              judger;

    private EventHandlerManager eventHandlerManager;

    private Queue<Event>        eventQueue = new LinkedBlockingDeque<Event>();

    public abstract Card askSha();

    public abstract Event next();

    public abstract void fireEvent(Event event);

    public abstract void show(Event event);

    public abstract Role selectRole(List<Role> candidators);

    public void prepareGrabCard() {
        role.prepareGrabCard(this, anotherPlays, cardManager);
    }

    public void grabCard() {
        role.grabCard(this, anotherPlays, cardManager);
    }

    public void play() {
        Event event;
        while ((event = this.next()) != null) {
            
        }
        role.paly(this, anotherPlays, cardManager);
    }

    public void postGrabCard() {
        role.postGrabCard(this, anotherPlays, cardManager);
    }

    /*
     * public EventResult fireEvent(Event event) { return eventHandlerManager.doFireEvent(this, event); }
     */

    public List<AbstractPlayer> getAnotherPlays() {
        return anotherPlays;
    }

    public void setAnotherPlays(List<AbstractPlayer> anotherPlays) {
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

    public AbstractGame getGame() {
        return game;
    }

    public void setGame(AbstractGame game) {
        this.game = game;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

}
