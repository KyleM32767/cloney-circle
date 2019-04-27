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
import java.awt.Point;

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
	
	
	/**
	 * The amount of frames it takes to do one turn
	 */
	private final int TURN_FRAMES = 8;
	
	
	/**
	 * What frame in a turn the circle is in (0 if not turning at all)
	 */
	private int turnStatus;
	
	
	/**
	 * an array of where the fragments were initially, which is for fixing any shifting of fragments due to rounding
	 */
	private final Point[] fragmentPoints;
	
	
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
		turnStatus = 0;
		fragmentPoints = new Point[numSides];
		
		/*
		 * calculate the length of each part to the circle
		 * this one isn't immediately obvious as to why so here is a derivation of it:
		 * https://docs.google.com/document/d/1a4joJsVlFmSqraHsGgRAJRp5OkZLeW93JBuJsFOsMeI/edit?usp=sharing
		 */
		int fragmentLength = (int)(2 * radius * Math.tan(Math.PI / numSides));
		
		//calculate the points of the bottom-most fragment's coordinates
		int bottomX = x - fragmentLength / 2;
		int bottomY = y + radius;
		
		//initialize the parts array
		parts = new CircleFragment[numSides];
		for (int i = 0; i < numSides; i++)
		{
			//create a new part at the bottom-most position
			parts[i] = new CircleFragment(bottomX, bottomY, colors[i], fragmentLength, thickness, 0);
			
			//rotate each part to its spot
			parts[i].rotate(x, y, fragmentAngle * i);
			
			fragmentPoints[i] = new Point(parts[i].getX(), parts[i].getY());
		}
	}

	
	/**
	 * Does a single rotation of the circle in a counterclockwise direction
	 */
	public void turn()
	{
		if (turnStatus == 0)
		{
			turnStatus++;
			
			bottomIndex++;
			if (bottomIndex == parts.length)
				bottomIndex = 0;
		}
	}
	
	
	/**
	 * Draws the circle
	 * 
	 * @param g	the Graphics object that the Circle will be drawn on
	 */
	public void draw(Graphics g)
	{
		//clear the existing circle
		g.clearRect((int) (x - radius * 1.3), (int) (y - radius * 1.3), (int) (2.6 * radius), (int) (2.6 * radius));
		
		//if the circle is in the middle of a turn
		if (turnStatus > 0)
		{
			for (CircleFragment cf: parts)
				cf.rotate(x, y, fragmentAngle * -1 / TURN_FRAMES);
			
			turnStatus++;
		}
		
		//check if a turn is complete
		if (turnStatus == TURN_FRAMES + 1)
		{
			turnStatus = 0;
			fixCircle();
		}
		
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
	
	
	/**
	 * moves the parts back to the right place after a turn makes everything a little off
	 */
	public void fixCircle()
	{
		int index = bottomIndex;
		
		for (Point p: fragmentPoints)
		{
			parts[index].move((int) p.getX(), (int) p.getY());
			
			index++;
			if (index == parts.length)
				index = 0;
		}
	}
}
