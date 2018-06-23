import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Bullet
 * @param none
 * @return none
 *
 */
public class Bullet extends Sprite{
	
	/**
	 * Bullet()
	 * @param int xpos, ypos distance, speed
	 * @return none
	 * constructs a new bullet which is given an x-pos, y-pos, distance, and speed
	 *
	 */
	public Bullet(int xpos, int ypos, int distance, int speed) 
	{
		super(xpos, ypos, distance, speed);
	}

	/**
	 * moveLeft()
	 * @param none
	 * @return none
	 * if the ship's x-pos is greater than 48, move left
	 *
	 */
	public void moveLeft()
	{
		if (xpos > 48)
			xpos = xpos - 8*speed*distance;
	}
	
	/**
	 * moveRight()
	 * @param none
	 * @return none
	 * if the ship's x-pos is less than 320, move right
	 *
	 */
	public void moveRight()
	{
		if (xpos < 320)
			xpos = xpos + 8*speed*distance;
	}

	/**
	 * fire()
	 * @param none
	 * @return none
	 * moves the bullet up the screen by changing the y-pos 
	 *
	 */
	public void fire() 
	{
		ypos -= 6*speed*distance;
	}
	
	/**
	 * remove()
	 * @param none
	 * @return none
	 * makes the bullet image null
	 *
	 */
	public void remove()
	{
		img = null;
	}

}