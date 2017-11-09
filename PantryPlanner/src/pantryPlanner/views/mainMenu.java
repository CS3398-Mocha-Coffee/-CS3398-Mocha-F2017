package pantryPlanner.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class mainMenu extends JFrame 
{

	private JPanel ctpMain;
	private JButton b_recipes;
	private JButton b_pantry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					mainMenu frame = new mainMenu();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}//end main

	/**
	 * Create the mainMenu frame.
	 */
	public mainMenu() 
	{
		initComponents();
		createEvents();		
	}
	
    //////////////////////////////////////////////////////////////////////////
    // initComponents: has all code for creating and initializing components
    //////////////////////////////////////////////////////////////////////////
    private void initComponents() 
    {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mainMenu.class.getResource("/pantryPlanner/resources/recipe32.png")));
		setFont(new Font("Dubai", Font.PLAIN, 12));
		setTitle("PANTRY PLANNER");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ctpMain = new JPanel();
		ctpMain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(ctpMain);
		
		b_recipes = new JButton("RECIPES");

		
		b_pantry = new JButton("PANTRY");

		
		JLabel l_MainGreeting = new JLabel("Welcome to \r\nPantry Planner");
		l_MainGreeting.setFont(new Font("Dubai", Font.BOLD, 18));
		l_MainGreeting.setIcon(new ImageIcon(mainMenu.class.getResource("/pantryPlanner/resources/coveredFoodTrayGreen128.png")));
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGap(47)
					.addComponent(b_recipes, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
					.addComponent(b_pantry, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGap(38)
					.addComponent(l_MainGreeting, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addContainerGap()
					.addComponent(l_MainGreeting, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(b_recipes, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(b_pantry))
					.addContainerGap())
		);
		ctpMain.setLayout(gl_ctpMain);

    }



	//////////////////////////////////////////////////////////////////////////
	// createEvents: has all code for creating events
    //////////////////////////////////////////////////////////////////////////
	private void createEvents() 
	{
		b_recipes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				recipeMenu recipeObj = new recipeMenu();
			}
		});
		
		b_pantry.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pantryMenu pantryObj = new pantryMenu();
			}
		});
		
	}
}//end class mainMenu
   
