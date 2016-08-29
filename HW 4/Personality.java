// Josh Johnson
// Assignment #4: Personality
// Friday, Octobter 23rd, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This program will receive an input file of names and 
// results from the Keirsey Temperament test. It outputs
// the name, percentage of responses that were "B" and
// the personality type to a file called output.txt 

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Personality {
	public static final int FOUR = 4;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("personality.txt"));
        PrintStream output = new PrintStream("output.txt"); 
        while (input.hasNextLine()) {
			int[] ESTJarray = new int[FOUR];
			int[] INFParray = new int[FOUR];
			String name = input.nextLine();
			String response = input.nextLine();
			dataAnalyzer(response, ESTJarray, INFParray);
			int[] bPercentArray = BPercentages(ESTJarray, INFParray);
			output.println(name + ": " + Arrays.toString(bPercentArray) 
					+ " = " + dimensionCalculator(bPercentArray));
		}
	}
	
    // Takes in the String response and the int[] ESTJarray and 
    // the INFParray. Iterates through response and counts the  
    // number of answers and adds them to the corresponding  
    // position in the corresponding arrays.
	public static void dataAnalyzer(String response, int[] ESTJarray, 
				int[] INFParray) {
		for (int i = 0; i < response.length(); i++) {
			char c = Character.toUpperCase(response.charAt(i));
			if (!(c == '-')) {
                // Get's the 'place' of the letter depending on the question,
                // where the place is the E/I, S/N, T/F, or J/P.
				int place = placeCalc(i);				
				if (c == 'A') {
					ESTJarray[place]++;
				} else {
					INFParray[place]++;
				}
			}
		}
	}
	
    // Takes in an int num and returns an int. Using the modulus operator,
    // it calculates the 'place' that should be returned for the question.
	public static int placeCalc(int num) {
		int place;
		if (num % 7 < 1) {
			place = 0;
		} else if (num % 7 < 3) {
			place = 1;
		} else if (num % 7 < 5) {
			place = 2;
		} else {
			place = 3;
		}
		return place;
	}
	
    // Takes in the int[] ESTJarray and the INFParray. Calculates how many 
    // total answers for each question in each array and then calculates
    // the percentage of 'B' answers and returns an int[] with the percentage.
	public static int[] BPercentages(int[] ESTJarray, int[] INFParray) {
		int[] bPercentArray = new int[FOUR];
		for (int i = 0; i < bPercentArray.length; i++) {
			int total = ESTJarray[i] + INFParray[i];
			bPercentArray[i] = (int) Math.round(INFParray[i] * 100.0 / total);
		}
		return bPercentArray;
	}
	
    // Takes in the int[] bPercentArray and calculates the 'dimension.'
    // Returns a string containing E/I, S/N, T/F, J/P, or X.
	public static String dimensionCalculator(int[] bPercentArray) {
		String dimension = "";
		String ESTJINFPString = "EISNTFJP";
		for (int i = 0; i < FOUR; i++) {
			if (bPercentArray[i] == 50) {
				dimension += "X";
			} else if (bPercentArray[i] < 50) {
				dimension += (ESTJINFPString.charAt(2 * i));
			} else {
				dimension += (ESTJINFPString.charAt(2 * i + 1));
			}
		}
		return dimension;
	}
}