// Josh Johnson
// Assignment #3: Bagels
// Friday, Octobter 15th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This program will initialize a game of bagels and play as many times
// as the user wants and will print out the statistics 
// of all the games when the final game is completed.

import java.util.Scanner;
import java.util.*;

public class BagelsWithSolver{
	public static void main(String[] args){
		// Using the assumption that no game will have more than 10k guesses,
		// I set the best game at 10k guess so any game that solves it before
		// will be the best game.
		int gameGuesses; int numOfGames = 0; int totalGuesses = 0, bestGame = 10000;
		boolean playAgain = true;
		String combinedFermiPica;
		Scanner userInput = new Scanner(System.in);
		intro();
		// Runs one session of the game and records statistics
		while (playAgain){
			gameGuesses = bagelsGame(userInput);
			totalGuesses += gameGuesses;
			playAgain = newGame(userInput);
			System.out.println();
			numOfGames++;
			if (gameGuesses < bestGame) {
				bestGame = gameGuesses;
			}
		}
		statReporter(numOfGames, totalGuesses, bestGame);
	}
    
	public static String solver(int digits){
        int[] numList = {1,2,3,4,5,6,7,8,9};
		int h = 0, solving = 1, count = 1;
		String guess = "";
		// number of MAX possibilites = 9 ([1-9]) * digits
		for (int i = 0; i < 9 * digits; i++){
			String tempGuess = guess;
            tempGuess += numList[h];
			// This loop adds the 0's to the tempGuess
			for (int j = 0; j < (digits - solving); j++){
				tempGuess += "*";
			}
            // tempGuess = E.g. 300
            //String result = badGuesser(tempGuess, numList);
            if (result.contains("fermi") || result.contains("pica ")){
                System.out.println("result " + result);
                if (result.length() == ("fermi ".length() * solving)){                        
                    guess += numList[h];
                    i += (9 - 1 - h);
                    h = -1;
                    solving++;
                }
                if (result.length() == "fermi ".length() * digits ||
                        result.contains("You got it")){
                    System.out.println("Tries: " + count);
                    return guess;
                }
            }else if (!result.contains("pica")){                    
                // Removes any unused numbers (i.e. no pica/fermi returned)
                int[] tempArray = new int[numList.length - 1];
                for (int k = 0; k < numList.length; k++){
                    
                    if (!(numList[k] == numList[h])){
                        if (h > k ){
                            tempArray[k] = numList[k];
                        }else{
                            tempArray[k-1] = numList[k];
                        }                            
                    }
                }
                // h-- offsets the removal of an element
                h--;
                numList = tempArray;
            }   
			h++;
			count++;
		}
		return guess;
	}
   
	// Plays one complete game of bagels and reports number 
	// of guesses for the statistics, accepts a scanner as 
	// a parameter to accept number of digits and user guesses
	public static int bagelsGame(Scanner userInput){
		boolean winCondition = false;
		int digits; int guesses = 0;
		String userGuessString, masterGuessString, combinedFermiPica;
		String[] masterGuessArray;
		digits = digitsMethod(userInput);
		masterGuessArray = masterGuess(digits);
		while (!winCondition) {
			guesses++;
			// copies the masterGuessArray so that numbers can be
			// "crossed off" and then is recreated each loop
			String[] checkGuessArray = masterGuessArray.clone();
			// stores any fermi/pica/bagels returned in a string
			combinedFermiPica = guessingPortion(userInput, checkGuessArray, digits);
			// checks if the player won the game
			winCondition = winner(combinedFermiPica, digits);
			if (!winCondition){
			System.out.println(combinedFermiPica);
			} else {
				if (guesses == 1){
				   System.out.println("You got it right in 1 guess");
				} else {
				   System.out.println("You got it right in " + guesses + " guesses");
				}
			}
		}
		return guesses;
	}
	
    // Prints out the beginning spiel, only appears once per run 
	public static void intro(){
		System.out.println("Welcome to CSE 143x Bagels!");
		System.out.println("I'll think up a number for you to guess.");
		System.out.println("Each digit will be between 1 and 9.");
		System.out.println("Try to guess my number, and I'll say \"fermi\"");
		System.out.println("for each digit you get right and in the right");
		System.out.println("place, and \"pica\" for each digit you get right");
		System.out.println("that is in the wrong place.");
		System.out.println();
	}
	
	// Asks the user how many digits to use and returns that number
	// Takes in the scanner to take in the number of digits
	public static int digitsMethod(Scanner userInput){
		int digits;
		System.out.print("How many digits this time? ");
		digits = userInput.nextInt();
		return digits;
	}
   	
	// Generates the initial guess using the randomGuesser method and, converts it 
	// to an Array using the guessToArray method and returns that Array
	// Takes in the digits for the length information
	public static String[] masterGuess(int digits){
		String masterGuessString;
		masterGuessString = randomGuesser(digits);
		return guessToArray(masterGuessString);
	}   
   	
