package com.ronry.sanguosha.console.event.handler;

import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.Role;
import com.ronry.sanguosha.event.SelectRoleEvent;
import com.ronry.sanguosha.event.handler.EventHandler;


public class SelectRoleEventHandler implements EventHandler<SelectRoleEvent> {

    @Override
    public void handle(AbstractPlayer currentPalyer, SelectRoleEvent sEvent) {
        Role role = currentPalyer.selectRole(sEvent.getCandidators());
        sEvent.getFuture().set(role);
    }

}
