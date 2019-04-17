/**
 * GameGUI.java
 * The GUI for Cloney Circle
 * 
 * **THERE WILL BE NO GAME LOGIC IN HERE ANY LOGIC SEEN IS ONLY FOR TESTING PURPOSES**
 * 
 * @author Kyle Mitard
 * 
 * Created 23 March 2019
 */

package cloney_circle;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

public class GameGUI extends JFrame implements KeyListener
{
	/**
	 * I'm just adding this to make Eclipse happy...
	 * I have no idea why Eclipse wants this but it might just be irrelevant to me anyways
	 */
	private static final long serialVersionUID = 1L;
	
	
	static Ball ball = new Ball(100, 100, new Color(0,0,0), 10, new Parabola(150, 24, 35));
	static CircleFragment fragment = new CircleFragment(200,200, new Color(0,0,0), 50, 5, Math.PI / 3);
	
	
	/**
	 * The app itself
	 */
	static GameGUI gui;
	
	
	/**
	 * The timer that controls frame updates
	 */
	static Timer timer;
	
	
	/**
	 * Where everything actually happens
	 * The ball is flickery as hell and I have no idea why
	 */
	public static void main(String[] args) throws InterruptedException
	{
		
		gui = new GameGUI();
		
		//initialize and start the timer, which is used to draw new frames at regular intervals
		timer = new Timer(33, new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						gui.repaint();
						//ball.step();
						fragment.rotate(150, 150, Math.PI / 4);
					}
				});
		timer.setInitialDelay(1000);
		timer.start();
	}
	
	
	/**
	 * Initializes the GUI
	 */
	public GameGUI()
	{
		//set dimensions of the window
		setSize(1000, 1000);
		
		//set up the key listener
		addKeyListener(this);
		
		//make the window visible
		setVisible(true);
	}
	
	
	/**
	 * Draws a frame of the game
	 */
	public void paint(Graphics g)
	{
		//ball.draw(g);
		fragment.draw(g);
	}


	/**
	 * Rotates the circle if the space bar is pressed, quits if esc is pressed
	 * 
	 * ...that is what it should do once this game is actually finished. Right now it just
	 * prints a placeholder statement, as the rest of the game is not ready yet
	 * 
	 * TODO complete this when the game is ready
	 * 
	 * @param e	a KeyEvent representing the last keystroke detected
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		
		//space bar is pressed	-> rotates the circle **ONLY A PLACEHOLDER RIGHT NOW**
		if (keyCode == KeyEvent.VK_SPACE)
			System.out.println("R O T A T E");
		
		//escape is pressed		-> quit the game
		else if (keyCode == KeyEvent.VK_ESCAPE)
		{
			System.out.println("Q U I T");
			timer.stop();
			gui.setVisible(false);
			System.exit(0);
		}
	}


	//these methods have nothing, but the must be here because of the KeyListener interface
	@Override
	public void keyReleased(KeyEvent arg0){}
	@Override
	public void keyTyped(KeyEvent arg0){}
}
