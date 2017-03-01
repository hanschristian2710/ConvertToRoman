// Some useful libraries
import uwcse.graphics.*;
import uwcse.io.*;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;

/**
 * CSC 142 - Homework<br>
 * A RomanNumber is the representation in decimal and Roman numerals of an
 * integer between 1 and 3000.<br>
 * The number is displayed in a graphics window.<br>
 * A RomanNumber can be incremented, decremented or changed via interactive
 * input.
 * 
 * @author Hans Christian
 */

public class RomanNumber {

	/** Maximum number that can be displayed */
	public static final int MAX_NUMBER = 3000;

	// instance fields
	private TextShape text, dummy; // The label to display the number (center it
									// in the

	// window)

	private Font font; // Font used to display the number

	private GWindow window; // the window this RomanNumber belongs to

	private String sNumber; // The text to write in the TextShape (e.g. 18 =

	// XVIII)

	private int dNumber; // the number to display

	// for the input
	private Input in = new Input();

	// an int to find
	private int n1000, n100, n10, n1;

	/**
	 * Creates the display of a number in Roman numerals in a given graphics
	 * window.<br>
	 * The number is given via interactive input by the user
	 * 
	 * @param window
	 *            the graphics window that displays the roman number.
	 */
	public RomanNumber(GWindow window) {

		// This RomanNumber is displayed in the GWindow window
		this.window = window;

		// Create the font for the TextShape
		font = new Font("Courier", Font.BOLD, 40);

		text = new TextShape("", 100, 20, Color.WHITE, font);
		window.add(text);

		// Create a dummy textshape of one character
		// to know the size of one character
		// at (-100, -100) so that it is not visible
		dummy = new TextShape("A", -100, -100, Color.WHITE, font);
		window.add(dummy);

		// Ask for the number and display it
		// (to do so, you might want to call other methods in the class)
		inputNewNumber();
	}

	/**
	 * Changes this RomanNumber to the new value given interactively by the
	 * user.<br>
	 * If the value given by the user is invalid, display an error message and
	 * don't change the display.
	 */
	public void inputNewNumber() {

		// asking input from user
		int n = in.readIntDialog("Enter a number between 1 and " + MAX_NUMBER);

		// ifs conditional, give warning to the user when they enter <= 0
		// and > 3000 (max number)
		if (n <= 0 || n > MAX_NUMBER) {
			JOptionPane.showMessageDialog(null, "Invalid value = " + n,
					"Input error", JOptionPane.WARNING_MESSAGE);
		} else {
			// valid input
			dNumber = n;

			// initilaize the sNumber
			sNumber = "";
			// converting the integer input by the user to roman number
			n1000 = (dNumber / 1000);
			n100 = (dNumber / 100) % 10;
			n10 = (dNumber / 10) % 10;
			n1 = (dNumber % 10);
			toRoman(n1000, 'M', ' ', ' ');
			toRoman(n100, 'C', 'D', 'M');
			toRoman(n10, 'X', 'L', 'C');
			toRoman(n1, 'I', 'V', 'X');

			// display dNumber = dNumber in roman numeral
			String s = dNumber + " = " + sNumber;
			text.setText(s);

			// size of the text shape
			int width = dummy.getWidth() * s.length();
			text.moveTo(window.getWindowWidth() / 2 - width / 2, text.getY());
		}
	}

	/**
	 * 
	 * @param n
	 *            takes the integer value
	 * @param one
	 *            takes the assigned value for one
	 * @param five
	 *            takes the assigned value for five
	 * @param ten
	 *            takes the assigned value for ten
	 * @return the value of sNumber
	 */
	public String toRoman(int n, char one, char five, char ten) {

		// ifs conditional to convert to roman number
		if (n == 1) {
			sNumber += one;
		} else if (n == 2) {
			sNumber += one;
			sNumber += one;
		} else if (n == 3) {
			sNumber += one;
			sNumber += one;
			sNumber += one;
		} else if (n == 4) {
			sNumber += one;
			sNumber += five;
		} else if (n == 5) {
			sNumber += five;
		} else if (n == 6) {
			sNumber += five;
			sNumber += one;
		} else if (n == 7) {
			sNumber += five;
			sNumber += one;
			sNumber += one;
		} else if (n == 8) {
			sNumber += five;
			sNumber += one;
			sNumber += one;
			sNumber += one;
		} else if (n == 9) {
			sNumber += one;
			sNumber += ten;
		} else if (n == 10) {
			sNumber += ten;
		}
		// return the roman number
		return sNumber;
	}

	/**
	 * Adds one to this RomanNumber (if < MAX_NUMBER).
	 * 
	 * @return
	 */
	public void plusOne() {

		// ifs conditional, which will be added one if less than 3000 (max
		// number)
		if (dNumber < MAX_NUMBER) {
			// plus one in dNumber
			dNumber += 1;

			// initilaize the sNumber,
			// so that it is not added up
			sNumber = "";

			// converting the integer input by the user to roman number
			n1000 = (dNumber / 1000);
			n100 = (dNumber / 100) % 10;
			n10 = (dNumber / 10) % 10;
			n1 = (dNumber % 10);
			toRoman(n1000, 'M', ' ', ' ');
			toRoman(n100, 'C', 'D', 'M');
			toRoman(n10, 'X', 'L', 'C');
			toRoman(n1, 'I', 'V', 'X');

			// display dNumber = dNumber in roman numeral
			String s = dNumber + " = " + sNumber;
			text.setText(s);

			// size of the text shape
			int width = dummy.getWidth() * s.length();
			text.moveTo(window.getWindowWidth() / 2 - width / 2, text.getY());
		}
	}

	/**
	 * Subtracts one from this RomanNumber (if > 1)
	 */
	public void minusOne() {

		// ifs conditional, which will be subtracted if the number is > 1
		if (dNumber > 1) {
			// minus one in dNumber
			dNumber -= 1;

			// initilaize the sNumber
			// so that it is not added up
			sNumber = "";

			// converting the integer input by the user to roman number
			n1000 = (dNumber / 1000);
			n100 = (dNumber / 100) % 10;
			n10 = (dNumber / 10) % 10;
			n1 = (dNumber % 10);
			toRoman(n1000, 'M', ' ', ' ');
			toRoman(n100, 'C', 'D', 'M');
			toRoman(n10, 'X', 'L', 'C');
			toRoman(n1, 'I', 'V', 'X');

			// display dNumber = dNumber in roman numeral
			String s = dNumber + " = " + sNumber;
			text.setText(s);

			// size of the text shape
			int width = dummy.getWidth() * s.length();
			text.moveTo(window.getWindowWidth() / 2 - width / 2, text.getY());
		}

	}

}
