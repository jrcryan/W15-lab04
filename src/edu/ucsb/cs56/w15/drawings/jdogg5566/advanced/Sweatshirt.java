package edu.ucsb.cs56.w15.drawings.jdogg5566.advanced;
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.*;
import java.awt.Rectangle;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;


/**
   A vector drawing of a sweatshit that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jonathan Easterman 
   @version for CS56, Winter 15, UCSB
   
*/

public class Sweatshirt extends GeneralPathWrapper implements Shape {

/**
       Constructor

       @param x x coord of center of torso of sweatshirt
       @param y y coord of center of torso of sweatshirt
	@param tHeight the height of the torso shape, arms and hood will be scaled accordingly
	@param tWidth the width of the torso shape, arms and hood will be scaled accordingly
*/

    public Sweatshirt (double x, double y, double tHeight, double tWidth) {
        double armY = y + .5*tHeight; // y coord of the top of the arm
        double rightArmX = x + .5*tWidth; // x coord of the right arm
        double leftArmx = x - .5*tWidth; // x coord of the left arm
        double circleCenterX = x;
        double circleCenterY = y - 1.25*tHeight;
        double circleRadius = tWidth * .25;

        Rectangle2D.Double torso =
            new Rectangle2D.Double(x,y,tWidth,tHeight);

        Rectangle2D.Double leftArm = 
            new Rectangle2D.Double();

        Rectangle2D.Double rightArm = 
            new Rectangle2D.Double();

        Ellipse2D.Double hood = 
            new Ellipse2D.Double(circleCenterX,circleCenterY,circleRadius,circleRadius);

        GeneralPath wholeSweatshirt = this.get();
        wholeSweatshirt.append(torso, false);
        wholeSweatshirt.append(leftArm, false);
        wholeSweatshirt.append(rightArm, false);
        wholeSweatshirt.append(hood, false);

        this.set(wholeSweatshirt);
    }

}
