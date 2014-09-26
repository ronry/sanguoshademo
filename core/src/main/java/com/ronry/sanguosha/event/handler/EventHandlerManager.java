package com.ronry.sanguosha.event.handler;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.event.Event;
import com.ronry.sanguosha.event.EventResult;

public interface EventHandlerManager {

    EventResult doFireEvent(AbstractPlayer currentPalyer, Event event);

}
