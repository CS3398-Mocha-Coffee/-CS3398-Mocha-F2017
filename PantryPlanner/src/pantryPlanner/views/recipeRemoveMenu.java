package pantryPlanner.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class recipeRemoveMenu extends JFrame 
{
	private JPanel contentPane;	
	private JTextField textField;
	private JButton b_Find;

	/**
	 * Create the frame.
	 */
	public recipeRemoveMenu() 
	{

		initComponetsRemove();
		createEventsRemove();

	}
	
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // initComponentsPantry: has all code for creating and initializing components
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void initComponetsRemove() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(recipeRemoveMenu.class.getResource("/pantryPlanner/resources/recipe32.png")));
		setFont(new Font("Dubai", Font.PLAIN, 12));
		setTitle("REMOVE RECIPE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(recipeRemoveMenu.class.getResource("/pantryPlanner/resources/recipeBook128.png")));
		
		JLabel lblEnterRecipe = new JLabel("ENTER RECIPE:");
		lblEnterRecipe.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setColumns(10);
		
		//button block
		b_Find = new JButton("FIND");

		b_Find.setFont(new Font("SansSerif", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(lblEnterRecipe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(b_Find)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(label)
					.addGap(144))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterRecipe)
						.addComponent(b_Find)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// createEventsPantry: has all action listeners for creating events
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void createEventsRemove() 
	{
		b_Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
	}
}// end of recipeRemoveMenu
