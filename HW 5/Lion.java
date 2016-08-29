// Josh Johnson
// Assignment #5: Critters
// Friday, October 30th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This defines a simple class of critters that infect whenever they can.
// Turns left if a wall is in front or to the right, and turns left if 
// a lion is in front. Otherwise, the lion will hop.

import java.awt.*;
import java.util.*;

public class Lion extends Critter {
    private Random r;
    private int count;
    private Color currentColor;
    
    // Takes in info and returns a move depending on the conditions
    // Tries to infect any enemies, turns left if it encounters a wall
    // in front or to the right. If there's a lion in front, it will turn
    // left. Otherwise it will hop.
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if ((info.getFront() == Neighbor.WALL)
                    || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront()  == Neighbor.SAME) {
            return Action.LEFT;
        } else {
            return Action.HOP;
        }
    }

    // Every 3 turns returns a random color choosen 
    // between red, green, or blue.
    public Color getColor() {
        if (this.count % 3 == 0) {
            this.r = new Random();
            int lionColor = r.nextInt(3);
            if (lionColor == 0) {
                this.currentColor = Color.RED;
            } else if (lionColor == 1) {
                this.currentColor = Color.GREEN;
            } else {
                this.currentColor = Color.BLUE;
            }
        }
        this.count++;
        return this.currentColor;
    }

    // Returns an L 
    public String toString() {
        return "L";
    }
}