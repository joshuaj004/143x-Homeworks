// Josh Johnson
// Assignment #7: Grammar
// Friday, November 13th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This class generates expressions using user-chosen .txt files. 
// It uses BNF to produce these expressions, with terminals
// non terminals. Can handle any BNF compatible .txt file
// to form as many expressions as desired.

import java.util.*;

public class Grammar {
	private Map<String, List<String>> grammarRules = 
            new TreeMap<String, List<String>>();
	private Random r = new Random();
    
    // Constructor that sets up a TreeMap where the keys are Strings from the
    // inputted String list and the Values are StringLists. Throws an 
    // IllegalArgumentException if the Rules are empty or null.
    //  Handles whitespace by trimming both the Keys and values. 
	public Grammar(List<String> rules) throws IllegalArgumentException {
		if (rules == null || rules.isEmpty()) {
			throw new IllegalArgumentException();
		}
		for (String line : rules) {
			String[] pieces = line.split("::=");
			String[] subpieces = pieces[1].split("\\|");
			for (int i = 0; i < subpieces.length; i++) {
				subpieces[i] = subpieces[i].trim();
			}
            List<String> listSubpieces = Arrays.asList(subpieces);
			if (!this.grammarRules.containsKey(pieces[0])) {
				this.grammarRules.put(pieces[0].trim(), listSubpieces);
			} else {
                List<String> newSymbols = new ArrayList<String>();
                newSymbols.addAll(this.grammarRules.get(pieces[0]));
                newSymbols.addAll(listSubpieces);
                this.grammarRules.put(pieces[0].trim(), newSymbols);
            }
		}	
	}
	
    // Returns true if the given string is non-terminal and false if it 
    // isn't. Should not be called on a null string.
	public boolean isNonTerminal(String symbol) {
		return this.grammarRules.containsKey(symbol);
	}
	
    // Returns the string version of the keys in the Grammar. Shouldn't 
    // be called on a null string.
	public String toString() {
        return this.grammarRules.keySet() + "";
	}
	
    // A public method that takes in an integer and a string. If the number
    // is less than 0, throws an IllegalArgumentException. If the string is
    // null or terminal, throws an IllegalArgumentException. The (int) number 
    // is used to generate that amount of nonterminals in a recursive manner.
    // Returns a String List with all the nonterminals generated.
	public List<String> getRandom(int number, String nonterminal) 
                throws IllegalArgumentException {
		if (number < 0) {
            throw new IllegalArgumentException();
        }
        if (nonterminal == null || !isNonTerminal(nonterminal)) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> outputList = new ArrayList<String>();
        for (int i = 0; i < number; i++) {
            String expression = privateGetRandom(nonterminal);
            // Gets rid of the space at the end (fence-post problem)
            outputList.add(expression.substring(0, expression.length()-1));
        }
        return outputList;
	}
	
    // A private method that handles the actual recursion and 'sentence 
    // building' of getRandom. Returns a String to getRandom and 
    // privateGetRandom (itself).
    private String privateGetRandom(String nonterminal) {  
        // This checks for whitespace/null and returns an empty string.
        if (nonterminal == null || nonterminal.isEmpty()) {
            return "";
        }
        // Gets the values associated with the given key/nonterminal
        List<String> values = this.grammarRules.get(nonterminal);
        // Picks a random expression from the values that were stored in values
        String expression = values.get(this.r.nextInt(values.size()));
        // Splits the expressions by white space
        String[] pieces = (expression).split("\\s+");
        // Checks for single expressions e.g. "X", "The", "42" and returns 
        // the expression with a single character of whitespace for 
        // visual aesthetics
        if (pieces.length == 1 && !(isNonTerminal(pieces[0]))) {
            return pieces[0] + " ";
        // This checks for a single, terminal expression and passes 
        // it in this method (recursion!)
        } else if (pieces.length == 1) {
            return privateGetRandom(pieces[0]);
        // This deals with those arguments that have multiple expressions.
        } else {
            String returnString = "";
            for (int i = 0; i < pieces.length; i++) {
                // This statement takes care of those expressions that 
                // 'wrap' around something. E.G. ["(", "E", ")"]
                if (!isNonTerminal(pieces[i])) {
                    returnString += pieces[i] + " ";
                // This statement allows multiple expressions to be 
                // processed one by one.
                } else {
                    returnString += privateGetRandom(pieces[i]);
                }  
            }
            return returnString;
        }
    }
}