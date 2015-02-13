package edu.ucsb.cs56.w15.drawings.jdogg5566.advanced;
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.*;
import java.awt.Rectangle;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

public class SweatshirtWithLogo extends Sweatshirt implements Shape {

/**
   A subclass of a vector drawing of a sweatshirt that implements
   the Shape interface that adds a logo (smiley face) to the torso of the sweatshirt.
   Can be drawn, rotated, scaled, etc.
      
   @author Jonathan Easterman 
   @version for CS56, Winter 15, UCSB
   
*/

	public SweatshirtWithLogo (double x, double y, double tHeight, double tWidth) {
   		super(x, y, tHeight, tWidth);
   		double headX = x * 1.07;
   		double headY = y * 1.2;
   		double leftEyeX = headX * 1.03;
   		double leftEyeY = headY * 1.05;
   		double rightEyeX = headX * 1.2;
   		double rightEyeY = headY * 1.05;
   		double mouthX = leftEyeX;
   		double mouthY = leftEyeY * 1.1;

   		Ellipse2D.Double head =
   			new Ellipse2D.Double(headX, headY, .75 * tWidth, .75 * tWidth);

   		Rectangle2D.Double mouth =
   			new Rectangle2D.Double(mouthX, mouthY, .60 * tWidth, .1 * tHeight);

   		Ellipse2D.Double leftEye =
   			new Ellipse2D.Double(leftEyeX, leftEyeY, .25 * tWidth, .25 * tWidth);

   		Ellipse2D.Double rightEye =
   			new Ellipse2D.Double(rightEyeX, rightEyeY, .25 * tWidth, .25*tWidth);

   		GeneralPath wholeSweatshirt = this.get();
   		wholeSweatshirt.append(head, false);
   		wholeSweatshirt.append(leftEye, false);
   		wholeSweatshirt.append(rightEye, false);
   		wholeSweatshirt.append(mouth, false);

   }


}