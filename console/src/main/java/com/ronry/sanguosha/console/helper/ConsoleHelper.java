package com.ronry.sanguosha.console.helper;

public class ConsoleHelper {

    public static void out(String msg) {
        System.out.println(String.format("[%s]      %s", Thread.currentThread().getName(), msg));
    }

}
