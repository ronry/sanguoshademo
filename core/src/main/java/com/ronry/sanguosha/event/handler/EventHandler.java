package com.ronry.sanguosha.event.handler;

import com.ronry.sanguosha.Player;
import com.ronry.sanguosha.event.Event;
import com.ronry.sanguosha.event.EventResult;

public interface EventHandler {

    EventResult doEventFired(Player currentPalyer, Event event);
}
