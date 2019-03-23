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
	private Parabola path; //TODO add parabola functionality
	
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
	public Ball(int xCoord, int yCoord, Color c, int diameter)
	{
		super(xCoord, yCoord, c);
		//path = p;
		d = diameter;
	}
	
	/**
	 * Draws the ball
	 */
	@Override
	public void draw(Graphics g)
	{
		//clear the old object
		g.clearRect(super.getOldX(), super.getOldY(), d, d);
		
		//draw the new object
		g.fillOval(super.getX(), super.getY(), d, d);
		
		//set the old coordinates
		super.setOldCoords();
	}

}
