import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Sprite
 * @param none
 * @return none
 * what it does
 *
 */
public class Sprite {
	
	int xpos, ypos, speed, distance, getWidth, getHeight;
	BufferedImage img;
	
	/**
	 * Sprite
	 * @param int x,y,d,s
	 * @return none
	 * what it does
	 *
	 */
	public Sprite(int x, int y, int d, int s)
	{
		xpos = x;
		ypos = y;
		distance = d;
		speed = s;
	}
	
	/**
	 * getImage()
	 * @param none
	 * @return img
	 * returns the image of the sprite
	 *
	 */
	public BufferedImage getImage()
	{
		return img;
	}
	
	/**
	 * setImage
	 * @param String X
	 * @return none
	 * sets the image to the string in the parameters
	 *
	 */
	public void setImage(String X)
	{
		try {
			img = ImageIO.read(new File(X));
		} catch (IOException ex) {}
	}
	
	/**
	 * intersects()
	 * @param int x,y,w,h
	 * @return boolean
	 * returns true if object is inside another object's border (if it intersects), false if it is not
	 *
	 */
	public boolean intersects(int x, int y, int w, int h)
	{
		if ((getX()>x) && (getX()<(x+w)) && (getY()>y) && (getY()<(y+h)))
		{
			return true;
		}
		return false;
	} 
	
	/**
	 * getX()
	 * @param none
	 * @return xpos
	 * returns an objects x position
	 *
	 */
	public int getX()
	{
		return xpos;
	}
	
	/**
	 * getY()
	 * @param none
	 * @return ypos
	 * returns an objects y position
	 *
	 */
	public int getY()
	{
		return ypos;
	}
	
	/**
	 * setY()
	 * @param int y
	 * @return none
	 * sets an objects y position
	 *
	 */
	public void setY(int y)
	{
		ypos = y;
	}
	
	/**
	 * setX()
	 * @param int x
	 * @return none
	 * sets an objects x position
	 *
	 */
	public void setX(int x)
	{
		xpos = x;
	}
	
	/**
	 * getDistance()
	 * @param none
	 * @return distance
	 * returns an objects distance
	 *
	 */
	public int getDistance()
	{
		return distance;
	}
	
	/**
	 * getSpeed()
	 * @param none
	 * @return speed
	 * returns an objects speed
	 *
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/**
	 * getHeight()
	 * @param none
	 * @return height
	 * returns an objects height
	 *
	 */
	public int getHeight()
	{
		return getHeight;
	}
	
	/**
	 * setWidth()
	 * @param int w
	 * @return none
	 * sets an objects width
	 *
	 */
	public void setWidth(int w)
	{
		getWidth = w;
	}
	
	/**
	 * setHeight()
	 * @param int h
	 * @return none
	 * sets an objects height
	 *
	 */
	public void setHeight(int h)
	{
		getHeight = h;
	}
	
	/**
	 * getWidth()
	 * @param none
	 * @return xpos
	 * returns an objects width
	 *
	 */
	public int getWidth()
	{
		return getWidth;
	}
	
	public void move() {};
	
	public void paint(Graphics g) {};

}
