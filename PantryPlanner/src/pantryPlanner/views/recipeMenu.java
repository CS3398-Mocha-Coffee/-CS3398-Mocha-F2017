package pantryPlanner.views;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

public class recipeMenu extends JFrame 
{

	private JPanel ctpRecipe;
	private JButton b_add;
	private JButton b_remove;
	private JButton b_search;
	private JButton b_return;



	/**
	 * Create the recipeMenu frame.
	 */
	public recipeMenu() 
	{
		initComponentsRecipe();
		createEventsRecipe();
	}

    //////////////////////////////////////////////////////////////////////////
    // initComponents: has all code for creating and initializing components
    //////////////////////////////////////////////////////////////////////////
	private void initComponentsRecipe() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(recipeMenu.class.getResource("/pantryPlanner/resources/recipe32.png")));
		setTitle("RECIPE MENU");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ctpRecipe = new JPanel();
		ctpRecipe.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(ctpRecipe);
		
		JLabel l_RecipeGreeting = new JLabel("");
		l_RecipeGreeting.setIcon(new ImageIcon(recipeMenu.class.getResource("/pantryPlanner/resources/recipeBook128.png")));
		
		//button block
		b_add = new JButton("ADD RECIPE");		

		b_remove = new JButton("REMOVE RECIPE");		

		b_search = new JButton(" SEARCH RECIPE");		

		b_return = new JButton("RETURN");

		GroupLayout gl_ctpRecipe = new GroupLayout(ctpRecipe);
		gl_ctpRecipe.setHorizontalGroup(
			gl_ctpRecipe.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpRecipe.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addComponent(l_RecipeGreeting, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(141))
				.addGroup(gl_ctpRecipe.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_ctpRecipe.createParallelGroup(Alignment.LEADING, false)
						.addComponent(b_add, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(b_remove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addGroup(gl_ctpRecipe.createParallelGroup(Alignment.LEADING, false)
						.addComponent(b_search, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(b_return, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_ctpRecipe.setVerticalGroup(
			gl_ctpRecipe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpRecipe.createSequentialGroup()
					.addContainerGap()
					.addComponent(l_RecipeGreeting)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_ctpRecipe.createParallelGroup(Alignment.BASELINE)
						.addComponent(b_add)
						.addComponent(b_search))
					.addGap(18)
					.addGroup(gl_ctpRecipe.createParallelGroup(Alignment.BASELINE)
						.addComponent(b_remove)
						.addComponent(b_return))
					.addContainerGap())
		);
		ctpRecipe.setLayout(gl_ctpRecipe);
		setVisible(true);
		
	}	
	
	//////////////////////////////////////////////////////////////////////////
	// createEvents: has all action listeners for creating events
    //////////////////////////////////////////////////////////////////////////
	private void createEventsRecipe() 
	{
		b_return.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		/*
		 * integrate search function here
		 */
		b_search.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new RecipeSearchView("Custom Recipe Search");
			}
		});
		/*
		 * integrate remove function here
		 */
		b_remove.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		/*
		 * integrate add function here
		 */
		b_add.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				recipeAddMenu addObject = new recipeAddMenu();
			}
		});
		
	}
}// end class recipeMenu
