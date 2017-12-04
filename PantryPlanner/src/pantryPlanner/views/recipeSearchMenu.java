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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class recipeSearchMenu extends JFrame 
{

	private JPanel contentPane;
	private JTextField tf_enterRecipe;
	private JButton b_Search;
	private String v_recipe;
	private String v_displayRecipe;

	/**
	 * Create the frame.
	 */
	public recipeSearchMenu() 
	{

		initComponentsSearch();
		createEventsSearch();
	}
	
	private void initComponentsSearch() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(recipeSearchMenu.class.getResource("/pantryPlanner/resources/recipe32.png")));
		setFont(new Font("Dubai", Font.PLAIN, 12));
		setTitle("SEARCH RECIPE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 465, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterRecipe = new JLabel("ENTER RECIPE:");
		lblEnterRecipe.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		tf_enterRecipe = new JTextField();
		tf_enterRecipe.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tf_enterRecipe.setColumns(10);
		
		JTextPane tp_recipeDisplay = new JTextPane();
		tp_recipeDisplay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		//button block
		b_Search = new JButton("SEARCH");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(tp_recipeDisplay, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterRecipe)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addComponent(tf_enterRecipe, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(b_Search)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterRecipe, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_enterRecipe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(b_Search))
					.addGap(18)
					.addComponent(tp_recipeDisplay, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
		
	}

	private void createEventsSearch() 
	{
		b_Search.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//add methods here
				v_recipe = tf_enterRecipe.getText();
				//v_displayRecipe = 
			    tf_enterRecipe.setText("");
			}
		});
		
	}
}//end class recipeSearchMenu
