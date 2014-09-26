package com.ronry.sanguosha.event.handler;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.event.Event;
import com.ronry.sanguosha.event.EventResult;

public interface EventHandler {

    EventResult doEventFired(AbstractPlayer currentPalyer, Event event);
}
