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
 * Last updated 26 April 2019
 */

package cloney_circle;

import javax.swing.*; 
import java.awt.event.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

public class GameGUI extends JFrame implements KeyListener
{
	/**
	 * I'm just adding this to make Eclipse happy...
	 * I have no idea why Eclipse wants this but it might just be irrelevant to me anyways
	 */
	private static final long serialVersionUID = 1L;
	
	
	//INSTANCE VARIABLES-------------------------------------------------------------------
	
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
	
	
	/**
	 * the size of the window in pixels (it's a square window)
	 */
	final static int WINDOW_SIZE = 1000;
	
	
	/**
	 * Where the score will be displayed
	 */
	static JLabel scoreboard;
	
	
	/**
	 * The panel where the scoreboard will be
	 */
	JPanel scorePanel;
	
	
	/**
	 * The container where the score panel will be
	 */
	Container cp;
	
	
	//METHODS------------------------------------------------------------------------------
	
	public static void main(String[] args) throws InterruptedException
	{
		
		gui = new GameGUI();
		game = new GameLogic(gui.getGraphics(), WINDOW_SIZE);
		
		//initialize and start the timer, which is used to draw new frames at regular intervals
		timer = new Timer(17, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (game.gameOver())
					{
						//ask to play again
						if (JOptionPane.showConfirmDialog(null, "FINAL SCORE: " + game.getScore() + "\nPlay Again?") == JOptionPane.YES_OPTION)
						{
							//reset the game if yes
							game = new GameLogic(gui.getGraphics(), WINDOW_SIZE);
							System.gc();
						}
						else //quit if no
							quitGame();
					}
					
					game.nextFrame();
					game.drawFrame();
					
					scoreboard.setText("Score: " + game.getScore());
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
		
		//this is supposed to combat flickering
		setIgnoreRepaint(true);
		
		//set up scoreboard
		scoreboard = new JLabel("Score: 0");
		scoreboard.setFont(new Font("Arial ", Font.PLAIN, 36));
		cp = getContentPane();
		cp.setLayout(new FlowLayout());
		scorePanel = new JPanel();
		scorePanel.add(scoreboard);
		cp.add(scorePanel);
	}

	
	/**
	 * Rotates the circle if the space bar is pressed, quits if esc is pressed
	 * 
	 * @param e	a KeyEvent representing the last keystroke detected
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{	
		switch (e.getKeyCode())
		{
		
		//escape is pressed	-> quit the game
		case (KeyEvent.VK_E):
		{
			quitGame();
			break;
		}
		
		//any other key is pressed -> turn the circle
		default:
			game.turnCircle();
		
		}
	}

	
	/**
	 * Exits the game
	 */
	public static void quitGame()
	{
		timer.stop();
		gui.setVisible(false);
		System.exit(0);
	}

	
	//these methods have nothing, but the must be here because of the KeyListener interface
	@Override
	public void keyReleased(KeyEvent arg0){}
	@Override
	public void keyTyped(KeyEvent arg0){}
}
