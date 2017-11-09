package pantryPlanner.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class addMenu extends JFrame 
{

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public addMenu() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(addMenu.class.getResource("/pantryPlanner/resources/recipe32.png")));
		setTitle("ADD ITEM");
		initComponentsAdd();
		createEventsAdd();
		
		
	}
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // initComponentsPantry: has all code for creating and initializing components
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void initComponentsAdd()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblQuanty = new JLabel("");
		lblQuanty.setIcon(new ImageIcon(addMenu.class.getResource("/pantryPlanner/resources/recipe128.png")));
		lblQuanty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(lblQuanty)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(lblQuanty)
					.addContainerGap(64, Short.MAX_VALUE))
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
}
