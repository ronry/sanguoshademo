package com.ronry.sanguosha.event;

public class ShowEvent extends Event {

    public ShowEvent(String msg){
        super();
        this.msg = msg;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
