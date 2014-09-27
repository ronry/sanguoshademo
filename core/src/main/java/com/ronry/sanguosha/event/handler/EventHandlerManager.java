package com.ronry.sanguosha.event.handler;

import com.ronry.sanguosha.event.Event;



public interface EventHandlerManager {

    EventHandler<Event<?>> getHandler(Class<?> eventType);

}
