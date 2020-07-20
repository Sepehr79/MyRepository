/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpapaerscissor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author sepehr
 */
public class Game extends JPanel implements ActionListener {
    private final Player player = new Player();
    private final Computer computer = new Computer();
    
    private JButton rock = new JButton("Rock");
    private JButton paper = new JButton("Paper");
    private JButton scissor = new JButton("Scissor");
    private JButton reset = new JButton("reset");
    
    private BufferedImage rockImage;
    private BufferedImage scissorImage;
    private BufferedImage paperImage;
    
    private boolean firstClick = false;
    
    private JLabel rockLabel; 
    private JLabel paperLabel; 
    private JLabel scissorLabel; 
    
    private JPanel finalPanel;
    private JLabel rockComputerLabel;
    private JLabel paperComputerLabel;
    private JLabel scissorComputerLabel;
    private JLabel finalLabel;
    
    public Game(){
        rockLabel = new JLabel(new ImageIcon("Rock.png"));
        rockLabel.setBounds(100, 50, 100, 100);
        rockLabel.setVisible(false);
        add(rockLabel);
        paperLabel = new JLabel(new ImageIcon("Paper.png"));
        paperLabel.setBounds(100, 50, 100, 100);
        paperLabel.setVisible(false);
        add(paperLabel);
        scissorLabel = new JLabel(new ImageIcon("Scissor.png"));
        scissorLabel.setBounds(100, 50, 100, 100);
        scissorLabel.setVisible(false);
        add(scissorLabel);
        
        
        rockComputerLabel = new JLabel(new ImageIcon("RockComputer.png"));
        rockComputerLabel.setBounds(235, 50, 100, 100);
        rockComputerLabel.setVisible(false);
        add(rockComputerLabel);
        paperComputerLabel = new JLabel(new ImageIcon("PaperComputer.png"));
        paperComputerLabel.setBounds(235, 50, 100, 100);
        paperComputerLabel.setVisible(false);
        add(paperComputerLabel);
        scissorComputerLabel = new JLabel(new ImageIcon("ScissorComputer.png"));
        scissorComputerLabel.setBounds(235, 50, 100, 100);
        scissorComputerLabel.setVisible(false);
        add(scissorComputerLabel);
        
        finalLabel = new JLabel();
        finalLabel.setText("Select!");      
        finalLabel.setForeground(Color.BLUE);
        
        finalPanel = new JPanel();
        finalPanel.setBounds(0, 200, 430, 20);
        finalPanel.add(finalLabel);
        this.add(finalPanel);
        
        
        try {
                rockImage = ImageIO.read(new File("Rock.png"));
                paperImage = ImageIO.read(new File("Paper.png"));
                scissorImage = ImageIO.read(new File("Scissor.png"));
            } 
        catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.setLayout(null);
            
            rock.setBounds(50, 400, 100, 20);
            rock.addActionListener(this);
            this.add(rock);
            
            paper.setBounds(170, 400, 100, 20);
            paper.addActionListener(this);
            this.add(paper);
            
            scissor.setBounds(290, 400, 100, 20);
            scissor.addActionListener(this);
            this.add(scissor);

            reset.setBounds(165, 230, 100, 20);
            this.add(reset);
            reset.addActionListener(this);
            reset.setVisible(false);
            
            
        
    }
    //paint method
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.drawRect(100, 50, 100, 100);
        g2.drawString("VS", 210, 105);
        g2.drawRect(235, 50, 100, 100);
        g2.setColor(Color.BLUE);
        g2.drawString("You", 140, 170);
        g2.drawString("Computer", 255, 170);
        
        g2.drawImage(rockImage, 50, 290, null);
        g2.drawImage(paperImage, 170, 290, null);
        g2.drawImage(scissorImage, 290, 290, null);
        
        
    }
    
    private void showComputerSelect(){
        if(computer.getValue() == Gamer.rock)
            rockComputerLabel.setVisible(true);
        if(computer.getValue() == Gamer.paper)
            paperComputerLabel.setVisible(true);
        if(computer.getValue() == Gamer.scissor)
            scissorComputerLabel.setVisible(true);
    }
    
    public Gamer getWinner(Gamer gamer1, Gamer gamer2) throws DrawExcpetion{
        if(gamer1.getValue() == Gamer.rock && gamer2.getValue() == Gamer.scissor)
            return gamer1;
        else if(gamer1.getValue() == (Gamer.rock) && gamer2.getValue() == (Gamer.paper))
            return gamer2;
        else if(gamer1.getValue() == (Gamer.paper) && gamer2.getValue() == (Gamer.rock))
            return gamer1;
        else if(gamer1.getValue() == (Gamer.paper) && gamer2.getValue() == (Gamer.scissor))
            return gamer2;
        else if(gamer1.getValue() == (Gamer.scissor) && gamer2.getValue() == (Gamer.rock))
            return gamer2;
        else if(gamer1.getValue() == (Gamer.scissor) && gamer2.getValue() == (Gamer.paper))
            return gamer1;
        else
            throw new DrawExcpetion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reset){
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
            new RockPapaerScissor();
        }
        else if(!this.firstClick){
                if(e.getSource() == rock){
                    player.selectValue(Gamer.rock);
                    this.rockLabel.setVisible(true);
                }
                else if(e.getSource() == paper){
                    player.selectValue(Gamer.paper);
                    this.paperLabel.setVisible(true);
                }
                else if(e.getSource() == scissor){
                    player.selectValue(Gamer.scissor);
                    this.scissorLabel.setVisible(true);
                }
                this.firstClick = true;
                this.showComputerSelect();
                reset.setVisible(true);
                
                
            try {    
                Gamer winner = this.getWinner(this.player , this.computer);
                if(winner instanceof Player){
                    finalLabel.setForeground(Color.GREEN);
                    finalLabel.setText("You Won!");
                }
                else if(winner instanceof Computer){
                    finalLabel.setForeground(Color.RED);
                    finalLabel.setText("You Lost!");
                }
            } catch (DrawExcpetion ex) {
                finalLabel.setForeground(Color.ORANGE);
                finalLabel.setText("You Draw!");
            }
            
        /*JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();
        new RockPapaerScissor();*/
        }
    }

}
class DrawExcpetion extends Exception{
    @Override
    public String toString(){
        return "Draw between two players";
    }
}
