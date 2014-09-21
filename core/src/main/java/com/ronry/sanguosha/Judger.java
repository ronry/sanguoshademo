package com.ronry.sanguosha;

import java.util.List;

import com.ronry.sanguosha.event.Event;

public interface Judger {

    Event sync(Event event, List<Player> players);

    Event parallelSync(Event event, List<Player> players);

}
