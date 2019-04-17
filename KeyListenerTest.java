/**
 * A little test class that I'm using to learn/test out the KeyListener interface
 * it consists of a rectangle that changes color when you press a key
 * 
 * @author Kyle Mitard
 * 
 * Created 16 April 2019
 */

package keylistener_test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyListenerTest extends JFrame implements KeyListener
{
	
	Color color = new Color(0,0,0);
	
	public KeyListenerTest()
	{
		setSize(new Dimension(500,500));
		addKeyListener(this);
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(color);
		g.fillRect(100,100,200,200);
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if (event.getKeyCode() == 69)
		{
			color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.VK_A)
		{
			color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{}
	
	public static void main(String[] args)
	{
		new KeyListenerTest();
	}

}
