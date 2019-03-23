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
	 * Initialized the applet
	 */
	@Override
	public void init()
	{
		this.setSize(500, 500);
	}
	
	/**
	 * draws the game
	 * at the moment it's just a ball going back and forth
	 */
	public void paint(Graphics g)
	{
		Ball ball = new Ball(100, 100, new Color(0,0,0), 10);
		ball.draw(g);
		
		//just moves the ball foreward and backward
		while (true)
		{
			for (int i = 100; i < 400; i += 5)
			{
				ball.move(i, 100);
				ball.draw(g);
				sleep(17); //get that solid 60 fps yo
			}
			for (int i = 400; i > 100; i -= 5)
			{
				ball.move(i, 100);
				ball.draw(g);
				sleep(17); //get that solid 60 fps yo
			}
		}
	}

	/**
	 * does a delay via Thread.delay() with a try-catch loop, which can somehow get around
	 * the fact that paint() cannot throw an InterruptedException. I honestly have no idea
	 * why this works.
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
