package com.ronry.sanguosha;

import java.util.List;

import com.ronry.sanguosha.card.Card;

public interface CardManager {

    public void init();

    public void refresh();

    public List<Card> distributeCard(int num);

    public void recycleCard(List<Card> cards);

    public void recycleCardTail(List<Card> cards);

}
