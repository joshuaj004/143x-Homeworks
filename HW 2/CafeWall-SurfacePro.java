// Josh Johnson
// Assignment #2: Song
// Wednesday, Octobter 7th, 2015
// CSE 143x, Section XD
// TA: Rasika Bhalerao
//
// This program will produce the Cafe Wall Illusion
// This consists of two rows and four grids of various 
// size and width and height.

import java.awt.*;

public class CafeWall{
	public static void main(String[] args){
 		DrawingPanel panel = new DrawingPanel(650, 400);
		Graphics g = panel.getGraphics();
      g.setColor(Color.GRAY);
		g.fillRect(0, 0, 650, 490);
      // Rows
      rowCreator(8, g, 20, 0, 0);
      rowCreator(10, g, 30, 50, 70); 
      // Grids
      gridCreator(8, 8, g, 25, 10, 150, 0);   
      gridCreator(6, 6, g, 25, 250, 200, 10);   
      gridCreator(10, 10, g, 20, 425, 180, 10);    
      gridCreator(4, 4, g, 35, 400, 20, 35);      
	}
   
   public static void pairCreator(Graphics g, int size, 
            int xPosition, int yPosition){
      g.setColor(Color.BLACK);
      g.fillRect(xPosition, yPosition, size, size);
      g.setColor(Color.WHITE);
      g.fillRect(xPosition + size, yPosition, size, size);
      g.setColor(Color.BLUE);
      g.drawLine(xPosition+size, yPosition+size, xPosition, yPosition);// \
      g.drawLine(xPosition+size, yPosition, xPosition, yPosition+size);// /      
         }

   public static void gridCreator(int width, int height, Graphics g, int size, 
            int xPosition, int yPosition, int secondRowOffset){
      int MORTAR = 2;
      int tempX = xPosition;
      for (int i = 0; i < height/2; i++){
         for (int j = 0; j < width; j++){
            rowCreator(width, g, size, xPosition, yPosition);
            rowCreator(width, g, size, xPosition+secondRowOffset, yPosition+(size + MORTAR));
         }
         xPosition = tempX;
         yPosition += 2*(size + MORTAR);
      }
   }

   public static void rowCreator(int width, Graphics g, int size, 
            int xPosition, int yPosition){
      int MORTAR = 2;
      int tempX = xPosition;     
      for (int i = 0; i < width/2; i++){
         pairCreator(g, size, xPosition, yPosition);
         xPosition += size*2;
      }
   }
}



