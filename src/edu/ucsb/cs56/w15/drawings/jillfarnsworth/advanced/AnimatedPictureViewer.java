package edu.ucsb.cs56.w15.drawings.jillfarnsworth.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** A viewer class to see my animation
 *  
 * @author Jill Farnsworth
 * @version for UCSB CS56, W15
 */

public class AnimatedPictureViewer extends JFrame {
    Thread anim; 
    AnimatedPictureComponent component;
    static final double startingX = 400;
    static final double startingY = 400;
    static final double speed = 1.6;
    static final double startingWidth = 150;
    static final double startingHeight = 90;
    static final double swimSpeed = 0.7;


 /** constructs a JFrame with an animated picture inside
     */
    public AnimatedPictureViewer() {
	setSize(500,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	component = new AnimatedPictureComponent(startingX, startingY, speed, swimSpeed, startingWidth, startingHeight);
        add(component);
	getContentPane().addMouseListener(new MouseAdapter() {
	    public void mouseEntered(MouseEvent e) {
		anim = new Animate();
		anim.start();
	    }
	    public void mouseExited(MouseEvent e) {
		anim.interrupt();
		while (anim.isAlive()){}
		anim = null;
	    }
	} );
	setVisible(true);
    }

    public static void main(String[] args) {
	AnimatedPictureViewer apv = new AnimatedPictureViewer();
    }

    class Animate extends Thread {
	public void run() {
	    try {
		while(true) {
		    display(20);
		}
	    } catch(Exception ex) {
		if (ex instanceof InterruptedException) {}
		else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}

	void display(int delay) throws InterruptedException {
	    component.repaint();
	    if (Thread.currentThread().interrupted())
		throw(new InterruptedException());
	    Thread.currentThread().sleep(delay);
	}
    }

}
