package Tron;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player implements KeyListener {

    private int XPos = 0;
    private int YPos = 0;
    public int getXPos(){
        return this.XPos;
    }
    public int getYPos(){
        return this.YPos;
    }

    private boolean right = true;
    private boolean left = false;
    private boolean top = false;
    private boolean button = false;

    private BufferedImage rightImage;
    private BufferedImage leftImage;
    private BufferedImage topImage;
    private BufferedImage buttonImage;

    private BufferedImage lineRow;
    private BufferedImage lineColumn;

    private boolean[][] isRow = new boolean[800][800];
    private boolean[][] position = new boolean[800][800];

    public Player(){
        //position[0][0] = true;
        //isRow[0][0] = true;
        try {
            rightImage = ImageIO.read(new File("rightImage.png"));
            leftImage = ImageIO.read(new File("leftImage.png"));
            topImage = ImageIO.read(new File("topImage.png"));
            buttonImage = ImageIO.read(new File("buttonImage.png"));
            lineRow = ImageIO.read(new File("lineRow.png"));
            lineColumn = ImageIO.read(new File("lineColumn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        if(right)
            g2.drawImage(rightImage, getXPos()+8, getYPos()-7, null);
        if (left)
            g2.drawImage(leftImage, getXPos()-35, getYPos()-7, null);
        if(top)
            g2.drawImage(topImage, getXPos()-7, getYPos()-35, null);
        if(button)
            g2.drawImage(buttonImage, getXPos()-7, getYPos()+6, null);

        for(int i = 0 ; i < position.length ; i++){
            for(int j = 0 ; j < position[i].length; j++){
                if(position[i][j] == true && isRow[i][j])
                    g2.drawImage(lineRow, i, j, null);
                if(position[i][j] == true && !isRow[i][j])
                    g2.drawImage(lineColumn, i, j, null);
            }
        }
    }

    public void move(){

        if(right)
            XPos++;
        if(left)
            XPos--;
        if(top)
            YPos--;
        if(button)
            YPos++;

        position[getXPos()][getYPos()] = true;

        if(right || left)
            isRow[getXPos()][getYPos()] = true;
        if(top || button)
            isRow[getXPos()][getYPos()] = false;
    }

    public void checkAccident(){
        if(right){
            if(position[getXPos()+45][getYPos()] == true)
                System.out.println("lose");
        }
        if(top){

        }
        if(left){

        }
        if(button){

        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && !left) {
            right = true;
            left = false;
            top = false;
            button = false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT && !right) {
            right = false;
            left = true;
            top = false;
            button = false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP && !button) {
            right = false;
            left = false;
            top = true;
            button = false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN && !top) {
            right = false;
            left = false;
            top = false;
            button = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
