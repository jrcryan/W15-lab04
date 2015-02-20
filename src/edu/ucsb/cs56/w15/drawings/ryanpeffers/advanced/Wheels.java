package edu.ucsb.cs56.w15.drawings.ryanpeffers.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Car
      
   @author Phill Conrad 
   @version for CS56, W15, UCSB, lab04
   
*/
public class Wheels extends Car implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public Wheels(double x, double y, double length, double height)
    {
	// construct the basic car shell
	super(x,y,length,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make 2 wheels and 2 windows and a door

	// The windows will be for front and back
	// The wheels will go in the wheel wells

	double lengthToWheelWell = length * 0.21;
	double lengthToMidCabin =  (0.15 * length) + (0.34*width) + ((0.55*length) - (0.34*height) - (0.866 * 0.68 * height))/2;
	double windowHeight = 0.3 * height;
	double backSection = 0.15*length + 0.34*height;
	double frontSection = 0.3*length + 1.732*0.34*height;


	Rectangle2D.Double backWindow = 
	    new Rectangle2D.Double(x + backSection, 0.66*height, lengthToMidCabin-backSection-(0.04*length), windowHeight);
	Rectangle2D.Double frontWindow = 
	    new Rectangle2D.Double(x + lengthToMidCabin+(0.04*length), 0.66*height, , winHt);
	    /*
	Rectangle2D.Double win1 =
	    new Rectangle2D.Double(x + w, winTop, 2.0 * w, winHt);
	Rectangle2D.Double win2 =
	    new Rectangle2D.Double(x + 4.0*w, winTop, 2.0 * w, winHt);
	Rectangle2D.Double win3 =
	    new Rectangle2D.Double(x + 7.0*w, winTop, 2.0 * w, winHt);
	    */
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(win1, false);
        wholeHouse.append(win2, false);
        wholeHouse.append(win3, false); 
    }

}
