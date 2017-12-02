package pantryPlanner.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class recipeAddMenu extends JFrame {

	private JPanel contentPane;
	private JTextArea ta_ingredients;
	private JTextArea ta_directions;
	private JTextField tf_recipeName;
	private JTextField tf_cookTime;
	private JTextField tf_prepTime;
	private JButton b_AddInfo;
	private JButton b_AddIngr;
	private JButton b_AddDir;
	private JRadioButton rdb_Breakfast;
	private JRadioButton rdb_Lunch;
	private JRadioButton rdb_Dinner;
	private JRadioButton rdb_Any;
	private ButtonGroup group;
	private String category;


	/**
	 * Create the frame.
	 */
	public recipeAddMenu() {

		initComponentsAdd();
		createEventsAdd();
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // initComponentsPantry: has all code for creating and initializing components
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void initComponentsAdd()
	{
		setFont(new Font("Dubai", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(recipeAddMenu.class.getResource("/pantryPlanner/resources/recipe32.png")));
		setTitle("ADD RECIPE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel l_RecipeName = new JLabel("RECIPE NAME");
		l_RecipeName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		tf_recipeName = new JTextField();
		tf_recipeName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tf_recipeName.setColumns(10);
		
		JLabel l_CookTime = new JLabel("COOK TIME (min)");
		l_CookTime.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		tf_cookTime = new JTextField();
		tf_cookTime.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tf_cookTime.setColumns(10);
		
		JLabel l_PrepTime = new JLabel("PREP TIME (min)");
		l_PrepTime.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		tf_prepTime = new JTextField();
		tf_prepTime.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tf_prepTime.setColumns(10);
		
		JLabel l_Category = new JLabel("CATEGORY");
		l_Category.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//button block
		b_AddInfo = new JButton("ADD");
		b_AddIngr = new JButton("ADD");
		b_AddDir = new JButton("ADD");

		
		JSeparator separator = new JSeparator();
		
		JLabel l_Ingredents = new JLabel("INGREDIENTS");
		l_Ingredents.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JTextArea ta_ingredients = new JTextArea();
		ta_ingredients.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel l_Directions = new JLabel("DIRECTIONS");
		l_Directions.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JTextArea ta_directions = new JTextArea();
		ta_directions.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JRadioButton rdb_Breakfast = new JRadioButton("Breakfast");

		rdb_Breakfast.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JRadioButton rdb_Dinner = new JRadioButton("Dinner");

		rdb_Dinner.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JRadioButton rdb_Lunch = new JRadioButton("Lunch");

		rdb_Lunch.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JRadioButton rdb_Any = new JRadioButton("Any");

		rdb_Any.setFont(new Font("SansSerif", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(l_Ingredents)
									.addGap(18)
									.addComponent(ta_ingredients, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(b_AddInfo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(l_PrepTime, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(tf_prepTime, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(l_CookTime)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(tf_cookTime, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(l_RecipeName)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(tf_recipeName, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(l_Category)
									.addGap(76)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(rdb_Breakfast)
										.addComponent(rdb_Dinner, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
									.addGap(46)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(rdb_Any, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdb_Lunch, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(240, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(l_Directions, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ta_directions, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(583, Short.MAX_VALUE)
					.addComponent(b_AddIngr, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(583, Short.MAX_VALUE)
					.addComponent(b_AddDir, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		group = new ButtonGroup();
		group.add(rdb_Breakfast);
		group.add(rdb_Lunch);
		group.add(rdb_Dinner);
		group.add(rdb_Any);
		
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(l_RecipeName)
								.addComponent(tf_recipeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(l_Category, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdb_Breakfast)
								.addComponent(rdb_Lunch, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(l_CookTime, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_cookTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(l_PrepTime, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_prepTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(b_AddInfo)
								.addComponent(rdb_Dinner, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(rdb_Any, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(l_Ingredents, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(ta_ingredients, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(b_AddIngr)
					.addGap(8)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(l_Directions, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(ta_directions, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(b_AddDir)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// createEventsPantry: has all action listeners for creating events
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void createEventsAdd() 
	{
		b_AddInfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//add methods
				tf_recipeName.setText("");
				tf_cookTime.setText("");
				tf_prepTime.setText("");
				group.clearSelection();
			}
		});
		
		b_AddIngr.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add methods
				//ta_ingredients.setText("");
				
			}
		});
		
		b_AddDir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add methods
				//ta_directions.setText("");
			}
		});
		
		//action listener for radio buttons here
		//want to set a variable that will be passed to add function to the desired category
		rdb_Breakfast.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				category = "breakfast";
			}
		});
		
		rdb_Lunch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				category = "lunch";
			}
		});
		
		rdb_Dinner.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				category = "dinner";
			}
		});
		
		rdb_Any.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				category = "any";
			}
		});

		
	}
}//end recipeAddMenu

	


