import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * @author 17071
 * @date June 10, 2016
 *
 */

/**
 * Alien
 * @param none
 * @return none
 *
 */
public class Alien extends Sprite {
	
	/**
	 * Alien()
	 * @param int xpos, ypos, distance, speed
	 * @return none
	 * constructs a new alien which is given an x-pos, y-pos, distance, and speed
	 *
	 */
	public Alien(int xpos, int ypos, int distance, int speed) 
	{
		super(xpos, ypos, distance, speed);
	}
	
	/**
	 * move()
	 * @param none
	 * @return none
	 * changes the xpos of an alien based on speed and direction
	 *
	 */
	public void move()
	{
		xpos = xpos + speed*distance;
	}
	
	/**
	 * switchDirection()
	 * @param none
	 * @return none
	 * changes the direction and moves the alien down the screen
	 *
	 */
	public void switchDirection()
	{	
		speed *= -1;
		ypos += 45;
	}

	/**
	 * checkLeft()
	 * @param none
	 * @return boolean
	 * if an alien's x-pos is outside the left boundary, return true
	 *
	 */
	public boolean checkLeft()
	{
		if(getX()<=0)
			return true;
		return false;
	}
	
	/**
	 * checkRight()
	 * @param none
	 * @return boolean
	 * if an alien's x-pos is outside the right boundary, return true
	 *
	 */
	public boolean checkRight()
	{
		if(getX()>=1140)
			return true;
		return false;
	}

}
