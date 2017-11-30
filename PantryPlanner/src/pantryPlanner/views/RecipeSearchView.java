package pantryPlanner.views;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeSupport;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class RecipeSearchView extends JFrame{
	public static final String SEARCH_ACTION = "START SEARCH";
	public JTextField searchField;
	public JButton searchButton;
	private RecipeSearchThread dialog;
	
	public RecipeSearchView(String title) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setTitle(title);
				add(searchPanel());
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pack();
				setVisible(true);	
				dialog = new RecipeSearchThread(RecipeSearchView.this);
			}
			
			
		});
	}
	
	class SearchAction extends AbstractAction{
		JButton btn;
		public SearchAction(JButton btn) {
			this.btn = btn;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dialog.execute();
		}
		
	}
	
	class AmountTextFilter extends DocumentFilter{
		 @Override
		    public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
		        for (int n = string.length(); n > 0; n--) {
		            char c = string.charAt(n - 1);//get a single character of the string
		            if (Character.isAlphabetic(c) || c == ' ') {//if its an alphabetic character or white space
		                super.replace(fb, i, i1, String.valueOf(c), as);//allow update to take place for the given character
		            } 
		        }
		    }
	}
	
	public JPanel searchPanel(){
		JPanel searchPanel = new JPanel(new GridLayout(2,1,50,50));
		searchPanel.setBorder(BorderFactory.createEmptyBorder(75, 75, 75, 75));
		searchField = new JTextField("Search for a recipe");
		searchButton = new JButton("Search");
		
		((AbstractDocument) searchField.getDocument()).setDocumentFilter(new AmountTextFilter());
		searchButton.addActionListener(new SearchAction(searchButton));
		
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		return searchPanel;
	}

}