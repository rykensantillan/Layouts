/* Ryken Santillan
 * Ms. Krasteva
 * 4/8/2021
 * This program can independently run the FlowLayoutRyken for the CardLayout
 */

import java.awt.event.*;
import javax.swing.*;


public class FlowLayoutEx extends JFrame implements ActionListener {
	//creates a FlowLayoutPanel object
	FlowLayoutRyken panel = new FlowLayoutRyken();
	
	public FlowLayoutEx() {
		//name of the frame
		super("Flow Layout Demonstration");

		//declaring and initializing the menu items
		JMenuItem quitItem = new JMenuItem("Quit");
		
		//declaring and initializing the menus
		JMenu fileMenu = new JMenu("File");
		
		//adding the menu items to the menus
		fileMenu.add(quitItem);

		//creating a menu bar object
		JMenuBar myMenus = new JMenuBar();
		
		//adding the menus to the menu bar
		myMenus.add(fileMenu);

		//menu bar is added to the frame
		setJMenuBar(myMenus);
		
		//action listeners for the menu items
		quitItem.addActionListener(this);
		
		//setting up the rest of the frame
		setSize(500, 400);
		setVisible(true);
		add(panel);
		
		//everything is exited
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//This method checks if a menu item is clicked. Depending on the menu item, it responds respectively
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Quit")) {
			dispose();
		} 
	}
	
	//main method
	public static void main(String[] args) {
		new FlowLayoutEx();
	} 
	
}