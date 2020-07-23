package Tron;

import javax.swing.*;

public class Main extends JFrame {
    public Main(){
        setTitle("Tron");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        Game game = new Game();
        addKeyListener(game);
        add(game);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}
