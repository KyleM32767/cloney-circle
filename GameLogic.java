/**
 * GameLogic.java
 * 
 * The class that handles the logic behind Cloney Circle
 * 
 * The game is meant to be played in a square JFrame window that is at least 50x50 pixels
 * 
 * I'm doing it like this purely for organization, although I have no idea whether it is more
 * or less efficient to have the GUI in the same class
 * 
 * @author Kyle Mitard
 * 
 * Created 21 April 2019
 * 
 * Last Updated
 */

package cloney_circle;

import java.awt.Color;
import java.awt.Graphics;

public class GameLogic
{
	
	//INSTANCE VARIABLES---------------------------------------------------------------------
	
	/**
	 * The ball in the game
	 */
	private Ball ball;
	
	
	/**
	 * The circle in the game
	 */
	private Circle circle;
	
	
	/**
	 * An array of all the colors that are used in the game
	 */
	private static Color[] colors = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.ORANGE, Color.CYAN};
	
	
	/**
	 * The graphics object on which the game is drawn
	 */
	private Graphics g;
	
	
	//METHODS--------------------------------------------------------------------------------
	
	/**
	 * Constructor
	 * 
	 * @param size		The side length of the window
	 * @param window	the graphics object the game is drawn on
	 */
	public GameLogic(Graphics window, int size)
	{
		if (size < 100)
			throw new IllegalArgumentException("Window size must be greater than 50x50!");
		
		//initialize graphics
		g = window;
		
		//center of the Circle, which is being put in the center of the window
		int center = size / 2;
		
		//the radius of the circle, which is 3/5 the distance from the end to the center of the window
		int circleRadius = (int) (center * 3 / 5);
		
		//the thickness of the circle, which is 1/50 the size of the window
		int circleThickness = size / 50;
		
		//the diameter of the ball, which is 1/20 the size of the window
		int ballDiameter = size / 20;
		int ballRadius = ballDiameter / 2;
		
		//initialize the circle
		circle = new Circle(center, center, circleRadius, colors, circleThickness);
		
		//initialize the ball (account for diameter since it is drawn from the corner, not the center)
		ball = new Ball(center - ballRadius, center + circleRadius - ballDiameter, colors[0], ballDiameter, new Parabola(center + circleRadius - ballDiameter, 48, center - ballDiameter));
	}
	
	
	/**
	 * advances to the next frame
	 */
	public void nextFrame()
	{
		ball.step();
	}
	
	
	/**
	 * draws the next frame
	 */
	public void drawFrame()
	{
		circle.draw(g);
		ball.draw(g);
	}
	
	
	/**
	 * turns the circle
	 */
	public void turnCircle()
	{
		circle.turn();
	}
}