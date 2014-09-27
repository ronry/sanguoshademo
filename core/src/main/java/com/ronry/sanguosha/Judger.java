package com.ronry.sanguosha;

import java.util.Collection;
import java.util.List;

import com.ronry.sanguosha.event.Event;

public interface Judger {

    <T> List<T> sync(Event<T> event, Collection<AbstractPlayer> players);

    <T> List<T> parallelSync(Event<T> event, Collection<AbstractPlayer> players);

}
