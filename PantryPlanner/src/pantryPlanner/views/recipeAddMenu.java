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
	private JTextField tf_ingredients;
	private JTextField tf_directions;
	private JButton b_AddInfo;
	private JButton b_AddIngr;
	private JButton b_AddDir;
	private JRadioButton rdb_Breakfast;
	private JRadioButton rdb_Lunch;
	private JRadioButton rdb_Dinner;
	private JRadioButton rdb_Any;
	private ButtonGroup b_group;
	//add variables
	private String category;
	private String v_cookTime;
	private String v_prepTime;
	private String v_recipeName;
	private String v_ingredients;
	private String v_directions;

	


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
		setBounds(100, 100, 702, 358);
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
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel l_Directions = new JLabel("DIRECTIONS");
		l_Directions.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JRadioButton rdb_Breakfast = new JRadioButton("Breakfast");

		rdb_Breakfast.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JRadioButton rdb_Dinner = new JRadioButton("Dinner");

		rdb_Dinner.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JRadioButton rdb_Lunch = new JRadioButton("Lunch");

		rdb_Lunch.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JRadioButton rdb_Any = new JRadioButton("Any");

		rdb_Any.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		tf_ingredients = new JTextField();
		tf_ingredients.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tf_ingredients.setColumns(10);
		
		tf_directions = new JTextField();
		tf_directions.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tf_directions.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(l_Ingredents)
									.addGap(12)
									.addComponent(tf_ingredients, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
									.addComponent(b_AddIngr, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(b_AddInfo, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(l_PrepTime, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(tf_prepTime, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(l_CookTime)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(tf_cookTime, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(l_RecipeName)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tf_recipeName, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(l_Category)
								.addGap(76)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(rdb_Breakfast)
									.addComponent(rdb_Dinner, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
								.addGap(46)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(rdb_Any, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addComponent(rdb_Lunch, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
						.addComponent(separator_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(l_Directions, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tf_directions, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
							.addComponent(b_AddDir, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
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
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(b_AddInfo)
							.addComponent(rdb_Dinner, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdb_Any, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(l_Ingredents, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(27))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tf_ingredients, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(b_AddIngr))
							.addGap(18)))
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(l_Directions, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addComponent(tf_directions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(b_AddDir))
					.addGap(305))
		);
		b_group = new ButtonGroup();
		b_group.add(rdb_Breakfast);
		b_group.add(rdb_Lunch);
		b_group.add(rdb_Dinner);
		b_group.add(rdb_Any);
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
				v_recipeName = tf_recipeName.getText();
				v_cookTime = tf_cookTime.getText();
				v_prepTime = tf_prepTime.getText();
				tf_recipeName.setText("");
				tf_cookTime.setText("");
				tf_prepTime.setText("");
				b_group.clearSelection();
			}
		});
		
		b_AddIngr.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add methods
				v_ingredients = tf_ingredients.getText();
				tf_ingredients.setText("");				
				
			}
		});
		
		b_AddDir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add methods
				v_directions = tf_directions.getText();
				tf_directions.setText("");
			}
		});
		
		//action listener for radio buttons here
		//want to set a variable that will be passed to add function to the desired category
		rdb_Breakfast.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
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

	


