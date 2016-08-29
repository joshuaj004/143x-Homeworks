// Josh Johnson
// Assignment #5: Critters
// Friday, October 30th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This defines a simple class of critters that infect whenever they can and
// Hops when able to, and if those options are unavailable, turns left.

import java.awt.*;
    
public class Bear extends Critter {
    private int count;
    private boolean polar;
    
    // Takes in the boolean polar and stores the value as this.polar
    public Bear(boolean polar) {
        this.polar = polar;
    }
    
    // Takes in info and returns a move depending on the conditions
    // Tries to infect any enemies, hops, or turns left, in that order.
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    // Returns black or white depending if the this.polar is true or not
    public Color getColor() {
        if (this.polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    // Alternates between returning / or \. Starts with /.
    public String toString() {
        this.count++;
        if (this.count % 2 == 0) {
            return "\\";
        } else {
            return "/";
        }        
    }
}