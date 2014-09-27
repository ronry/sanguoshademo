package com.ronry.sanguosha.console.event.handler;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.console.helper.ConsoleHelper;
import com.ronry.sanguosha.event.ShowEvent;
import com.ronry.sanguosha.event.handler.EventHandler;

public class ShowEventHandler implements EventHandler<ShowEvent> {

    @Override
    public void handle(AbstractPlayer currentPalyer, ShowEvent showEvent) {
        ConsoleHelper.out(showEvent.getMsg());
        showEvent.getFuture().set(null);
    }

}
