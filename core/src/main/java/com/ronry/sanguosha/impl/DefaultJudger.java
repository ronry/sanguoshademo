package com.ronry.sanguosha.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.Judger;
import com.ronry.sanguosha.event.Event;


public class DefaultJudger implements Judger {

    @Override
    public Event parallelSync(final Event event, final List<AbstractPlayer> players) {
        final CountDownLatch latch = new CountDownLatch(players.size());

        final List<Event> result = new ArrayList<Event>();
        for (int i = 0; i < players.size(); i++) {
            final AbstractPlayer player = players.get(i);
            new Thread(new Runnable() {

                @Override
                public void run() {
                    /*
                     * EventResult eventResult = player.fireEvent(event); if (eventResult != null) { // FIXME 回传结果 }
                     */

                    latch.countDown();
                }

            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
        }

        return result.get(0);
    }

    @Override
    public Event sync(Event event, List<AbstractPlayer> players) {
        return null;
    }

}
