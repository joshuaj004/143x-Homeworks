// Josh Johnson
// Assignment #1: Song
// Saturday, Octobter 3rd, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This program will print out the song about an old lady and
// her strange eating habits in a way that builds upon 
// previous verses.

public class Song {
	public static void main(String[] args) {
		firstVerse();
		secondVerse();
		thirdVerse();
		fourthVerse();
		fifthVerse();
		sixthVerse();
		seventhVerse();
	}
	
	// Prints out the end lines for verses 1-6
	public static void endLines() {
		System.out.println("I don't know why she swallowed that fly,");
		System.out.println("Perhaps she'll die.");
		System.out.println();
	}	
	
	// Prints out the first verse
	public static void firstVerse()	{
		System.out.println("There was an old woman who swallowed a fly.");
		endLines();
	}
		
	// Prints out the second verse
	public static void secondVerse() {
		System.out.println("There was an old woman who swallowed a spider,");
		System.out.println("That wriggled and iggled and jiggled inside her.");
		secondVerseSwallow();
		endLines();
	}
		
	// Prints out the second verse swallow lines
	// Gets called by 3-6verseSwallow
	public static void secondVerseSwallow()	{
		System.out.println("She swallowed the spider to catch the fly,");
	}	
		
	// Prints out the third verse
	public static void thirdVerse()	{
		System.out.println("There was an old woman who swallowed a bird,");
		System.out.println("How absurd to swallow a bird.");
		thirdVerseSwallow();
		endLines();
	}
	
	// Prints out the third verse swallow lines 
	// and the previous verse swallow lines
	public static void thirdVerseSwallow() {
		System.out.println("She swallowed the bird to catch the spider,");
		secondVerseSwallow();
	}
		
	// Prints out the fourth verse
	public static void fourthVerse() {
		System.out.println("There was an old woman who swallowed a cat,");
		System.out.println("Imagine that to swallow a cat.");
		fourthVerseSwallow();
		endLines();
	}
		
	// Prints out the fourth verse swallow lines 
	// and the previous verse swallow lines
	public static void fourthVerseSwallow() {
		System.out.println("She swallowed the cat to catch the bird,");
		thirdVerseSwallow();
	}	
		
	// Prints out the fifth verse
	public static void fifthVerse()	{
		System.out.println("There was an old woman who swallowed a dog,");
		System.out.println("What a hog to swallow a dog.");
		fifthVerseSwallow();
		endLines();
	}
		
	// Prints out the fifth verse swallow lines 
	// and the previous verse swallow lines
	public static void fifthVerseSwallow() {
		System.out.println("She swallowed the dog to catch the cat,");
		fourthVerseSwallow();
	}	

	// Prints out the sixth verse		
	public static void sixthVerse()	{
		System.out.println("There was an old woman who swallowed a human,");
		System.out.println("He would've tasted better with a bit of cumin.");
		sixthVerseSwallow();
		endLines();
	}
	
	// Prints out the sixth verse swallow lines 
	// and the previous verse swallow lines
	public static void sixthVerseSwallow() {
		System.out.println("She swallowed the human to catch the dog,");
		fifthVerseSwallow();
	}	
		
	// Prints out the seventh verse
	// No corresponding swallow function or end lines are called
	public static void seventhVerse() {
		System.out.println("There was an old woman who swallowed a horse,");
		System.out.println("She died of course.");
	}
}