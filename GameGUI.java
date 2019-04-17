/**
 * GameGUI.java
 * The GUI for Cloney Circle
 * 
 * **THERE WILL BE NO GAME LOGIC IN HERE ANY LOGIC SEEN IS ONLY FOR TESTING PURPOSES**
 * 
 * @author Kyle Mitard
 * 
 * 23 March 2019
 * 
 * TODO learn how Timers work in swing
 */

package cloney_circle;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class GameGUI extends JFrame
{
	/**
	 * I'm just adding this to make Eclipse happy
	 */
	private static final long serialVersionUID = 1L;
	
	
	static Ball ball = new Ball(100, 100, new Color(0,0,0), 10, new Parabola(150, 24, 35));
	static CircleFragment fragment = new CircleFragment(200,200, new Color(0,0,0), 50, 5, Math.PI / 3);
	
	/**
	 * Where everything actually happens
	 * At the moment it's just a ball bouncing without changing color
	 * It's flickery as hell and I have no idea why
	 */
	public static void main(String[] args) throws InterruptedException
	{
		
		GameGUI gui = new GameGUI();
		
		//bounces the ball using the Parabola class
		while (true)
		{
			gui.repaint();
			ball.step();
			Thread.sleep(33);
		}
	}
	
	/**
	 * Initializes the GUI
	 * 
	 * @Override
	 */
	public GameGUI()
	{
		setSize(500, 500);
		setVisible(true);
	}
	
	/**
	 * Draws a frame of the game
	 */
	public void paint(Graphics g)
	{
		ball.draw(g);
		fragment.draw(g);
	}
}
