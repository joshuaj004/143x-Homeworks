import java.util.*;
import java.io.*;

public class AssassinManager {
	AssassinNode killRing;
    AssassinNode graveyard;
   
    // Throws an IllegalArgumentException if the list of names has no names.
    // Adds a name to the killRing for each name in the name list.
	public AssassinManager(List<String> names) 
                throws IllegalArgumentException {
		if ((names == null) || (names.size() < 1)) {
			throw new IllegalArgumentException();
		}
		this.killRing = new AssassinNode(names.get(0));
		AssassinNode killRingPointer = killRing;
		for (int i = 1; i < names.size(); i++) {
			killRingPointer.next = new AssassinNode(names.get(i));
			killRingPointer = killRingPointer.next;
		}
	}
	
    // Prints out who is stalking who in the killRing.
    // The killRing should have at least 1 person in it for this to 
    // function properly.
	public void printKillRing() {
		AssassinNode killRingPointer = this.killRing;
		while (killRingPointer.next != null) {
			System.out.println("    " + killRingPointer.name + " is stalking " 
                    + killRingPointer.next.name);
			killRingPointer = killRingPointer.next;
		}
        System.out.println("    " + killRingPointer.name + " is stalking " 
                + this.killRing.name);
	}
	
    // Prints who was murdered by who. If nobody was murdered, 
    // it prints nothing.
	public void printGraveyard() {
        AssassinNode graveyardPointer = this.graveyard;
        while (graveyardPointer != null) {
            System.out.println("    " + graveyardPointer.name +  
                    " was killed by " + graveyardPointer.killer);
            graveyardPointer = graveyardPointer.next;
        }       
	}
	
    // Returns true if killRing contains the inputted name. 
    // Returns False otherwise.
	public boolean killRingContains(String name) {
		return this.personChainContains(this.killRing, name);
	}
	
    // Returns true if graveyard contains the inputted name. 
    // Returns False otherwise.
	public boolean graveyardContains(String name) {
        return this.personChainContains(this.graveyard, name);
	}
	
    // A private method that takes in an assasinNode chain
    // and a name and returns true if the name is in the 
    // given assasinNode chain
    private boolean personChainContains(AssassinNode personChain, 
                String name) {
        AssassinNode personChainPointer = this.assasinNodeChain(personChain);
        while (personChainPointer != null) {
            if ((personChainPointer.name).equalsIgnoreCase(name)) {
                return true;
            }
            personChainPointer = personChainPointer.next;
        }
        return false;
    }
    
    // Returns true if the game is over, false if it isn't
	public boolean isGameOver() {
        return (this.killRing.next == null);
	}
	
    // If the game is over, it returns who the winner is.
    // If the game isn't over, it returns null.
	public String winner() {
		if (this.isGameOver()) {
            return this.killRing.name;
        } else {
            return null;
        }       
	}
    
    // A private method that takes in an AssassinNode and returns
    // either the killRing or the graveyard. Useful when a method needs
    // to be able to work for either AssassinNode
    private AssassinNode assasinNodeChain(AssassinNode personChain) {
        if (this.nodeNameComparer(killRing, personChain)) {
            return this.killRing;
        } else {
            return this.graveyard;
        }
    }
    
    // A private method that finds the last not in a string. Can be
    // be used with an empty AssassinNode, and will return a pointer
    // to the last node in that chain.
    private AssassinNode lastNode(AssassinNode personChain) {
        AssassinNode lastNodePointer = this.assasinNodeChain(personChain);
        if (lastNodePointer == null) {
            return lastNodePointer;
        }
        while (lastNodePointer.next != null) {
            lastNodePointer = lastNodePointer.next;
        }
        return lastNodePointer;
    }
    
    // A private method that takes in 2 nodes and checks if 
    // they're the same regardless of capitalization. Returns false
    // if either of the nodes or null or if the two nodes
    // are not equal. If they are, it returns true.
    private boolean nodeNameComparer(AssassinNode firstNode, 
                AssassinNode secondNode) {
        if (firstNode == null && secondNode != null) {
            return false;
        } else if (firstNode != null && secondNode == null) {
            return false;
        }
        return (firstNode.name).equalsIgnoreCase(secondNode.name);
    }
    
    // A private method that adjusts the AssassinNodes and their pointers
    // after someone is killed. It stops someone who is dead from pointing
    // to someone who isn't and adjusts the killer to target the 
    // deceased's target. 
    private void graveyardPointerFixer(AssassinNode deadPersonPointer) {
        if (this.lastNode(this.graveyard) == null) {
            this.graveyard = deadPersonPointer;
            this.graveyard.next = null;
        } else {
            deadPersonPointer.next = this.graveyard;
            this.graveyard = deadPersonPointer;
        }
    }
    
    // Kills someone by removing them from the killRing, adding them to 
    // the graveyard, and passing on their target to their killer. 
    // If the game is over, an IllegalStateException is thrown.
    // If the name given is already in the graveyard, an IllegalStateException
    // is thrown.
	public void kill(String name) throws IllegalStateException,
                IllegalArgumentException {
		AssassinNode killRingPointer = this.killRing;
        if (this.isGameOver()) {
            throw new IllegalStateException
                    ("The game is over, no one else can be killed.");
        } 
        if (!this.killRingContains(name)) {
            throw new IllegalArgumentException(name + " is already dead.");
        }
        if ((killRingPointer.name).equalsIgnoreCase(name)) {
            killRingPointer.killer = this.lastNode(killRing).name;
            this.killRing = killRingPointer.next;
            this.graveyardPointerFixer(killRingPointer);
        } else {
            while (killRingPointer.next != null 
                    && !(killRingPointer.next.name).equalsIgnoreCase(name)) {
                killRingPointer = killRingPointer.next;
            }
            AssassinNode deadPersonPointer = killRingPointer.next;
            killRingPointer.next.killer = killRingPointer.name;
            killRingPointer.next = killRingPointer.next.next;
            this.graveyardPointerFixer(deadPersonPointer);
        }
	}
}