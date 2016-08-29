import java.util.Scanner;
import java.util.*;

public class BagelSolver{
	public static void main(String[] args){
        String line;
        line = waitingForInput("How many digits this time? ");
        int digits = 3;//12345678
		System.out.println(digits);
        String fermiString = "";
        /*while (!(fermiString.length() == ("fermi ".length() * digits))
				&& fermiString.equals("bagels")){
            line = waitingForInput("Your guess? ");
			// Code for solver
			// Take in your guess
			// output a series of numbers
        }*/
        line = waitingForInput("Your guess? ");
		String guess = solver(digits);
		//System.out.println(guess);
        line = waitingForInput("Do you want to play again? ");
        System.out.println("N");
		
	}


    public static String waitingForInput(String bagelInput){
		Scanner input = new Scanner(System.in);
		String line;
		line = input.nextLine();
		while (!line.equals(bagelInput)){
    		line = input.nextLine();
        }
		return line;
    }
	
	public static String solver(int digits){
		//System.out.println("Line 34");
        //int[] numList = {1,2,3,4,5,6,7,8,9};
        int[] numList = {9,4,1,8,6,3,7,2,5};
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
            String result = badGuesser(tempGuess, numList);
            if (result.contains("fermi") || result.contains("pica ")
                  || result.contains("You got it")){
                //System.out.println("result " + result);
                if (result.length() == ("fermi ".length() * solving)){                        
                    guess += numList[h];
                    i += (9 - 1 - h);
                    h = -1;
                    solving++;
                }
                if (result.length() == "fermi ".length() * digits ||
                        result.contains("You got it")){
                    //System.out.println("Tries: " + count);
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
	
	public static String badGuesser(String guess, int[] numList){
        Scanner input = new Scanner(System.in);
        System.out.println(guess);
        return input.nextLine();
	}
}