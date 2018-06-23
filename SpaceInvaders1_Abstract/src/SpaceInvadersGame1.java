
	/**InvadersTester
	 * 
	 * This class initializes a Board, 
	 * allowing the SpaceInvaders game to 
	 * be tested. Extends JFrame.
	 * 
	 * @author Mr. Beadon 
	 * June 4th, 2015
	 *
	 */
	 
	 
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * SpaceInvadersGame1
 * @param none
 * @return none
 * what it does
 *
 */
public class SpaceInvadersGame1 extends JFrame 
{

	private Dimension D;

		/**
		 * SpaceInvadersGame1()
		 * @param none
		 * @return none
		 * Initializes a Board with a JPanel reference,
		 * adds it to this InvadersTester object,
		 * and applies appropriate dimensions
		 * to the JPanel and InvadersTester object
		 * 
		 */
		public SpaceInvadersGame1()
		{

			setTitle("Press 'Q' or '3'");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new FlowLayout());
			
			JPanel b = new Board();//

			D = new Dimension(1200, 800); 
			// +30 to adjust for added height at top of screen

			b.setPreferredSize(D);

			add(b);
			setSize(D);
			setVisible(true); 

		}


		/**
		 * 
		 * main
		 * @param args
		 * @return none
		 * creates a new space invaders game
		 * 
		 */
		public static void main(String args[])
		{
			new SpaceInvadersGame1();
		}

}
