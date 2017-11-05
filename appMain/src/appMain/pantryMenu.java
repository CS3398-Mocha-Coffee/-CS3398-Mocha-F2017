package appMain;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class pantryMenu extends JFrame {
	private JLabel pantryL;
	private JButton addItemB, removeItemB, listPantryB, searchPantryB, doneB;
	
	//button handlers will be added here
	
	pantryMenu(){
		//Instantiate the label or greeting		
		JLabel pantryL = new JLabel("***Pantry Menu***", SwingConstants.CENTER);
		
		//Buttons:
		addItemB = new JButton("Add Item");
		removeItemB = new JButton("Remove Item");
		listPantryB = new JButton("List Pantry");
		searchPantryB = new JButton("Search Pantry");
		doneB = new JButton("Done");
		
		//Pane
		setTitle("Pantry Menu");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5,4));
		pane.add(pantryL);
		pane.add(addItemB);
		pane.add(removeItemB);
		pane.add(listPantryB);
		pane.add(searchPantryB);
		pane.add(doneB);		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(800,500);
	}//end pantryMenu
}//end class
