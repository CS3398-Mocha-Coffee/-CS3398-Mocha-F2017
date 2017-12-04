package pantryPlanner.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pantryPlanner.common.IDatabase;
import pantryPlanner.common.Inventory;
import pantryPlanner.common.Open;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pantryAddMenu extends JFrame 
{

	private static final String CENTER = null;

	private JPanel contentPane;
	private JTextField tf_quantity;
	private JButton b_submit;
	private JTextField tf_item;
	public static Inventory pantry;
	private static final String CSV_FILE = "/Users/ajmor/eclipse-workspace/PantryPlanner/src/pantryPlanner/databases/ingredients.csv";
	private final String PANTRY_CSV = "/Users/ajmor/eclipse-workspace/PantryPlanner/src/pantryPlanner/databases/pantry.csv";


	private String v_itemName;
	private String v_qty;
	
	/**
	 * Create the frame.
	 */
	public pantryAddMenu() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantryAddMenu.class.getResource("/pantryPlanner/resources/recipe32.png")));
		setTitle("UPDATE QTY");

		initComponentsAdd();
		createEventsAdd();
		
		
	}
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // initComponentsPantry: has all code for creating and initializing components
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void initComponentsAdd()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblQuanty = new JLabel("");
		lblQuanty.setIcon(new ImageIcon(pantryAddMenu.class.getResource("/pantryPlanner/resources/recipe128.png")));
		lblQuanty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Select pantry item to update");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel l_enterQ = new JLabel("Enter Quantity:");
		l_enterQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_quantity = new JTextField();
		tf_quantity.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tf_quantity.setColumns(10);
		
		//button block
		b_submit = new JButton("SUBMIT");
		
		JLabel l_enterItem = new JLabel("Enter Item Name:");
		l_enterItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tf_item = new JTextField();
		tf_item.setColumns(10);
		tf_item.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		//trying to adjust alignment here
		//cb_itemGroup.setAlignmentX(CENTER);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(lblQuanty))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(b_submit)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(l_enterQ)
											.addComponent(l_enterItem, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(tf_item, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
											.addComponent(tf_quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addComponent(lblNewLabel)))))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblQuanty)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(l_enterItem, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(l_enterQ))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tf_item, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tf_quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(b_submit)
					.addGap(31))
		);
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// createEventsPantry: has all action listeners for creating events
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void createEventsAdd() 
	{
		b_submit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//add in actions for updating quantity
				
	
				v_itemName = tf_item.getText();
				v_qty = tf_quantity.getText();
				//pantry.add(v_itemName, v_qty);
				tf_item.setText("");
				tf_quantity.setText("");
			}
		});
		
	}
}
