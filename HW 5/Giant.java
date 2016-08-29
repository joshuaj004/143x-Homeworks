// Josh Johnson
// Assignment #5: Critters
// Friday, October 30th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This defines a simple class of critters that infect whenever they can and
// Hops when able to, and if those options are unavailable, turns left.
//

import java.awt.*;
    
public class Giant extends Critter {
    private int count;
    
    // Takes in info and returns a move depending on the conditions
    // Tries to infect any enemies, hops, or turns right, in that order.
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    // Returns the color gray
    public Color getColor() {
        return Color.GRAY;
    }

    // Every 6 turns, alternates between fee, foe, fum
    // in that order. After it gets to fum and completes 
    // 6 turns, it resets and starts over at fee 
    public String toString() {
        this.count++;
        if (this.count <= 6) {
            return "fee";
        } else if (this.count <= 12) {
            return "foe";
        } else {
            if (this.count == 18) {
                this.count = 0;
            }
            return "fum";        
        }
    }
}