/**
 * CircleFragment.java
 * 
 * Class for one single-colored fragment of the circle in cloney circle
 * 
 * All angles are in radians because that's what the everything in java.lang.Math uses
 * 
 * @author Kyle Mitard
 * 
 * Created 16 April 2019
 * 
 * Last updated 19 April 2019 
 */

package cloney_circle;

import java.awt.Color;
import java.awt.Graphics;

public class CircleFragment extends ColoredObject
{
	//INSTANCE VARIABLES-----------------------------------------------------------------------
	
	/**
	 * the angle of thefragment in radians
	 */
	private double angle;
	
	
	/**
	 * the length of the fragment
	 */
	private int length;
	
	
	/**
	 * the thickness of the fragment
	 */
	private int thickness;
	
	
	//METHODS----------------------------------------------------------------------------------
	
	/**
	 * Constructor
	 * 
	 * @param xCoord	the initial x coordinate 
	 * @param yCoord	the initial y coordinate
	 * @param c			the initial color
	 * @param len		the length of the fragment in pixels
	 * @param thiccness	the thickness of the fragment in pixels
	 * @param angle		the initial angle of the fragment in radians
	 */
	public CircleFragment(int xCoord, int yCoord, Color c, int len, int thiccness, double a)
	{
		super(xCoord, yCoord, c);
		length = len;
		thickness = thiccness;
		angle = a;
	}
	
	
	/**
	 * rotates the CircleFragment about a given point
	 * 
	 * the math comes from here:
	 * https://www.gamefromscratch.com/post/2012/11/24/GameDev-math-recipes-Rotating-one-point-around-another-point.aspx
	 * 
	 * @param x	the x-coordinate of the point of rotation
	 * @param y	the y-coordinate of the point of rotation
	 * @param a	the angle of rotation in radians
	 */
	public void rotate(int x, int y, double a)
	{	
		int newX = (int) (Math.cos(a) * (super.getX() - x)
				- Math.sin(a) * (super.getY() - y) + x);
		
		int newY = (int) (Math.sin(a) * (super.getX() - x)
				+ Math.cos(a) * (super.getY() - y) + y);
		
		super.move(newX, newY);
		
		angle += a;
	}
	
	
	/**
	 * draws the CircleFragment
	 * 
	 * @param g	the Graphics object the CircleFragment will be drawn on
	 * 
	 * @Override
	 */
	public void draw(Graphics g)
	{
		g.setColor(super.getColor());
		
		int x1 = super.getX();
		int y1 = super.getY();
		
		int x2 = (int) (x1 + length * Math.cos(angle)); 
		int y2 = (int) (y1 + length * Math.sin(angle));
		
		int[] xCoords = {x1, x2, x2 + thickness, x1 + thickness};
		int[] yCoords = {y1, y2, y2 + thickness, y1 + thickness};
		
		g.fillPolygon(xCoords, yCoords, 4);
	}
	
	
	/**
	 * returns the angle of the CircleFragment
	 * 
	 * @return	an angle in radians
	 */
	public double getAngle()
	{
		return angle;
	}
	
	
	/**
	 * returns a string representation of the circleFragment for testing/debugging purposes
	 */
	@Override
	public String toString()
	{
		return super.getColor().toString() + " at (" + super.getX() + ", " + super.getY() + ")";
	}
}
