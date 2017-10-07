/*Main Menu Demo: This is just a demo of a vanilla main menu for us to build 
 * on for future use.  This will be a main menu with a title banner, four buttons
 * one for recipe and one for pantry.  There will also be a button for the login,
 * and one for the exit.  None of the buttons except for the exit will be functional.
 * I will clean up the main and pull some of the classes outside the main in the 
 * next go around.
 */

package appMain;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class mainMenuDemo extends JFrame {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	private JLabel greetingL;
	private JButton recipeB, pantryB, loginB, exitB;
	
	//Button handlers: only dealing with the exit one now
	private ExitButtonHandler ebHandler;
	
	public mainMenuDemo() {
		//Instantiate the label or greeting
		greetingL = new JLabel("***Welcome to Pantry Partner***", SwingConstants.CENTER);
		
		
		//Buttons:
		recipeB = new JButton("RECIPES");
		pantryB = new JButton("PANTRY");
		loginB = new JButton("Login");
		exitB = new JButton("EXIT");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);
		
		
		setTitle("Pantry Partner");		
		Container pane = getContentPane();		
		pane.setLayout(new GridLayout(5,4));
		
		//Add things to the pane in the order you want them to appear
		pane.add(greetingL);
		pane.add(loginB);
		pane.add(recipeB);
		pane.add(pantryB);		
		pane.add(exitB);
		
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}//end of mainMenuDemo
	
	//Class: ExitButtonHandler
	public class ExitButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}		
	}//end of ExitButtonHandler
	
	//Class: Main
	public static void main(String[] args) {
		mainMenuDemo mainObj = new mainMenuDemo();
	}
	
}//end of DEMO