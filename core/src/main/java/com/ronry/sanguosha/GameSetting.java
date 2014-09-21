package com.ronry.sanguosha;

public class GameSetting {

    private static GameSetting instance = new GameSetting();

    public int time = 10 * 1000;
    
    public static GameSetting getInstance() {
        return instance;
    }

    private GameSetting(){
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
