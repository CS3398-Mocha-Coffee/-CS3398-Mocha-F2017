package pantryPlanner.common;

import javax.swing.JOptionPane;

public class Output {
	private String output;
	
	public Output() {
		output = "";
	}	
	public void write(String info) {
		System.out.println(info);
		JOptionPane.showMessageDialog(null, info);
	}
}
