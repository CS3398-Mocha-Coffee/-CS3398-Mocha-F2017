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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pantryMenu extends JFrame {

	private JPanel ctpPantry;
	private JButton b_addRemove;
	private JButton b_display;
	private JButton b_edit;
	private JButton b_return;



	/**
	 * Create the pantryMenu frame.
	 */
	public pantryMenu() 
	{
		initComponentsPantry();
		createEventsPantry();
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
		b_addRemove = new JButton("ADD/REMOVE");
		b_addRemove.setBorder(null);		
		b_edit = new JButton("EDIT PANTRY");
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
								.addComponent(b_addRemove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(b_edit))
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
							.addComponent(b_addRemove, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(b_edit)))
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
				///add in display here
				JOptionPane.showMessageDialog(null, "Hi Brian");
			}
		});
		/*
		 * integrate edit function here
		 */
		b_edit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		/*
		 * integrate add/remove function here
		 */
		b_addRemove.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
	}
}//end pantryMenu
