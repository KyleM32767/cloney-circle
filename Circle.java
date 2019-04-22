/**
 * Circle.java
 * 
 * Class for the circle in Cloney Circle, which consists of CircleFragments
 * 
 * It's really more of a regular polygon, but I don't care. This game is called "Cloney
 * Circle," not "Cloney Regular Polygon"
 * 
 * @author Kyle Mitard
 * 
 * Created 18 April 2019
 * 
 * Last updated 22 April 2019
 */

package cloney_circle;

import java.awt.Color;
import java.awt.Graphics;

public class Circle
{
	//INSTANCE VARIABLES---------------------------------------------------------------------
	
	/**
	 * Array containing every circle fragment in counter-clockwise order, starting at the
	 * initial bottom fragment
	 */
	private CircleFragment[] parts;
	
	
	/**
	 * The index of the bottom portion of the circle
	 */
	private int bottomIndex;
	
	
	/**
	 * The radius of the circle in pixels
	 */
	private int radius;
	
	
	/**
	 * The angle between two adjacent fragments in radians
	 */
	private double fragmentAngle;
	
	
	/**
	 * The x-coordinate of the center
	 */
	private int x;
	
	
	/**
	 * The y-coordinate of the center
	 */
	private int y;
	
	//METHODS--------------------------------------------------------------------------------
	
	/**
	 * Constructor
	 * 
	 * @param centerX	The x-coordinate of the center
	 * @param centerY	The y-coordinate of the center
	 * @param r			The radius of the circle in pixels
	 * @param colors	The colors of the fragments starting at the bottom-most part and going counter-clockwise
	 * @param thickness	The thickness of each part, in pixels
	 */
	public Circle(int centerX, int centerY, int r, Color[] colors, int thickness)
	{
		//get the number of sides from the length of the colors array
		int numSides = colors.length;
		
		//initialize instance variables
		x = centerX;
		y = centerY;
		fragmentAngle = 2 * Math.PI / numSides;
		radius = r;
		bottomIndex = 0;
		
		/*
		 * //calculate the length of each part to the circle
		 * this one isn't immediately obvious as to why so here is a derivation of it:
		 * https://docs.google.com/document/d/1a4joJsVlFmSqraHsGgRAJRp5OkZLeW93JBuJsFOsMeI/edit?usp=sharing
		 */
		int fragmentLength = (int)(2 * radius * Math.tan(Math.PI / numSides));
		
		//calculate the points of the bottom-most fragment's coordinates
		int bottomX = x - fragmentLength / 2;
		int bottomY = x + radius;
		
		//initialize the parts array
		parts = new CircleFragment[numSides];
		for (int i = 0; i < numSides; i++)
		{
			//create a new part at the bottom-most position
			parts[i] = new CircleFragment(bottomX, bottomY, colors[i], fragmentLength, thickness, 0);
			
			//rotate each part to its spot
			parts[i].rotate(x, y, fragmentAngle * i);
		}
	}

	
	/**
	 * Does a single rotation of the circle in a clockwise direction
	 */
	public void turn()
	{
		//rotate each individual part
		for (CircleFragment cf: parts)
			cf.rotate(x, y, fragmentAngle * -1);
		
		//update bottomIndex
		bottomIndex++;
		if (bottomIndex == parts.length)
			bottomIndex = 0;
	}
	
	
	/**
	 * Draws the circle
	 * 
	 * @param g	the Graphics object that the Circle will be drawn on
	 */
	public void draw(Graphics g)
	{
		//g.clearRect(x - radius, y - radius, 2 * radius, 2 * radius);
		
		for (CircleFragment cf: parts)
		{
			cf.draw(g);
		}
	}
	
	
	/**
	 * gets the bottom part of the circle
	 * 
	 * @return	the CircleFragment that is at the bottom of the circle
	 */
	public CircleFragment getBottomPart()
	{
		return parts[bottomIndex];
	}
}