	// Converts a string that was inputted as a parameter
	// to a string array and returns that array
	public static String[] guessToArray(String str){
		String[] tempArray = str.split("");
		// This is because in Java 7 (possibly Java 6), using the split creates an empty element at
		// the beginning, but does NOT do that in Java 8, so this removes the 
		// empty element if it exists
		if (tempArray[0].equals("")){
			String[] guessArray = new String[tempArray.length - 1];
			for (int i = 0; i < tempArray.length - 1; i++){
				guessArray[i] = tempArray[i+1];
			}
			tempArray = guessArray;
		} 
		return tempArray;
	}
   	
	// Generates a pseudorandom number depending on how many digits
	// the user wanted to play with, taken in as a parameter. 
	// Returns a guess in the form of a string.
	public static String randomGuesser(int digits){
		// Seed 42 as detailed in the spec sheet
		Random rand = new Random(42);
		String masterGuess = "";
		for (int i = 0; i < digits; i++){
			int randomNum = rand.nextInt(9) + 1; 
			masterGuess += (randomNum + "");
		}
		return masterGuess;
	}
      
	// Takes in a scanner and a copy of the masterGuessArray. Asks the user for
	// their guess as a string and calls the userGuess method to convert it to an 
	// Array. Returns the combination of the fermiAndPica method which will return
	// the number of fermis, picas, or bagel as a string.
	public static String guessingPortion(Scanner userInput, String[] checkGuessArray, int digits){
		String combinedFermiPica;
		String[] userGuessArray;
		userGuessArray = solver(digits);
		return fermiAndPica(userGuessArray, checkGuessArray);
	}
   	
   // Accepts the parameters combinedFermiPica and digits to check if the user
   // has won the game. Returns a boolean value.
	public static boolean winner(String combinedFermiPica, int digits){
		return (combinedFermiPica.length() == ("fermi ".length() * digits)
			&& !combinedFermiPica.equals("bagels"));
	}
   
	// Accepts the scanner as a parameter and returns a boolean
	// value depending if the user wants to play again
	public static boolean newGame(Scanner userInput){
		System.out.print("Do you want to play again? ");
		String newGameString = userInput.next();
		char c = newGameString.charAt(0);
		return (c == 'Y' || c == 'y');
	}
	
    // Accepts the scanner as a parameter and asks the user what their guess is.
    // Converts the inital string guess to a stringArray and returns that array
	public static String[] userGuess(Scanner userInput){
		String userGuessString;
		System.out.print("Your guess? ");
		userGuessString = userInput.next();
		return guessToArray(userGuessString);
	}
   
	// Accepts the userGuessArray and the checkGuess array as parameters. Calls
	// the methods fermi and pica to see how many of each there are. If both of those
	// return empty strings, "bagels" is returned, else the fermis & picas are returned.
	public static String fermiAndPica(String[] userGuessArray, String[] checkGuessArray){
		String fermiString, picaString;
		fermiString = fermi(userGuessArray, checkGuessArray);
		picaString = pica(userGuessArray, checkGuessArray);
		if (fermiString.equals("") && picaString.equals("")){
			return "bagels";
		}
		return (fermiString + picaString);
	}

	// Accepts the userGuessArray and checkGuessArray and checks if there are any fermis.
	// Modifies check + userGuessArrays and returns a string containing the result.
	public static String fermi(String[] userGuessArray, String[] checkGuessArray){
		int arraysLength = userGuessArray.length;
		String fermiString = "";
		for (int i = 0; i < arraysLength; i++){
			if (userGuessArray[i].equals(checkGuessArray[i])){		
                checkGuessArray[i] = "0";
            userGuessArray[i] = "-1";
				fermiString += "fermi ";
			}
		}
		return fermiString;
	}
   
    // Accepts the userGuessArray and checkGuessArray and check if there are any picas.
    // Modifies check + userGuessArrays and returns a string containing the result.
	public static String pica(String[] userGuessArray, String[] checkGuessArray){
		int arraysLength = userGuessArray.length;
		String picaString = "";
		for (int i = 0; i < arraysLength; i++){
			for (int j = 0; j < arraysLength; j++){
				if (userGuessArray[i].equals(checkGuessArray[j])){
                   	userGuessArray[i] = "-1";
                    checkGuessArray[j] = "0";
					picaString += "pica ";
				}
			}
		}
		return picaString;
	}
	
    // Takes in the parameters, numOfGames, numOfGuesses, and bestGame. 
    // Prints out some stats about the various games.
	public static void statReporter(int numOfGames, int numOfGuesses, int bestGame){
		double guessesPerGame = (double)numOfGuesses/numOfGames;
		guessesPerGame = (int)(guessesPerGame * 10 + 0.5)/10.0;
		System.out.println("Overall results:");
		System.out.println("    total games   = " + numOfGames);
		System.out.println("    total guesses = " + numOfGuesses);
		System.out.println("    guesses/game  = " + guessesPerGame);
		System.out.println("    best game     = " + bestGame);
	}
}