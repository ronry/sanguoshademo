package com.ronry.sanguosha.enums;

public enum Identity {
    
    ZHUGONG("主公"),

    ZHONGCHEN("忠臣"),

    FANZEI("反贼"),

    NEIJIAN("内奸");

    private String name;
    
    private Identity(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
