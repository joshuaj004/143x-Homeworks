// Josh Johnson
// Assignment #8: HangmanManager
// Friday, November 19th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
//  This class handles the back-end for an evil hangman game.
//  Screens a dictionary for words of the user given length.
//  Handles guessing and avoids picking a word unless it 
//  absolutely has to.

import java.util.*;

public class HangmanManager {
    private int length;
    private int maxGuesses;
	private String currentPattern;
    private Set<String> dictionary;
    private Set<Character> letterGuesses;
	private Map<String, List<String>> possibilities;
    
    // Constructor for the HangmanManager class, takes in a List<string> 
    // dictionary, an int for the word length and another int for the maximum
    // number of guesses. Throws IllegalArgumentExceptions if the length is
    // less than 1 or if the max number of guesses is less than 0.
    public HangmanManager(List<String> dictionary, int length, int max) 
                throws IllegalArgumentException {
        if (length < 1 || max < 0) {
            throw new IllegalArgumentException();
        }
        this.length = length;
        this.maxGuesses = max;
        this.dictionary = new TreeSet<String>();
		for (String word : dictionary) {
			if (word.length() == length) {
				this.dictionary.add(word);
			}
		}
        this.letterGuesses = new TreeSet<Character>();
        this.currentPattern = "";
		for (int i = 0; i < length; i++) {
			this.currentPattern += "-";
		}
    }
    
    // Returns a Set<String> that contains the words that are being considered.
    public Set<String> words() { 
		return this.dictionary;
    }
    
    // Returns an the number of guesses left
    public int guessesLeft() {
        return this.maxGuesses;
    }
    
    // Returns a Set<Character> containing the characters that have been guessed.
    public Set<Character> guesses() {
        return this.letterGuesses;
    }
    
    // Returns a string with the current pattern. If the dictionary is empty
    // it throws an IllegalStateException.
    public String pattern() throws IllegalStateException {
        if (this.dictionary.isEmpty()) {
            throw new IllegalStateException();
        }
		return this.currentPattern;
    }
    
    // Throws an IllegalStateException if the guesses left are less than 1 or
    // if the list of words is empty. Throws an IllegalArgumentException if the
    // dictionary isn't empty and the guess has already been guessed. This 
    // method figures out the new list of words and which pattern to use.
    // Takes in a guess and returns the number of guesses left as an int.
    public int record(char guess) throws IllegalStateException, 
                IllegalArgumentException {
        if (this.dictionary.isEmpty() || this.maxGuesses < 1) {
            throw new IllegalStateException();
        }
        if (!this.dictionary.isEmpty() && this.letterGuesses.contains(guess)) {
            throw new IllegalArgumentException();
        }
        // Adds the guess to the guess set
		this.letterGuesses.add(guess);
        // Updates the dictionary set
		maxPatternGetter(guess);
		int numberOfOccurences = charInPattern(guess);
		if (numberOfOccurences < 1) {
			this.maxGuesses--;
		}
		this.dictionary = new TreeSet<String>(this.possibilities.get
                (this.currentPattern));
		return numberOfOccurences;
    }
	
    // A private method that takes in a guess and returns the number of 
    // times the guess appears in the current pattern.
	private int charInPattern(char guess) {
		int counter = 0;
		for (int i = 0; i < this.currentPattern.length(); i++) {      
			if (this.currentPattern.charAt(i) == guess) {
				counter++;
			}
		}
		return counter;
	}
	
    // A private method that takes in a guess. Assigns the patterns of words
    // to a map and the actual words as the values. 
	private void patternBuilder(char guess) {
		this.possibilities = new TreeMap<String, List<String>>();
		for (String word : this.dictionary) {
			String stringPattern = patternConstructor(guess, word);
			List<String> valueList = new ArrayList<String>();
			valueList.add(word);
			if (!this.possibilities.containsKey(stringPattern)) {
				this.possibilities.put(stringPattern, valueList);
			} else {
				this.possibilities.get(stringPattern).add(word);
			}
		}
	}

    // A private method that takes in a guess. Assigns the pattern with the 
    // largest number of words as the pattern. 
	private void maxPatternGetter(char guess) {
		int maxPossibilities = 0;
		String tempPattern = "";
        patternBuilder(guess);
		for (String possibility: this.possibilities.keySet()) {
			int currentPossibilities = 
                    (this.possibilities.get(possibility)).size();
			if (currentPossibilities > maxPossibilities) {
				maxPossibilities = currentPossibilities;
				tempPattern = possibility;
			}
		}
		this.currentPattern = tempPattern;
	}	
	
    // A private method that takes in a char guess and a String word. Creates 
    // a pattern using the parameters and returns the pattern as a String.
	private String patternConstructor(char guess, String word) {
		String tempPattern = "";
		for (int i = 0; i < word.length(); i++) {	
			if (this.currentPattern.charAt(i) == '-') {
				if (word.charAt(i) == guess) {
					tempPattern += guess + "";
				} else {
					tempPattern += "-";
				}
			} else {
				tempPattern += this.currentPattern.charAt(i);
			}
		}
		return tempPattern;
	}
}