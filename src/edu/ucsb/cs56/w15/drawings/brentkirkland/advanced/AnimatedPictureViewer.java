package edu.ucsb.cs56.w15.drawings.brentkirkland.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.lang.Math.*;
import java.util.Random;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private PizzaWithPepperoni pizza = new PizzaWithPepperoni(250, 250, 400, 400);
    
    Thread anim;   
    
    private int x = 250;
    private int y = 220;
    
    private int dx = 5;

    
    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    //random color picker
    float red;
    float green;
    float blue;
    private Color randomColor(){
	Random r = new Random();
	red = r.nextFloat();
	green = r.nextFloat();
	blue = r.nextFloat();
	return new Color(red,green,blue);	
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(randomColor());
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Pizza
          g2.setColor(randomColor());
          PizzaWithPepperoni test = new PizzaWithPepperoni(x, y, 400, 400);
	  	  
          g2.draw(test);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 425) { dx = -5; }
            if (x <= 200) { dx = 5; }
            
            x += dx;                
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
