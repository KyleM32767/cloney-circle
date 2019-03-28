/**
 * Ball.java
 * 
 * A class for the Ball in Cloney Circle
 * 
 * @author Kyle Mitard
 * 
 * 23 March 2019
 */

package cloney_circle;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends ColoredObject
{
	//INSTANCE VARIABLES---------------------------------------------------------------------------
	
	/**
	 * the diameter of the ball
	 */
	private static int d;
	
	
	/**
	 * a Parabola object to represent the path of the ball
	 */
	private Parabola path;
	
	
	//METHODS--------------------------------------------------------------------------------------

	
	/**
	 * Constructor
	 * 
	 * @param xCoord	the ColoredObject's initial x coordinate
	 * @param yCoord	the ColoredObject's initial y coordinate
	 * @param c			the ColoredObject's initial color
	 * @param diameter	the diameter of the ball
	 * @param p			the Parabola object that will represent the path of the ball
	 */
	public Ball(int xCoord, int yCoord, Color c, int diameter, Parabola p)
	{
		super(xCoord, yCoord, c);
		path = p;
		d = diameter;
	}
	
	
	//TODO add a constuructor that randomly selects the color
	
	
	/**
	 * Draws the ball
	 * 
	 * @param g	the graphics object where the ball is drawn
	 * 
	 * @Override
	 */
	public void draw(Graphics g)
	{
		//clear the old object
		g.clearRect(super.getOldX(), super.getOldY(), d, d);
		
		//draw the new object
		g.fillOval(super.getX(), super.getY(), d, d);
		
		//change the old coordinates
		super.setOldCoords();
	}
	
	
	/**
	 * moves the ball to the next step of the path
	 */
	public void step()
	{
		super.move(super.getX(), path.nextStep());
	}
	
}
