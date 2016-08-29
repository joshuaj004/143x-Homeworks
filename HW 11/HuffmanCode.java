// Josh Johnson
// Assignment #11: HuffmanCode
// Friday, December 11th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This class takes in a either an int array or a scanner
// and creates a Huffman Tree, and either makes a Huffman code
// compresses a file, decompresses a file, or compresses then
// decompresses a file. All with the ability to output to 
// outside files.
import java.io.*;
import java.util.*;

public class HuffmanCode {
    private HuffmanNode front;
    
    // A constructor that takes in an int[] and creates HuffmanNodes
    // and places the nodes in a priority queue according to their
    // frequency.
    public HuffmanCode(int[] frequencies) {
        Queue<HuffmanNode> nodeFrequencies = new PriorityQueue<HuffmanNode>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                nodeFrequencies.add(new HuffmanNode(frequencies[i], (char) i));
            }
        }
        nodeFrequencies = ArrayHuffmanCodeCreator(nodeFrequencies);
        this.front = nodeFrequencies.peek();
    }
    
    // A constructor that takes in a scanner. Assumes it's reading in a 
    // previously constructed, legal code file. Also assumes the Scanner
    // is not null.
    public HuffmanCode(Scanner input) {
        this.front = new HuffmanNode();
        while (input.hasNextLine()) {
            int character = Integer.parseInt(input.nextLine());
            String location = input.nextLine();
            ScannerHuffmanCodeCreator(this.front, location, (char) character);
        }
    }       
    
    // A private helper method that is called when the Scanner constructor is 
    // used. Creates a Huffman tree. Takes in a HuffmanNodenode, a string and
    // a character.
    private void ScannerHuffmanCodeCreator(HuffmanNode node, String s, char c) {
        if (s.length() == 1) {
            if (s.charAt(0) == '0') {
                node.left = new HuffmanNode(c);
            } else {
                node.right = new HuffmanNode(c);
            }
        } else {
            if (s.charAt(0) == '0') {
                if (node.left == null && node.right == null) {
                    node.left = new HuffmanNode();
                }
                ScannerHuffmanCodeCreator(node.left, s.substring(1), c);
            } else {
                if (node.right == null && node.right == null) {
                    node.right = new HuffmanNode();
                }
                ScannerHuffmanCodeCreator(node.right, s.substring(1), c);
            }
        }
    }
    
    // A private helper method that is called when the int[] constructor is 
    // used. Creates a Huffman tree. Takes in a priorityQueue and returns a 
    // priorityQueue. 
    private Queue<HuffmanNode> ArrayHuffmanCodeCreator(Queue<HuffmanNode> frequencies) {
        while (frequencies.size() > 1) {
            HuffmanNode first = frequencies.poll();
            HuffmanNode second = frequencies.poll();
            HuffmanNode tempNode = new 
                    HuffmanNode(first.getFrequency() + second.getFrequency());
            tempNode.left = first;
            tempNode.right = second;
            frequencies.add(tempNode);
        }
        return frequencies;
    }
    
    // A private helper method that takes in a HuffmanNode, a string and a 
    // PrintStream.
    private void HuffmanPrinter(HuffmanNode node, String s, PrintStream output) {
        if (node.left == null) {
            output.println((byte) node.getData());
            output.println(s);
        } else {
            HuffmanPrinter(node.left, s + 0, output);
            HuffmanPrinter(node.right, s + 1, output);
        }
    }
    
    // A method that takes in a PrintStream and saves the HuffmanCode to a file.
    public void save(PrintStream output) {
        HuffmanPrinter(this.front, "", output);
    }
    
    // A method that takes in a BitInputStream and a PrintStream. Reads bits
    // from the BitInputStream and translates them using the HuffmanTree and
    // prints those characters to the PrintStream.
    public void translate(BitInputStream input, PrintStream output) {
        HuffmanNode node = this.front;
        while  (input.hasNextBit()) {
            while (node.left != null && node.right != null) {
                if (input.nextBit() == 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            output.print(node.getData());
            node = this.front;
        }
    }
}