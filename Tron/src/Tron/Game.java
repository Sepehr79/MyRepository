package Tron;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Game extends JPanel implements Runnable, KeyListener {

    Thread t;
    Player player = new Player();

    public Game(){
        addKeyListener(player);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        player.paint(g);
    }

    @Override
    public void addNotify(){
        super.addNotify();
        t = new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        while(true){
            player.move();
            player.checkAccident();
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {


    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        player.keyPressed(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
