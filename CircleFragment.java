/**
 * CircleFragment.java
 * 
 * Class for one single-colored fragment of the circle in cloney circle
 * 
 * @author Kyle Mitard
 * 
 * Created 16 April 2019
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
	 * @param x	the x-coordinate of the point
	 * @param y	the y-coordinate of the point
	 * @param a	an angle in radians
	 */
	public void rotate(int x, int y, double a)
	{/*TODO this entire method*/}
	
	
	/**
	 * draws the ColoredObject
	 * 
	 * @param g	the Graphics object the ColoredObject will be drawn on
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
		
		for (int i = 0; i < thickness; i++)
		{
			g.drawLine(x1 + i, y1 + i, x2 + i, y2 + i);
		}
		
	}

}
