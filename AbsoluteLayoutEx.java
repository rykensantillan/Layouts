/* Ryken Santillan
 * Ms. Krasteva
 * 4/8/2021
 * This program can indepenently run the AbsoluteLayoutRyken for the CardLayout
 */

import java.awt.event.*;
import javax.swing.*;

public class AbsoluteLayoutEx extends JFrame implements ActionListener {
	//creating an object of the AbsoluteLayoutPanel class
	AbsoluteLayoutRyken panel = new AbsoluteLayoutRyken();

	public AbsoluteLayoutEx() {
		//Name of the frame
		super("Absolute Layout Demonstration");

		//declaring and initializing the menu items
		JMenuItem quitItem = new JMenuItem("Quit");
		
		//declaring and initializing the menus
		JMenu fileMenu = new JMenu("File");
		
		//adding the menu items to their respective menus
		fileMenu.add(quitItem);

		//creating a menubar object
		JMenuBar myMenus = new JMenuBar();

		//adding the menus to the menu bar
		myMenus.add(fileMenu);
 
		//displaying the menu bar
		setJMenuBar(myMenus);

		// action listeners for the menu items
		quitItem.addActionListener(this);

		//setting up the rest of the frame
		setSize(500, 400);
		setVisible(true);
		add(panel);
		
		//everything is exited
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//This method checks for action events, and in this program, just the clicking of menu items
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Quit")) {
			dispose();
		}  
	}
	
	//main method to run the program, this is the driver class.
	public static void main(String[] args) {
		new AbsoluteLayoutEx();
	}
}
