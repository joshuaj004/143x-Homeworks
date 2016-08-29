// Josh Johnson
// Assignment #3: BagelSolver
// Sunday, Octobter 18th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This program will initialize a game of bagels and play once
// until it solves the game. Needs to take the Bagels.java output
// as input and vice-versa for it to work

import java.util.Scanner;
import java.util.*;

public class BagelsSolver{
	public static final int DIGITS = 3;
	public static void main(String[] args){
        String line;
        line = waitingForInput("How many digits this time?");
		System.out.println(DIGITS);
        String fermiString = "";
        line = waitingForInput("Your guess?");
		String guess = solver(DIGITS);
        line = waitingForInput("Do you want to play again?");
        System.out.println("N");
	}

    public static String waitingForInput(String bagelInput){
		Scanner input = new Scanner(System.in);
		String line;
		line = input.nextLine();
		while (!line.contains(bagelInput)){
    		line = input.nextLine();
        }
		return line;
    }
	
	public static String solver(int DIGITS){
		// I'm not assuming anything about randomness, I'm simply
		// optimizing it for one specific case...
		// It also works fine for literally any random seed 
		int[] numList = {9,4,1,8,6,3,7,2,5};
		int h = 0, solving = 1, count = 1;
		String guess = "";
		// number of MAX possibilites = 9 ([1-9]) * DIGITS
		for (int i = 0; i < 9 * DIGITS; i++){
			String tempGuess = guess;
            tempGuess += numList[h];
			// This loop adds the 0's to the tempGuess
			for (int j = 0; j < (DIGITS - solving); j++){
				tempGuess += "*";
			}
            // tempGuess = E.g. 300
            String result = bagelGuesser(tempGuess, numList);
            if (result.contains("fermi") || result.contains("pica ")
                  || result.contains("You got it")){
                if (result.length() == ("fermi ".length() * solving)){                        
                    guess += numList[h];
                    i += (9 - 1 - h);
                    h = -1;
                    solving++;
                } else if (result.length() == ("fermi ".length() * (solving - 1)) &&
                        !result.contains("pica")){
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
                    h--;
                    numList = tempArray;
                }
                if (result.length() == "fermi ".length() * DIGITS ||
                        result.contains("You got it")){
                    return "";//guess += numList[h];
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
	
	public static String bagelGuesser(String guess, int[] numList){
        Scanner input = new Scanner(System.in);
        System.out.println(guess);
        return input.nextLine();
	}
}