package pantryPlanner.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import pantryPlanner.common.IDatabase;
import pantryPlanner.common.Inventory;
import pantryPlanner.common.Open;
import pantryPlanner.common.Output;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class pantryMenu extends JFrame {

	private JPanel ctpPantry;
	private JButton b_changeQ;
	private JButton b_display;
	private JButton b_shoppingList;
	private JButton b_return;
	public static Inventory pantry;
	String myTest = "This is a test";
	private static final String CSV_FILE = "/Users/ajmor/eclipse-workspace/PantryPlanner/src/pantryPlanner/databases/ingredients.csv";
	private final String PANTRY_CSV = "/Users/ajmor/eclipse-workspace/PantryPlanner/src/pantryPlanner/databases/ingredients.csv";

	/**
	 * Create the pantryMenu frame.
	 * @throws Exception 
	 */
	public pantryMenu() throws Exception 
	{
		initComponentsPantry();
		createEventsPantry();
		IDatabase data = new IDatabase(CSV_FILE);
		pantry = new Inventory(data.getDatabase());
		pantry.putAll(Open.restore(PANTRY_CSV));
		//ArrayList<String> test = new ArrayList<String>();
		//test.add(myTest);
	}
	
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // initComponentsPantry: has all code for creating and initializing components
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void initComponentsPantry() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantryMenu.class.getResource("/pantryPlanner/resources/recipe32.png")));
		setTitle("PANTRY MENU");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ctpPantry = new JPanel();
		ctpPantry.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(ctpPantry);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(pantryMenu.class.getResource("/pantryPlanner/resources/pantry128.png")));
		
		//button block
		b_changeQ = new JButton("UPDATE QTY.");
		b_changeQ.setBorder(null);		
		b_shoppingList = new JButton("SHOPPING LIST");
		b_display = new JButton("DISPLAY ");		
		b_return = new JButton("RETURN");

		GroupLayout gl_ctpPantry = new GroupLayout(ctpPantry);
		gl_ctpPantry.setHorizontalGroup(
			gl_ctpPantry.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpPantry.createSequentialGroup()
					.addGroup(gl_ctpPantry.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpPantry.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_ctpPantry.createParallelGroup(Alignment.LEADING)
								.addComponent(b_changeQ, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(b_shoppingList))
							.addGap(46)
							.addGroup(gl_ctpPantry.createParallelGroup(Alignment.LEADING, false)
								.addComponent(b_return, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(b_display, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
						.addGroup(gl_ctpPantry.createSequentialGroup()
							.addGap(143)
							.addComponent(lblNewLabel)))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_ctpPantry.setVerticalGroup(
			gl_ctpPantry.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_ctpPantry.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_ctpPantry.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_ctpPantry.createSequentialGroup()
							.addComponent(b_display)
							.addGap(18)
							.addComponent(b_return))
						.addGroup(gl_ctpPantry.createSequentialGroup()
							.addComponent(b_changeQ, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(b_shoppingList)))
					.addContainerGap())
		);
		ctpPantry.setLayout(gl_ctpPantry);
		setVisible(true);
		
	}


	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// createEventsPantry: has all action listeners for creating events
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void createEventsPantry() 
	{
		b_return.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add exit functions here
				//Exit.save(pantry, PANTRY_CSV);
				//
				dispose();
			}
		});
		/*
		 * integrate display function here
		 */
		b_display.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				///add in display here; call display function
				//JOptionPane.showMessageDialog(null, "PANTRY WILL BE DISPLAYED HERE!!!\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n*******************************8***");
				String pantryContents = pantry.listIngredients();
				Output.write(pantry.listIngredients());
			}
		});
		/*
		 * Display shopping list here function here
		 */
		b_shoppingList.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"Shopping list will be integrated here!!!");
				//for right now this is commented out to try something new
				//pantryEditMenu menuObj = new pantryEditMenu();
			}
		});
		/*
		 * integrate add/remove function here
		 */
		b_changeQ.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pantryAddMenu menuObj = new pantryAddMenu();
			}
		});

	}

}//end pantryMenu
