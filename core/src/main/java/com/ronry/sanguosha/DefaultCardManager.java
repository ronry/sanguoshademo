package com.ronry.sanguosha;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.ronry.sanguosha.card.Card;
import com.ronry.sanguosha.card.Sha;
import com.ronry.sanguosha.card.Shang;
import com.ronry.sanguosha.enums.CardVariety;


public class DefaultCardManager implements CardManager {

    private List<Card> unUserCards = newArrayList(new Sha(1, CardVariety.DIAMOND), new Shang(2, CardVariety.HEARTS),
                                                  new Shang(3, CardVariety.SPADE), new Sha(4, CardVariety.TITONI));

    @Override
    public void init() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public List<Card> distributeCard(int num) {
        return unUserCards.subList(0, num - 1);
    }

    @Override
    public void recycleCard(List<Card> cards) {
    }

    @Override
    public void recycleCardTail(List<Card> cards) {
    }

}
