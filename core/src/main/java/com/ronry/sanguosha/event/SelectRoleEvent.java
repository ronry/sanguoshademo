package com.ronry.sanguosha.event;

import java.util.List;

import com.ronry.sanguosha.Role;

public class SelectRoleEvent extends Event<Role> {

    private List<Role> candidators;

    public SelectRoleEvent(){

    }

    public SelectRoleEvent(List<Role> candidators){
        super();
        this.candidators = candidators;
    }

    public List<Role> getCandidators() {
        return candidators;
    }

    public void setCandidators(List<Role> candidators) {
        this.candidators = candidators;
    }

}
