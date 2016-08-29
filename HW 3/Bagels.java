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

public class Bagels{
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
   
    // Plays one complete game of bagels and reports number 
    // of guesses for the statistics, accepts a scanner as 
    // a parameter to accept number of digits and user guesses
    public static int bagelsGame(Scanner userInput){
        boolean winCondition = false;
        int digits; int numOfGuesses = 0;
        String userGuessString, masterGuessString, combinedFermiPica;
        String[] masterGuessArray;
        digits = digitsMethod(userInput);
        masterGuessArray = masterGuess(digits);
        while (!winCondition) {
            numOfGuesses++;
            // copies the masterGuessArray so that numbers can be
            // "crossed off" and then is recreated each loop
            String[] checkGuessArray = masterGuessArray.clone();
            // stores any fermi/pica/bagels returned in a string
            combinedFermiPica = guessingPortion(userInput, checkGuessArray);
            // checks if the player won the game
            winCondition = winner(combinedFermiPica, digits);
            if (!winCondition){
            System.out.println(combinedFermiPica);
            } else {
                if (numOfGuesses == 1){
                   System.out.println("You got it right in 1 guess");
                } else {
                   System.out.println("You got it right in " + numOfGuesses + " guesses");
                }
            }
        }
        return numOfGuesses;
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
        System.out.print("How many digits this time? ");
        return userInput.nextInt();
    }
    
    // Generates the initial guess using the randomGuesser method and, converts it 
    // to an Array  and returns that Array. Takes in the digits for the length information
    public static String[] masterGuess(int digits){
        String masterGuessString = randomGuesser(digits);
        return masterGuessString.split(" ");
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
            masterGuess += (randomNum + " ");
        }
        return masterGuess;
    }
      
    // Takes in a scanner and a copy of the masterGuessArray. Asks the user for
    // their guess as a string and calls the userGuess method to convert it to an 
    // Array. Returns the combination of the fermiAndPica method which will return
    // the number of fermis, picas, or bagel as a string.
    public static String guessingPortion(Scanner userInput, String[] checkGuessArray){
        String[] userGuessArray = userGuess(userInput);
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
        System.out.print("Your guess? ");
        String userGuessString = userInput.next();
        String tempString = "";
        for (int i = 0; i < userGuessString.length(); i++){
            tempString += userGuessString.charAt(i) + " ";
        }
        return tempString.split(" ");
    }
   
    // Accepts the userGuessArray and the checkGuess array as parameters. Calls
    // the method fermiPicacheck to see how many of each there are. If both of those
    // return empty strings, "bagels" is returned, else the fermis & picas are returned.
    public static String fermiAndPica(String[] userGuessArray, String[] checkGuessArray){
        String fermiString = fermiPicaCheck(userGuessArray, checkGuessArray, "fermi");
        String picaString = fermiPicaCheck(userGuessArray, checkGuessArray, "pica");
        if (fermiString.equals("") && picaString.equals("")){
            return "bagels";
        }
        return (fermiString + picaString);
    }

    // Accepts the userGuessArray, checkGuessArray and a string to check. if there are any fermis/picas.
    // Modifies check + userGuessArrays and returns a string containing the result.
    public static String fermiPicaCheck(String[] userGuessArray, String[] checkGuessArray,
                String check){
        int arraysLength = userGuessArray.length;
        String checkString = "";
        for (int i = 0; i < arraysLength; i++){
            if (check.equals("fermi")){
                if (userGuessArray[i].equals(checkGuessArray[i])){
                    checkGuessArray[i] = "0";
                    userGuessArray[i] = "-1";
                    checkString += check + " ";
                }
            }else { 
                for (int j = 0; j < arraysLength; j++){
                    if (userGuessArray[i].equals(checkGuessArray[j])){
                        checkGuessArray[j] = "0";
                        userGuessArray[i] = "-1";                       
                        checkString += check + " ";
                    }
                }
            }
        }
        return checkString;
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