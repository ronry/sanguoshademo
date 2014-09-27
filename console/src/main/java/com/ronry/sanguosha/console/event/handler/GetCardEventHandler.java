package com.ronry.sanguosha.console.event.handler;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.console.helper.ConsoleHelper;
import com.ronry.sanguosha.event.GetCardEvent;
import com.ronry.sanguosha.event.handler.EventHandler;


public class GetCardEventHandler implements EventHandler<GetCardEvent> {

    @Override
    public void handle(AbstractPlayer currentPalyer, GetCardEvent event) {
        ConsoleHelper.out("获得了手牌" + event.getCards());
    }

}
