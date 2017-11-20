package pantryPlanner.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
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

public class recipeAddMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


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
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("RECIPE NAME");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setColumns(10);
		
		JLabel lblCookTimemin = new JLabel("COOK TIME (min)");
		lblCookTimemin.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setColumns(10);
		
		JLabel lblPrepTimemin = new JLabel("PREP TIME (min)");
		lblPrepTimemin.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_2.setColumns(10);
		
		JLabel lblTotalTimemin = new JLabel("TOTAL TIME (min)");
		lblTotalTimemin.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		textField_3 = new JTextField();
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_3.setColumns(10);
		
		JLabel lblCategory = new JLabel("CATEGORY");
		lblCategory.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnAdd = new JButton("ADD");
		
		JSeparator separator = new JSeparator();
		
		JLabel lblIngredents = new JLabel("INGREDIENTS");
		lblIngredents.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblDirections = new JLabel("DIRECTIONS");
		lblDirections.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton button = new JButton("ADD");
		
		JButton button_1 = new JButton("ADD");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(recipeAddMenu.class.getResource("/pantryPlanner/resources/coveredFoodTray32.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblIngredents)
									.addGap(18)
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(lblCategory)
										.addGap(18)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(303)
										.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
									.addComponent(separator, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)))
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblCookTimemin)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblPrepTimemin, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblTotalTimemin)
									.addGap(10)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(29))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addComponent(lblDirections, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(580, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(580, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCookTimemin, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrepTimemin, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotalTimemin, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIngredents, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button)
					.addGap(8)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDirections, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_1)
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
		
	}
}//end recipeAddMenu

	


