import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Ship
 * @param none
 * @return boolean
 * 
 */
public class Ship extends Sprite{

	/**
	 * Ship()
	 * @param int xpos, ypos distance, speed
	 * @return none
	 * constructs a new ship which is given an x-pos, y-pos, distance, and speed
	 *
	 */
	public Ship(int xpos, int ypos, int distance, int speed) 
	{
		
		super(xpos, ypos, distance, speed);
	}
	
	/**
	 * moveLeft()
	 * @param none
	 * @return none
	 * if the ship's x-pos is greater than zero, move left
	 *
	 */
	public void moveLeft()
	{
		if (xpos > 0)
			xpos = xpos - 8*speed*distance;
	}
	
	/**
	 * moveRight()
	 * @param none
	 * @return none
	 * if the ship's x-pos less than 1080, move right
	 *
	 */
	public void moveRight()
	{
		if (xpos < 1080)//board width - width of ship (120)
			xpos = xpos + 8*speed*distance;
	}
	
	/**
	 * moveRight3()
	 * @param none
	 * @return none
	 * if the 3 ship's x-pos less than 480, move right
	 *
	 */
	public void moveRight3()
	{
		if (xpos < 760)//board width - 720
			xpos = xpos + 8*speed*distance;
	}

}