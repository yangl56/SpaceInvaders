import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;




/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;*/
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Board
 * @param none
 * @return none
 * what is does
 * declares new alien, ship, bullet, and alien array list
 * initializes new variables numBullets, fired1/2/3, win, lose, and score
 * 
 */
public class Board extends JPanel implements KeyListener{

	Alien a;
	Alien a1;
	Timer t;
	Ship s;
	Bullet b;
	Bullet b2;
	Bullet b3;
	
	ArrayList<Alien> aa = new ArrayList<Alien>();
	
	int numBullets = 0;
	int bulletCount = 0;
	boolean fired = false;
	boolean fired2 = false;
	boolean fired3 = false;
	boolean lose = false;
	boolean win = false;
	int score = 0;
	boolean ships3 = false;
	boolean changeDNeeded;
	
	/**
	 * Board
	 * @param none
	 * @return none
	 * what it does
	 *
	 */
	public Board()
	{
		a = new Alien(20, 35, 1, 4);
		a.setImage("invader1.png");
		//a.setWidth(65);
		//a.setHeight(65);
		s = new Ship(550, 700, 3, 1); //ypos = board height - 100, xpos = board width/2 - 50
		s.setImage("cannon1.png");
		
		makeAlienArray(6,11);
		
		ActionListener s1 = new ActionListener()
		{
			/**
			 * actionPerformed
			 * @param ActionEvent evt
			 * @return none
			 * tells aliens to move, checks to see if the bullet can fire, checks if alien has intersected with ship or bullet
			 * checks to see if the game is won or lost
			 *
			 */
			public void actionPerformed(ActionEvent evt)
			{
				repaint();
				
				if (fired == true)
				{
					if(numBullets <= 3 && numBullets >= 1)
					{
						if(b!=null)
						{
							b.fire();
						}
					}
				}
				if (fired2 == true)
				{
					if(numBullets <= 3 && numBullets >= 1)
					{
						if(b2!=null)
						{
							b2.fire();
						}
					}
				}
				if (fired3 == true)
				{
					if(numBullets <= 3 && numBullets >= 1)
					{
						if(b3!=null)
						{
							b3.fire();
						}
					}
				}
				if(b!=null && b.getY() < 0)
				{
					b = null;
					numBullets--;
				}
				if(b2!=null && b2.getY() < 0)
				{
					b2 = null;
					numBullets--;
				}
				if(b3!=null && b3.getY() < 0)
				{
					b3 = null;
					numBullets--;
				}
				for (Alien iter: aa)
				{
					iter.move();
					if(iter.checkRight() || iter.checkLeft())
					{
						for(int i = 0; i < aa.size(); i++)
						{
							aa.get(i).switchDirection();
						}
					}
					/*if(iter.checkLeft()||iter.checkRight())
					{
						changeDNeeded = true;
					}
					if(changeDNeeded)
					{
						for(Alien ali: aa)
						{
							ali.switchDirection();
						}
					}*/
					if(b!=null)
					{
						if (b.intersects(iter.getX(), iter.getY(), iter.getWidth(), iter.getHeight()))
						{
							fired = false;
							b = null;
							numBullets--;
							for(int i = 0; i < aa.size(); i++)
							{
								aa.remove(iter);
							}
							score+=100;
							break;
						}
					}
					if(ships3)
					{
						if(b2!=null)
						{
							if (b2.intersects(iter.getX(), iter.getY(), iter.getWidth(), iter.getHeight()))
							{
								fired2 = false;
								b2 = null;
								numBullets--;
								for(int i = 0; i < aa.size(); i++)
								{
									aa.remove(iter);
								}
								score+=100;
								break;
							}
						}
						if(b3!=null)
						{
							if (b3.intersects(iter.getX(), iter.getY(), iter.getWidth(), iter.getHeight()))
							{
								fired3 = false;
								b3 = null;
								numBullets--;
								for(int i = 0; i < aa.size(); i++)
								{
									aa.remove(iter);
								}
								score+=100;
								break;
							}
						}
					}
					for(int i = 0; i < aa.size(); i++)
					{
						if (s!=null)
						{
							if(ships3)
							{
								if (s.intersects(iter.getX(), iter.getY(), iter.getWidth(), iter.getHeight()))
								{
									lose = true;
								}
							}
							else
							{
								if (s.intersects(iter.getX(), iter.getY(), iter.getWidth()+440, iter.getHeight()))
								{
									lose = true;
								}
							}
						}
					}
				}
				if(lose==false)
				{
					if(aa.size()==0)
					{
						win = true;
					}
				}
				if(lose || win)
				{
					for(int i = 0; i < aa.size(); i++)
					{
						aa.remove(i);
					}
					s = null;
				}
			}
		};
		
		Timer t = new Timer(10, s1);
		t.start();
		
		addKeyListener(this);
		setFocusable(true);
	}

