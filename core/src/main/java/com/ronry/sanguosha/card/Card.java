package com.ronry.sanguosha.card;

import com.ronry.sanguosha.PlayStrategy;
import com.ronry.sanguosha.enums.CardVariety;

abstract public class Card extends PlayStrategy {

    private int num;

    private CardVariety variety;

    public Card(int num, CardVariety variety){
        this.num = num;
        this.variety = variety;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public CardVariety getVariety() {
        return variety;
    }

    public void setVariety(CardVariety variety) {
        this.variety = variety;
    }

}
