package pantryPlanner.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import pantryPlanner.common.*;


public class RecipeSearchThread extends SwingWorker{
	private JDialog window;
	private RecipeSearchView parent;
	
	
	public RecipeSearchThread(RecipeSearchView parent) {
		this.parent = parent;
		window = new JDialog(parent);
		window.setLocationRelativeTo(parent);
		window.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if(RecipeSearchView.SEARCH_ACTION.equals(evt.getPropertyName())) {
					if(getState() == StateValue.STARTED) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								if(getState() == StateValue.STARTED) {
									//do stuff here when search button is pressed
									window.setVisible(true);
									//I.E. Read Custom Recipe CSV and add to Recipe List
								}
							}
						});
					}
				}
			}
			
		});
	}


	@Override
	protected Object doInBackground() throws Exception {
		// TODO Auto-generated method stub
			try {
				CustomSearch.customSearch(parent.searchField.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return null;
	}
	
	@Override
	protected void done() {
		//when search is finished it will initiate these
		/*TODO: 
		make it to where it will load these recipes into the current Recipe list*/
		window.dispose(); //after search is finished it will auto close dialog
		parent.dispose(); // and the parent frame
	}
}