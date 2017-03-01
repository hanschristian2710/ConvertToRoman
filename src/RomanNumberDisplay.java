// Some useful libraries
import uwcse.graphics.*;

import java.awt.Color; // avoid writing java.awt.* since the package has a
// class called Rectangle, which is a name also used
// in uwcse.graphics
import java.awt.Font;

/**
 * CSC 142 - Homework<br>
 * A RomanNumberDisplay has a window that can display a RomanNumber.<br>
 * Buttons allow the user to enter a new number to display, or to add 1 to or
 * subtract 1 from the current number.<br>
 * 
 * @author Hans Christian
 */

public class RomanNumberDisplay extends GWindowEventAdapter {
	
	// By extending GWindowEventAdapter, a RomanNumberDisplay can
	// respond to mouse clicks on a graphics window.

	// Instance fields
	// Graphics window
	private GWindow window;

	// The RomanNumber being displayed
	private RomanNumber rNumber;

	// Add here other instance fields as needed
	private Rectangle inputNewNumber, minusOne, plusOne, background;

	/**
	 * Create the display
	 */
	public RomanNumberDisplay() {
		
		// Create the window (change the size if you wish)
		window = new GWindow("Numbers in roman numerals", 690, 200);
		background = new Rectangle(0, 0, window.getWindowWidth(),
				window.getWindowHeight(), Color.GRAY, true);
		window.add(background);
		window.setExitOnClose();
		
		// This RomanNumberDisplay handles the mouse clicks
		window.addEventHandler(this);
		
		// Buttons...
		// If you find yourself writing lots of line of code in the constructor,
		// move the code into a private method that you call from here.
		// call the drawButton method 
		drawButton();
		
		// Add the RomanNumber rNumber...
		rNumber = new RomanNumber(window);
	}

	/**
	 * A mouse button has been pressed on the window.<br>
	 * Detects the location of the click and take proper action (do nothing or
	 * increment or decrement the number, or input and display a new number).
	 * 
	 * @param e
	 *            the GWindowEvent triggered by the mouse click
	 */
	public void mousePressed(GWindowEvent e) {
		
		// Locate the click
		int x = e.getX();
		int y = e.getY();

		// ifs statement when the user click the box
		if (x >= plusOne.getX() && x <= plusOne.getX() + plusOne.getWidth()
				&& y >= plusOne.getY()
				&& y <= plusOne.getY() + plusOne.getHeight()) {

			rNumber.plusOne();

		} else if (x >= minusOne.getX()
				&& x <= minusOne.getX() + minusOne.getWidth()
				&& y >= minusOne.getY()
				&& y <= minusOne.getY() + minusOne.getHeight()) {

			rNumber.minusOne();

		} else if (x >= inputNewNumber.getX()
				&& x <= inputNewNumber.getX() + inputNewNumber.getWidth()
				&& y >= inputNewNumber.getY()
				&& y <= inputNewNumber.getY() + inputNewNumber.getHeight()) {

			rNumber.inputNewNumber();
		}
		// If you need to update the display, use the method doRepaint() as in
		// window.doRepaint();
	}

	/**
	 * Starts the application
	 */
	public static void main(String[] args) {
		new RomanNumberDisplay();
	}

	// Add your private methods here
	/**
	 * to draw the 3 buttons for the user, plus one, minus one and new input
	 */
	private void drawButton() {

		plusOne = new Rectangle(50, 150, 150, 40, Color.DARK_GRAY, true);
		TextShape t1 = new TextShape("PLUS ONE", 80, 161, Color.PINK, new Font(
				"Times New Roman", Font.BOLD, 18));
		window.add(plusOne);
		window.add(t1);
		minusOne = new Rectangle(250, 150, 150, 40, Color.DARK_GRAY, true);
		TextShape t2 = new TextShape("MINUS ONE", 274, 161, Color.PINK,
				new Font("Times New Roman", Font.BOLD, 18));
		window.add(minusOne);
		window.add(t2);
		inputNewNumber = new Rectangle(450, 150, 150, 40, Color.DARK_GRAY, true);
		TextShape t3 = new TextShape("NEW NUMBER", 462, 161, Color.PINK,
				new Font("Times New Roman", Font.BOLD, 18));
		window.add(inputNewNumber);
		window.add(t3);

	}

}
