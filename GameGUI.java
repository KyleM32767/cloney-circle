/**
 * GameGUI.java
 * The GUI for Cloney Circle
 * 
 * **THERE WILL BE NO GAME LOGIC IN HERE ANY LOGIC SEEN IS ONLY FOR TESTING PURPOSES**
 * 
 * @author Kyle Mitard
 * 
 * Created 23 March 2019
 * 
 * Last updated 19 April 2019
 */

package cloney_circle;

import javax.swing.*; 
import java.awt.event.*;

public class GameGUI extends JFrame implements KeyListener
{
	/**
	 * I'm just adding this to make Eclipse happy...
	 * I have no idea why Eclipse wants this but it might just be irrelevant to me anyways
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * The logic behind the game
	 */
	static GameLogic game;
	
	
	/**
	 * The GUI of the game
	 */
	static GameGUI gui;
	
	
	/**
	 * The timer that controls frame updates
	 */
	static Timer timer;
	
	
	
	final static int WINDOW_SIZE = 1000;
	
	
	public static void main(String[] args) throws InterruptedException
	{
		
		gui = new GameGUI();
		game = new GameLogic(gui.getGraphics(), WINDOW_SIZE);
		
		//initialize and start the timer, which is used to draw new frames at regular intervals
		timer = new Timer(17, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					game.nextFrame();
					game.drawFrame();
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
		setSize(WINDOW_SIZE, WINDOW_SIZE);
		
		//set up the key listener
		addKeyListener(this);
		
		//make the window visible
		setVisible(true);
		
		//this is SUPPOSED to combat flickering
		setIgnoreRepaint(true);
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
		switch (e.getKeyCode())
		{
		
		//space bar is pressed	-> rotates the circle
		case (KeyEvent.VK_SPACE):
		{
			game.turnCircle();
			break;
		}
		
		//escape is pressed		-> quit the game
		case (KeyEvent.VK_ESCAPE):
		{
			timer.stop();
			gui.setVisible(false);
			System.exit(0);
		}
		
		}
	}


	//these methods have nothing, but the must be here because of the KeyListener interface
	@Override
	public void keyReleased(KeyEvent arg0){}
	@Override
	public void keyTyped(KeyEvent arg0){}
}
