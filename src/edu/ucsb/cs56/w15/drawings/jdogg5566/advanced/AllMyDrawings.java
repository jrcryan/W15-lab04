package edu.ucsb.cs56.w15.drawings.jdogg5566.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Jonathan Easterman
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a sweatshirts 
     */

    public static void drawPicture1(Graphics2D g2) {

		Sweatshirt s1 = new Sweatshirt(250,150,200,120);
		g2.setColor(Color.CYAN); g2.fill(s1); g2.draw(s1);
	
		// Make a black sweatshirt that's half the size, 
		// and moved over 150 pixels in x direction

		Shape s2 = ShapeTransforms.scaledCopyOfLL(s1,0.5,0.5);
		s2 = ShapeTransforms.translatedCopyOf(s2,150,0);
		g2.setColor(Color.BLACK); g2.fill(s2); g2.draw(s2);
	
		// Here's a sweatshirt that's 3x as big (1.5x the original)
		// and moved 150 more pixels to left.
		s2 = ShapeTransforms.scaledCopyOfLL(s2,3,3);
		s2 = ShapeTransforms.translatedCopyOf(s2,-150,300);
	
		// We'll draw this with a thicker stroke
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
		// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
		// #002FA7 is "International Klein Blue" according to Wikipedia
		// In HTML we use #, but in Java (and C/C++) its 0x
	
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0x002FA7)); 
		g2.fill(s2);
		g2.draw(s2); 
	
	
		// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
		g2.setStroke(orig);
		g2.setColor(Color.BLACK); 
		g2.drawString("A few sweatshirts by Jonathan Easterman", 20,20);
    }


    /** Draw a picture with a few sweatshirts and a few sweatshirts with logos
     */
    public static void drawPicture2(Graphics2D g2) {


	
		
	
		// Make a black house that's half the size, 
		// and moved over 150 pixels in x direction
		//Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
		//h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
		g2.setColor(Color.BLACK); //g2.draw(h2);
	
		// Here's a house that's 4x as big (2x the original)
		// and moved over 150 more pixels to right.
		
		// We'll draw this with a thicker stroke
		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
		// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
		// #002FA7 is "International Klein Blue" according to Wikipedia
		// In HTML we use #, but in Java (and C/C++) its 0x
	
		Stroke orig=g2.getStroke();
		g2.setStroke(thick);
		g2.setColor(new Color(0x002FA7)); 
	
		
		// Draw two houses with Windows
		
	 

		// Rotate the second house 45 degrees around its center.
	
		
		// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
		
		g2.setStroke(orig);
		g2.setColor(Color.BLACK); 
		g2.drawString("A bunch of Coffee Cups and a few houses by Phill Conrad", 20,20);
	   }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
		// label the drawing
		
		g2.drawString("Red and blue sweatshirts with logos by Jonathan Easterman", 20,20);

		SweatshirtWithLogo s = new SweatshirtWithLogo(100, 100, 100, 50);

		Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 

		g2.setStroke(thick);
		g2.setColor(new Color(0x002FA7));
		g2.fill(s);
		g2.draw(s);
		
		g2.setColor(Color.YELLOW);
		g2.fill(s.logoHead);
		g2.draw(s.logoHead);

		g2.setColor(Color.BLACK);
		g2.fill(s.logoFace);
		g2.draw(s.logoFace);


       Sweatshirt sBig = new Sweatshirt(250,150,200,120);
       Sweatshirt sSmall = new Sweatshirt(50, 50, 67, 40);
       
      

       g2.setColor(new Color(0x002FA7));
       g2.fill(sBig);
       g2.draw(sBig);

       g2.setColor(Color.RED);
       g2.fill(sSmall);
       g2.draw(sSmall);

       Shape sSmall2 = ShapeTransforms.rotatedCopyOf(sSmall, Math.PI/2.0);

       g2.setColor(Color.RED);
       g2.fill(sSmall2);
       g2.draw(sSmall2);

       Shape s2 = ShapeTransforms.translatedCopyOf(s, 100, 100);

       g2.setColor(Color.GREEN);
       g2.fill(s2);
       g2.draw(s2);

       g2.setColor(Color.RED); // Need to figure out how to draw the smiley with transformed sweatshirt
       g2.fill((SweatshirtWithLogo)s2.logoHead);
       g2.draw((SweatshirtWithLogo)s2.logoHead);

       g2.setColor(Color.BLUE);
       g2.fill((SweatshirtWithLogo)s2.logoFace);
       g2.draw((SweatshirtWithLogo)s2.logoFace);

       
    }
    

}
