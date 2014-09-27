package com.ronry.sanguosha.event;

import java.util.List;

import com.ronry.sanguosha.card.Card;

public class GetCardEvent extends Event<Void> {

    private List<Card> cards;

    public GetCardEvent(List<Card> cards){
        super();
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

}
