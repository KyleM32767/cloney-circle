/**
 * ColoredObject.java
 * The parent class of any object in Cloney Circle that has a color
 * 
 * @author Kyle Mitard
 * 
 * 23 March 2019
 */

package cloney_circle;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ColoredObject
{
	//INSTANCE VARIABLES-----------------------------------------------------------------
	
	/**
	 * the current coordinates of the object
	 */
	private int x, y;
	
	/**
	 * the coordinates of the object when it was last drawn
	 */
	private int oldX, oldY;
	
	/**
	 * the object's color
	 */
	private Color color;
	
	//METHODS----------------------------------------------------------------------------
	
	/**
	 * Constructor
	 * 
	 * @param xCoord	the ColoredObject's initial x coordinate
	 * @param yCoord	the ColoredObject's initial y coordinate
	 * @param c			the ColoredObject's initial color
	 */
	public ColoredObject(int xCoord, int yCoord, Color c)
	{
		x = xCoord;
		y = yCoord;
		color = c;
		setOldCoords();
	}
	

	/**
	 * Checks the colors of two ColoredObjects
	 * 
	 * @param co 	another ColoredObject
	 * 
	 * @return true if the two colored objects are the same color
	 */
	public boolean equals(ColoredObject co)
	{
		return color.equals(co.getColor());
	}
	
	
	/**
	 * returns the y-coordinate
	 * 
	 * @return the object's y-coordinate
	 */
	public int getY()
	{
		return y;
	}
	
	
	/**
	 * returns the x-coordinate
	 * 
	 * @return the object's x-coordinate
	 */
	public int getX()
	{
		return x;
	}


	/**
	 * returns the object's color
	 * 
	 * @return the object's color
	 */
	public Color getColor()
	{
		return color;
	}
	
	
	/**
	 * changes the object's color
	 * 
	 * @param newColor	the new color
	 */
	public void setColor(Color newColor)
	{
		color = newColor;
	}
	
	
	/**
	 * moves a ColoredObject
	 * 
	 * @param newX	the new x-coordinate
	 * @param newY	the new y-coordinate
	 */
	public void move(int newX, int newY)
	{	
		x = newX;
		y = newY;
	}
	
	
	/**
	 * sets the coordinates of where the ColoredObject was last drawn to the current coordinates.
	 * @see the draw() methods in subclasses
	 */
	public void setOldCoords()
	{
		oldX = x;
		oldY = y;
	}
	
	
	/**
	 * gets the old x-coordinate
	 * 
	 * @return the x-coordinate of the object when it was last drawn
	 */
	public int getOldX()
	{
		return oldX;
	}
	
	
	/**
	 * gets the old y-coordinate
	 * 
	 * @return the y-coordinate of the object when it was last drawn
	 */
	public int getOldY()
	{
		return oldY;
	}
	
	
	/**
	 * draws the ColoredObject
	 * 
	 * @param g	the Graphics object the ColoredObject will be drawn on
	 */
	public abstract void draw(Graphics g);
}
