/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpapaerscissor;

import java.util.Random;

/**
 *
 * @author sepehr
 */
public class Computer implements Gamer {
    private final int[] values = {Gamer.rock, Gamer.paper, Gamer.scissor};
    private final Random random = new Random();
    private final int randomSelector;
    public Computer(){
        randomSelector = random.nextInt(3);
    }
    /**
     * 
     * @return Value of selected 
     */
    @Override
    public int getValue(){
        return values[this.randomSelector];
    }
}
