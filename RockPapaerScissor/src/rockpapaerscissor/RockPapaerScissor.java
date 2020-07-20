/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpapaerscissor;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author sepehr
 */
public class RockPapaerScissor extends JFrame {
    Game game;
    public RockPapaerScissor(){
        this.setTitle("Rock Papaer Scissor");
        this.setSize(430, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        game = new Game();
        this.add(game);
        
        this.setVisible(true);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new RockPapaerScissor();
    }
    
}
