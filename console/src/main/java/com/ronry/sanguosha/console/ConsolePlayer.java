package com.ronry.sanguosha.console;

import static com.google.common.collect.Queues.newLinkedBlockingDeque;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.ronry.sanguosha.AbstractGame;
import com.ronry.sanguosha.AbstractPlayer;
import com.ronry.sanguosha.Role;
import com.ronry.sanguosha.card.Card;
import com.ronry.sanguosha.enums.Identity;
import com.ronry.sanguosha.event.Event;
import com.ronry.sanguosha.event.SelectRoleEvent;
import com.ronry.sanguosha.event.ShowEvent;


public class ConsolePlayer extends AbstractPlayer {
    
    private Scanner              scanner = new Scanner(System.in);

    private final Queue<Event> queue   = newLinkedBlockingDeque();

    public ConsolePlayer(String name, Identity identity, AbstractGame game){
        super();
        super.setIdentity(identity);
        super.setGame(game);
        new Thread(new PlayerThread(this), name).start();
    }

    @Override
    public void fireEvent(Event event) {
        queue.add(event);
    }

    @Override
    public Role selectRole(List<Role> candidators) {
        StringBuffer sb = new StringBuffer(Thread.currentThread().getName() + ":请按数字选择武将：");
        for (int i = 1; i <= candidators.size(); i++) {
            sb.append(i + ". " + candidators.get(i - 1).getName() + "  ");
        }
        System.out.println(sb.toString());
        return candidators.get(Integer.parseInt(scanner.nextLine()) - 1);
    }

    @Override
    public Card askSha() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Event next() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void show(Event event) {
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
                        // System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (event instanceof ShowEvent) {
                    ShowEvent showEvent = (ShowEvent) event;
                    System.out.println(Thread.currentThread().getName() + ":" + showEvent.getMsg());
                } else if (event instanceof SelectRoleEvent) {
                    SelectRoleEvent sEvent = (SelectRoleEvent) event;
                    Role role = player.selectRole(sEvent.getCandidators());
                    sEvent.getFuture().set(role);
                }

            }
        }

    }

}