	/**
	 * paint
	 * @param Graphics g
	 * @return none
	 * paints all the images on the screen
	 *
	 */
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0,0, getWidth(), getHeight());
		if (s!=null)
		{
			g.drawImage(s.getImage(), s.getX(), s.getY(), this);
		}
		if (b!=null)
		{
			g.drawImage(b.getImage(), b.getX(), b.getY(), this);
		}
		if (b2!=null)
		{
			g.drawImage(b2.getImage(), b2.getX(), b2.getY(), this);
		}
		if (b3!=null)
		{
			g.drawImage(b3.getImage(), b3.getX(), b3.getY(), this);
		}
		for (Alien iter: aa)
		{
			g.drawImage(iter.getImage(), iter.getX(), iter.getY(), this);
		}
		g.setColor(Color.green);
		g.setFont(new Font("Courier New", Font.PLAIN, 25));
		g.drawString("Score: "+score, 20, 30);
		if(lose)
		{
			//g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("You Lose", 550, 200);
		}
		if(win)
		{
			//g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("You Win", 550, 200);
		}
	}
	
	/**
	 * makeAlienArray
	 * @param row, col
	 * @return none
	 * makes a new alien array
	 *
	 */
	public void makeAlienArray(int row, int col)
	{
		for (int r = 0; r < row; r++)
		{
			for (int c = 0; c < col; c++) 
			{
				a1 = new Alien(a.getX()+50*c, a.getY()+50*r, a.getDistance(), a.getSpeed());
				a1.setImage("invader1.png");
				a1.setWidth(65);
				a1.setHeight(65);
				aa.add(a1);
			}
		}  
	}
	
	public void keyTyped(KeyEvent e) {} //not used but needs to be in the class
	
	/**
	 * keyPressed
	 * @param KeyEvent e
	 * @return none
	 * performs actions when a key is pressed (ex: when right key is pressed, ship will move right)
	 *
	 */
	public void keyPressed(KeyEvent e) 
	{	
		if(s!=null)
		{
			if (e.getKeyCode() == 37) //left
			{
				s.moveLeft();
			}
			else if (e.getKeyCode() == 39) //right
			{
				if(ships3)
				{
					s.moveRight3();
				}
				else
					s.moveRight();
			}
			else if (e.getKeyCode() == 32) //space
			{
				if (numBullets==0)
				{
					int xposB = s.getX()+46;
					b = new Bullet(xposB-5, 690, 5, 1); //ypos = board height - 110
					b.setImage("bullet.png");
					fired = true;
					repaint();
					numBullets++;
					bulletCount++;
					if (ships3)
					{
						b2 = new Bullet(xposB+165, 690, 5, 1); //ypos = board height - 110
						b3 = new Bullet(xposB+330, 690, 5, 1); //ypos = board height - 110
						b2.setImage("bullet.png");
						b3.setImage("bullet.png");
						fired2 = true;
						fired3 = true;
						numBullets+=2;
					}
				}
			}
		}
		if(e.getKeyCode()==81)//q
		{
			for(Alien iter:aa)
			{
				iter.setImage("alienEmoji.png");
			}
		}
		if(e.getKeyCode()==27)//esc
		{
			for(Alien iter:aa)
			{
				iter.setImage("invader1.png");
			}
			s = new Ship(s.getX(), 700, 3, 1);
			s.setImage("cannon1.png");
			//s.setWidth(120);
			ships3 = false;
		}
		/*for(Alien iter:aa)
		{
			iter.setImage("emoji.png");
		}*/
		if(e.getKeyCode()==51)//3
		{
			s.setImage("3ships.png");
			s.setY(708);
			s.setX(385);
			//s.setWidth(440);
			ships3 = true;
		}
	
	}

	public void keyReleased(KeyEvent e) 
	{
		
	}

}