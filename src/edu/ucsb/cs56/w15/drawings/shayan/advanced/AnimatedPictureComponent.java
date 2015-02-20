package edu.ucsb.cs56.w15.drawings.shayan.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.geom.AffineTransform;
// the four tools things we'll use to draw

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles

import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

/**
   A component that draws an animated picture by Jakob Staahl
   
   @author Shayan Sadigh
   @version CS56, Winter 2015
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape ddrArr;

    // starting length: 300; width: 30
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a pencil writing across the screen

	@param startingXPos the starting x position of the pencil
    */
    public AnimatedPictureComponent() {
	ddrArr = new DDRArrow(300);
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the pencil is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;
       ddrArr = ShapeTransforms.rotatedCopyOf(ddrArr, 0.01);
   }    
  
}
