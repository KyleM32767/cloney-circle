/**
 * GameGUI.java
 * The GUI for Cloney Circle
 * 
 * @author Kyle Mitard
 * 
 * 23 March 2019
 */

package cloney_circle;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class GameGUI extends Applet
{
	/**
	 * Initializes the applet
	 * 
	 * @Override
	 */
	public void init()
	{
		this.setSize(500, 500);
	}
	
	/**
	 * Draws the game
	 * At the moment it's just a ball bouncing without changing color
	 * 
	 * **THERE WILL BE NO GAME LOGIC IN HERE ANY LOGIC SEEN IS ONLY FOR TESTING PURPOSES**
	 */
	public void paint(Graphics g)
	{
		Ball ball = new Ball(100, 100, new Color(0,0,0), 10, new Parabola(150, 24, 35));
		ball.draw(g);
		
		//bounces the ball using the Parabola class
		while (true)
		{
			ball.step();
			ball.draw(g);
			sleep(20);
		}
	}

	/**
	 * Does a delay via Thread.delay() with a try-catch statement, which can somehow get
	 * around the fact that paint() cannot throw an InterruptedException. I honestly have
	 * no idea why this works and it dooesn't otherwise.
	 * 
	 * @param ms	the delay in milliseconds
	 */
	public static void sleep(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e)
		{}
	}
}
