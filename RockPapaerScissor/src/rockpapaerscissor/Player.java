/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpapaerscissor;

/**
 *
 * @author sepehr
 */
public class Player implements Gamer {
    private final int[] values = {Gamer.rock, Gamer.paper, Gamer.scissor};
    private int selected;
    public Player(){
        
    }
    /**
     * 
     * @param selector most be static final int Rock, Paper, Scissor 
     */
    public void selectValue(int selector){
        if(selector >= 0 && selector <= 2)
            this.selected = selector;
        else throw new IllegalArgumentException();
    }
    @Override
    public int getValue(){
        return this.values[selected];
    }

    
}
