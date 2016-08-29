// Josh Johnson
// Assignment #2: Doodle
// Friday, Octobter 9th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This program produces a simple doodle.
// Sorry for the CAPS, but I just want to remind you that
// THIS NEEDS TO BE RUN WITH INTERNET
// It's hosted on my GoogleDrive, so if there is a problem, please send me an email!
// I know internal correctness isn't graded on this one, but I did try to explain some things
// and if anything needs to be explained, feel free to shoot me an email.

import java.awt.*;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Doodle{
	public static void main(String[] args) throws IOException{
		URL cage = new URL("https://drive.google.com/uc?export=download&id=0B8AbaU41vUckYTNQOVJfVEUtVUE");
        // "Opens a connection to this URL and returns an InputStream for reading from that connection"
		InputStream cageStream = cage.openStream();
		// Scanner trick to parse the whole file 
        String cageString = new Scanner(cageStream).useDelimiter(" ").next();   
		DrawingPanel panel = new DrawingPanel(380, 500);
		Graphics g = panel.getGraphics();
		int xCount = 0;
		int yCount = 0;
		boolean ySpacer = false;
		for (int i = 0; i < cageString.length(); i++){
            // Goes thru each individial char and if it's a number 
            // it will be passed in the colorMaker method
			char c = cageString.charAt(i);
			if ((c >= '0')){
				colorMaker(g, c, yCount, xCount); 
				xCount++;
			} else {
            // I had a weird problem where I'd have a line of blank space, so I figured that
            // yCount was skipping, so I'm treating ySpace is a boolean that flips on & off
                if (ySpacer){
                   yCount++;
                   ySpacer = false;
                }
                else{
                   ySpacer = true;
                }
            xCount = 0;
			}
		}
		g.setColor(Color.BLACK);
		g.fillRect(270,450,380,500);
		g.setColor(Color.WHITE);
		g.drawString("      \"Nic Cage\"", 280, 470);
		g.drawString("By: Josh Johnson", 275, 490);
	}	
	
	public static void stringIntaker(Graphics g, String str, int count){
		for (int i = 0; i < 500; i++){
			char c = str.charAt(i);
			colorMaker(g, c, count, i);
		}       
	}
	
	public static void colorMaker(Graphics g, char c, int xCoordinate, int yCoordinate){
		if (c == '1'){
			Color Z_885a43 = new Color(136, 90, 67);
			g.setColor(Z_885a43);			
		} else if (c == '2'){
			Color cf8d70 = new Color(207, 141, 112);
			g.setColor(cf8d70);			
		} else if (c == '3'){
			Color af7a61 = new Color(175, 122, 97);
			g.setColor(af7a61);			
		} else if (c == '4'){
			Color Z_4a342a = new Color(74, 52, 42);
			g.setColor(Z_4a342a);			
		} else if (c == '5'){
			Color fac4aa = new Color(250, 196, 170);
			g.setColor(fac4aa);			
		} else if (c == '6'){
			Color ec9c7c = new Color(236, 156, 124);
			g.setColor(ec9c7c);			
		} else if (c == '7'){
			Color Z_1f1511 = new Color(31, 21, 17);
			g.setColor(Z_1f1511);
		} else if (c == '8'){
			Color f6ae91 = new Color(246, 174, 145);
			g.setColor(f6ae91);
		} else if (c == '9'){
			Color f7eee7 = new Color(247, 238, 231);
			g.setColor(f7eee7);
		}
        g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);

	}
}