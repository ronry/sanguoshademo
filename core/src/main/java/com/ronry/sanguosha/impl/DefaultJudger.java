package com.ronry.sanguosha.impl;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import net.sf.cglib.beans.BeanCopier;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.Judger;
import com.ronry.sanguosha.event.Event;


public class DefaultJudger implements Judger {

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> parallelSync(final Event<T> event, final Collection<AbstractPlayer> players) {
        BeanCopier copier = BeanCopier.create(event.getClass(), event.getClass(), false);
        List<T> result = newArrayList();
        List<Event<T>> events = newArrayList();
        for (final AbstractPlayer player : players) {
            Event<T> newEvent;
            try {
                newEvent = event.getClass().newInstance();
                events.add(newEvent);
                copier.copy(event, newEvent, null);
                player.fireEvent(newEvent);
            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println(e);
            }
        }

        for (final Event<T> newEvent : events) {
            try {
                result.add(newEvent.getFuture().get());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return result;
    }

    @Override
    public <T> List<T> sync(Event<T> event, Collection<AbstractPlayer> players) {
        return null;
    }

}
