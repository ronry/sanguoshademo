package com.ronry.sanguosha.event.handler;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.event.Event;

public interface EventHandler<T extends Event<?>> {

    void handle(AbstractPlayer currentPalyer, T event);
}
