// Josh Johnson
// Assignment #11: HuffmanNode
// Friday, December 11th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This class is responsible for the nodes
// used by the HuffmanCode. Represents a 
// single node of a tree.

public class HuffmanNode implements Comparable<HuffmanNode> {
    private final int frequency;
    private final char data;
    public HuffmanNode left;
    public HuffmanNode right;
    
    // A constructor that takes no arguments. Initializes with the default
    // paramaters: 0 for the frequency and '\u0000' for the data. Does not
    // set children nodes.
    public HuffmanNode() {
        this(0, '\u0000');
    }
    
    // A constructor that takes a character as an argument. Initializes with 
    // the default frequency of 0. Does not set children nodes.
    public HuffmanNode(char data) {
        this(0, data);
    }
    
    // A constructor that takes an int as an argument. Initializes with 
    // the default data value of '\u0000'. Does not set children nodes.
    public HuffmanNode(int frequency) {
        this(frequency, '\u0000');
    }
    
    // A constructor that takes in an int and a character. Does not set 
    // children nodes.
    public HuffmanNode(int frequency, char data) {
        this.frequency = frequency;
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    // Returns the node's data. Takes no arguments. Implemented to account for 
    // private data.
    public char getData() {
        return this.data;
    }
    
    // Returns the node's frequency. Takes no arguments. Implemented to account
    // for private frequency.
    public int getFrequency() {
        return this.frequency;
    }
    
    // Returns a string version of the node's data. Takes no arguments.
    public String toString() {
        return "" + this.data;
    }
    
    // Defines compareTo so that nodes may be sorted by frequency. Takes in 
    // another node to compare the node to. Returns an int.
    public int compareTo(HuffmanNode other) {
        return ((Integer)this.frequency).compareTo(other.frequency);
    }
}