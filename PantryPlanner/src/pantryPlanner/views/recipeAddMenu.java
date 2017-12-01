package pantryPlanner.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class recipeAddMenu extends JFrame {

	private JPanel contentPane;


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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setVisible(true);		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// createEventsPantry: has all action listeners for creating events
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void createEventsAdd() 
	{
		
	}

}//end recipeAddMenu

	


