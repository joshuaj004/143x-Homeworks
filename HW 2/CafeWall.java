// Josh Johnson
// Assignment #2: Cafe Wall
// Wednesday, Octobter 7th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This program will produce the Cafe Wall Illusion
// This consists of two rows and four grids of various 
// size and width and height.

import java.awt.*;

public class CafeWall{
	public static void main(String[] args) {
 		DrawingPanel panel = new DrawingPanel(650, 400);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.GRAY);
		// Creates the two independent rows
		rowCreator(g, 20, 4, 0, 0);
		rowCreator(g, 30, 5, 50, 70);
		// Creates the various Grids
		gridCreator(g, 25, 4, 8, 0, 10, 150); 
		gridCreator(g, 25, 3, 6, 10, 250, 200);
		gridCreator(g, 20, 5, 10, 10, 425, 180);
		gridCreator(g, 35, 2, 4, 35, 400, 20); 
	}
   
	// Draws a pair of boxes consisting of a black box with an 'X'
	// through it and a white box directly next to the black box. Takes
	// in the size of the boxes and the (x, y) coordinates for the first box.
	public static void pairCreator(Graphics g, int size, 
            int xPosition, int yPosition) {
		// Draws the black box
		g.setColor(Color.BLACK);
		g.fillRect(xPosition, yPosition, size, size);
		// Draws the white box 	
		g.setColor(Color.WHITE);
		g.fillRect(xPosition + size, yPosition, size, size);
		// Draws the X on the black box by using two lines that 
		// intersect at the center of the black box
		g.setColor(Color.BLUE);
		g.drawLine(xPosition, yPosition, xPosition + size, yPosition + size);
		g.drawLine(xPosition, yPosition + size, xPosition + size, yPosition); 
	}

	// Draws a row of black and white boxes using the pairCreator method.
	// Takes in the size of the boxes, how many pairs, and the (x, y)
	// coordinates of the first box.
	public static void rowCreator(Graphics g, int size, int width,
				int xPosition, int yPosition) {
		for (int i = 0; i < width; i++) {
			pairCreator(g, size, xPosition, yPosition);
			xPosition += size * 2;
		}
	}
   
	// Draws a grid of squares using the rowCreator method.
	// Parameters allow the size, number of boxes wide and high with 
	// the possibility for an offset, along with the (x, y) coordinates
	// of the first box.
	public static void gridCreator(Graphics g, int size, int width, int height,
				int secondRowOffset, int xPosition, int yPosition) {
		int MORTAR = 2;
		for (int i = 0; i < (height / 2); i++) {
			rowCreator(g, size, width, xPosition, yPosition);
			rowCreator(g, size, width, (xPosition + secondRowOffset), 
					(yPosition + size + MORTAR));
			yPosition += 2 * (size + MORTAR);
		}
	}   
}

