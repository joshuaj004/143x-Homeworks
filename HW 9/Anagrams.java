// Josh Johnson
// Assignment #9: Anagrams
// Monday, December 1st, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This class takes in a user-specified dictionary and given phrases and prints
// out anagrams of the phrase. The maximum number of words can be specified
// if the user wants, or they can have no maximum.
import java.util.*;

public class Anagrams {
    private Map<String, LetterInventory> processedMap;
    private List<String> dictionary;
    
    // Constructor for the Anagrams class, takes in a List<String>. Sets up
    // a map with the inputted dictionary values as LetterInventory objects
    // so that the words don't have to be converted each time.
    public Anagrams(List<String> dictionary) {       
        this.processedMap = new HashMap<String, LetterInventory>();
        this.dictionary = new ArrayList<String>(dictionary);
        for (String word : this.dictionary) {
            this.processedMap.put(word, new LetterInventory(word));
        }
    }
    
    // A method that uses recursive backtracking to print out all combinations
    // of the inputted string. Can stop at a user-inputted maximum number of 
    // words or an unlimited number of words. Will throw an
    // IllegalArgumentException if the max number is less than 0.
    public void print(String s, int max) throws IllegalArgumentException {
        if (max < 0) {
            throw new IllegalArgumentException();
        }
        List<String> sDictionary = new ArrayList(this.dictionary);
        LetterInventory word = new LetterInventory(s);
        // 'Prunes' the user-given dictionary specifically for the new phrase.
        for (int i = sDictionary.size() - 1; i >= 0; i--) {
            if ((word.subtract(this.processedMap.get(sDictionary.get(i))))
                        == null) {
                sDictionary.remove(i);
            }
        }
        // Calls the private helper method to handle the recursive backtracking
        privatePrint(word, new ArrayList<String>(), sDictionary, max);
    }
    
    // A private helper method that takes in a LetterInventory word, a 
    // List<String>, a personalized dictionary, and the user-specified maximum.
    // Uses recursive backtracking to print out all the possible anagrams for the 
    // given word.
    private void privatePrint(LetterInventory word, List<String> anagramList, 
                List<String> sDictionary, int max) {
        // Checks if the LetterInventory is empty, which means that we've 
        // reached the base case.
        if (word.isEmpty()) {
            // if the max is 0, prints out all possible anagrams
            if (max == 0) {
                System.out.println(anagramList);
            } else {
                // only prints out anagrams with the correct number of words.
                if (anagramList.size() <= max) {
                    System.out.println(anagramList);
                }
            }
        } else {
            // Iterates through the dictionary that is specifically pruned for 
            // the phrase.
            for (String tempWord : sDictionary) {
                // checks if the word can even be found in the LetterInventory 
                // before recursing.
                if ((word.subtract(this.processedMap.get(tempWord)) != null)) {
                    // Make the choice
                    anagramList.add(tempWord);
                    // Recurse with the given choice
                    privatePrint(word.subtract(this.processedMap.get(tempWord))
                            , anagramList, sDictionary, max);
                    // Un-make the choice and continue
                    anagramList.remove(tempWord);
                }
            }
        }
    }
}