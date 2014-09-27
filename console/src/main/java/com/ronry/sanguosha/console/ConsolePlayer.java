package com.ronry.sanguosha.console;

import java.util.List;
import java.util.Scanner;

import com.ronry.sanguosha.AbstractGame;
import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.Role;
import com.ronry.sanguosha.card.Card;
import com.ronry.sanguosha.console.event.handler.ConsoleEventHandlerManager;
import com.ronry.sanguosha.console.helper.ConsoleHelper;
import com.ronry.sanguosha.enums.Identity;
import com.ronry.sanguosha.event.Event;
import com.ronry.sanguosha.event.handler.EventHandlerManager;


public class ConsolePlayer extends AbstractPlayer {
    
    private Scanner              scanner = new Scanner(System.in);

    private EventHandlerManager eventHandlerManager;

    public ConsolePlayer(String name, Identity identity, AbstractGame game) throws Exception{
        super();
        super.setName(name);
        super.setIdentity(identity);
        super.setGame(game);
        eventHandlerManager = new ConsoleEventHandlerManager();
        new Thread(new PlayerThread(this), name).start();
    }

    @Override
    public void fireEvent(Event<?> event) {
        queue.add(event);
    }

    @Override
    public Role selectRole(List<Role> candidators) {
        StringBuffer sb = new StringBuffer("请按数字选择武将：");
        for (int i = 1; i <= candidators.size(); i++) {
            sb.append(i + ". " + candidators.get(i - 1).getName() + "  ");
        }
        ConsoleHelper.out(sb.toString());
        Role role = candidators.get(Integer.parseInt(scanner.nextLine()) - 1);
        super.setRole(role);
        return role;
    }

    @Override
    public Card askSha() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Event<?> next() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void show(Event<?> event) {
        // TODO Auto-generated method stub

    }

    class PlayerThread implements Runnable {

        private AbstractPlayer player;

        public PlayerThread(AbstractPlayer player){
            // player可能为完全初始化,构造函数中不能用player做任何事情
            this.player = player;
        }

        @Override
        public void run() {
            while (true) {

                Event<?> event = queue.poll();
                if (event == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                } else {
                    eventHandlerManager.getHandler(event.getClass()).handle(player, event);
                }

            }
        }

    }

}
