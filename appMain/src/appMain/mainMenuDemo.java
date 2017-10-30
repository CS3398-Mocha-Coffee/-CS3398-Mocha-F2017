/*Main Menu Demo: This is just a demo of a vanilla main menu for us to build 
 * on for future use.  This will be a main menu with a title banner, four buttons
 * one for recipe and one for pantry.  There will also be a button for the login,
 * and one for the exit.  None of the buttons except for the exit will be functional.
 * I will clean up the main and pull some of the classes outside the main in the 
 * next go around.
 * 
 * Main Menu 1.1) I have added to separate frames for the pantry menu and 
 * the recipe menu.  I will be make these frames mores visually pleasing in the 
 * next revision.
 */

package appMain;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class mainMenuDemo extends JFrame {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	private JLabel greetingL;
	private JButton recipeB, pantryB, loginB, exitB;
	
	//Button handlers: only dealing with the exit one now
	private ExitButtonHandler ebHandler;
	private RecipeButtonHandler rbHandler;
	private PantryButtonHandler pbHandler;
	
	public mainMenuDemo() {
		getContentPane().setBackground(new Color(30, 144, 255));
		setBackground(Color.LIGHT_GRAY);
		//Instantiate the label or greeting
		greetingL = new JLabel("***Welcome to Pantry Partner***", SwingConstants.CENTER);
		greetingL.setBackground(new Color(105, 105, 105));
		greetingL.setFont(new Font("Arial Narrow", Font.BOLD, 26));
		
		
		//Buttons:
		recipeB = new JButton("RECIPES");
		recipeB.setForeground(new Color(0, 0, 0));
		recipeB.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		recipeB.setBackground(new Color(128, 128, 128));
		rbHandler = new RecipeButtonHandler();
		recipeB.addActionListener(rbHandler);
		
		pantryB = new JButton("PANTRY");
		pantryB.setForeground(new Color(0, 0, 0));
		pantryB.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		pantryB.setBackground(new Color(128, 128, 128));
		pbHandler = new PantryButtonHandler();
		pantryB.addActionListener(pbHandler);
		
		loginB = new JButton("Login");
		loginB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		loginB.setBackground(new Color(0, 0, 0));
		
		exitB = new JButton("EXIT");
		exitB.setForeground(new Color(0, 0, 0));
		exitB.setBackground(new Color(128, 128, 128));
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);
		
		
		setTitle("Pantry Partner");		
		Container pane = getContentPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(652)
					.addComponent(loginB, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(275)
					.addComponent(exitB, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(recipeB, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(pantryB, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addComponent(greetingL, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(loginB, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(greetingL, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(recipeB, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantryB, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGap(22)
					.addComponent(exitB, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		getContentPane().setLayout(groupLayout);
		
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}//end of mainMenuDemo
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Class: ExitButtonHandler
	public class ExitButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}		
	}//end of ExitButtonHandler
	
	//Class: RecipeButtonHandler
		public class RecipeButtonHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				recipeMenu recipeObj = new recipeMenu();
			}		
		}//end of RecipeButtonHandler
		
		
	//Class: PantryButtonHandler
		public class PantryButtonHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				pantryMenu pantryObj = new pantryMenu();
			}		
		}//end of PantryButtonHandler	
   
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
	//Class: Main
	public static void main(String[] args) {
		mainMenuDemo mainObj = new mainMenuDemo();
	}
	
}//end of DEMO