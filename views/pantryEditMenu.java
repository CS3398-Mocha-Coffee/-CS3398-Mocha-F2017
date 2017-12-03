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
import javax.swing.ImageIcon;

public class pantryEditMenu extends JFrame 
{
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public pantryEditMenu() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantryEditMenu.class.getResource("/pantryPlanner/resources/recipe32.png")));
		setTitle("EDIT PANTRY");
		initComponentsEdit();
		creatEventsEdit();

	}
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // createEventsPantry: has all action listeners for creating events
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void creatEventsEdit() 
	{
		// TODO Auto-generated method stub
		
	}
	
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // initComponentsPantry: has all code for creating and initializing components
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void initComponentsEdit() 
	{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(pantryEditMenu.class.getResource("/pantryPlanner/resources/pantry128.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(152, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(144))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(label)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
		
	}

}// end class pantryEditMenu
