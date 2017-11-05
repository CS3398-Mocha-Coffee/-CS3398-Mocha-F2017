package appMain;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;



public class recipeMenu extends JFrame{		
	private JLabel recipeL;
	private JButton newRecipeB, removeRecipeB, listRecipeB, searchRecipeB, doneB;
	
	//button handlers will be added here
	
	 recipeMenu(){		
		//Instantiate the label or greeting		
		JLabel recipeL = new JLabel("***Recipe Menu***", SwingConstants.CENTER);
		
		//Buttons:
		newRecipeB = new JButton("Add Recipe");
		removeRecipeB = new JButton("Remove Recipe");
		listRecipeB = new JButton("List Recipes");
		searchRecipeB = new JButton("Search for Recipe");
		doneB = new JButton("Done");
		
		//Pane
		setTitle("Recipe Menu");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5,4));
		pane.add(recipeL);
		pane.add(newRecipeB);
		pane.add(removeRecipeB);
		pane.add(listRecipeB);
		pane.add(searchRecipeB);
		pane.add(doneB);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(800,500);		
	}//end recipeMenu
}//end class
