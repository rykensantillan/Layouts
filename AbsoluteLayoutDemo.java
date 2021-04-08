/* Ryken Santillan
 * Ms. Krasteva
 * 4/7/2021
 * 1.) This program demonstrates the Absolute Layout, created by Ryken Santillan
 * 2.) AbsoluteLayout, or NullLayout in short, uses methods from the Container class to arrange components and their features without actually using a layout manager.
 * 3.) The freedom of AbsoluteLayout makes it ideal for programs where you need components on randomized or specified locations. Two examples of this revolve around personalized display setups, such as personalized desktops where one may spread out applications, or even personalized calendars.
 * 4.) Problem 1: The lack of a layout manager leads to one big problem: inefficient facilitation of arranging components. It is much harder to and more inefficient to use absolute layout when setting up components in comparison to using one of the preset layouts in Java (...the price of freedom). Problem 2: Creating a container without a layout manager can lead to position and spacing problems if the container is resized.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AbsoluteLayoutDemo extends JFrame implements ActionListener {
	//creating an object of the AbsoluteLayoutPanel class
	AbsoluteLayoutPanel panel = new AbsoluteLayoutPanel();

	public AbsoluteLayoutDemo() {
		//Name of the frame
		super("Absolute Layout Demonstration");

		//declaring and initializing the menu items
		JMenuItem quitItem = new JMenuItem("Quit");
		JMenuItem b1pos = new JMenuItem ("Edit Button 1's Position");
		JMenuItem b2pos = new JMenuItem ("Edit Button 2's Position");
		JMenuItem b3pos = new JMenuItem ("Edit Button 3's Position");
		JMenuItem b1size = new JMenuItem ("Edit Button 1's Size");
		JMenuItem b2size = new JMenuItem ("Edit Button 2's Size");
		JMenuItem b3size = new JMenuItem ("Edit Button 3's Size");
		JMenuItem resizeAll = new JMenuItem ("Resize All Components");
		JMenuItem addButton = new JMenuItem("Add a Button");
		JMenuItem addLabel = new JMenuItem("Add a Label");
		JMenuItem componentStatuses = new JMenuItem("View Original Component Statuses");
		
		//declaring and initializing the menus
		JMenu fileMenu = new JMenu("File");
		JMenu positionMenu = new JMenu("Position");
		JMenu sizeMenu = new JMenu("Size");
		JMenu addComponentMenu = new JMenu("Add Component");
		JMenu display = new JMenu ("Display");
		
		//adding the menu items to their respective menus
		fileMenu.add(quitItem);
		positionMenu.add(b1pos);
		positionMenu.add(b2pos);
		positionMenu.add(b3pos);
		sizeMenu.add(b1size);
		sizeMenu.add(b2size);
		sizeMenu.add(b3size);
		sizeMenu.add(resizeAll);
		addComponentMenu.add(addButton);
		addComponentMenu.add(addLabel);
		display.add(componentStatuses);

		//creating a menubar object
		JMenuBar myMenus = new JMenuBar();

		//adding the menus to the menu bar
		myMenus.add(fileMenu);
		myMenus.add(positionMenu);
		myMenus.add(sizeMenu);
		myMenus.add(addComponentMenu);
		myMenus.add(display);
 
		//displaying the menu bar
		setJMenuBar(myMenus);

		// action listeners for the buttons
		quitItem.addActionListener(this);
		b1pos.addActionListener(this);
		b2pos.addActionListener(this);
		b3pos.addActionListener(this);
		b1size.addActionListener(this);
		b2size.addActionListener(this);
		b3size.addActionListener(this);
		resizeAll.addActionListener(this);
		addButton.addActionListener(this);
		addLabel.addActionListener(this);
		componentStatuses.addActionListener(this);

		//setting up the rest of the frame
		setSize(500, 400);
		setVisible(true);
		add(panel);
		
		//everything is exited
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//This method checks for action events, and in this program, just the clicking of buttons
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Quit")) {
			dispose();
		} else if (ae.getActionCommand().equals("Edit Button 1's Position")) {
			panel.editPosition(panel.b1);
		} else if (ae.getActionCommand().equals("Edit Button 2's Position")) {
			panel.editPosition(panel.b2);
		} else if (ae.getActionCommand().equals("Edit Button 3's Position")) {
			panel.editPosition(panel.b3);
		} else if (ae.getActionCommand().equals("Edit Button 1's Size")) {
			panel.editSize("Button 1");
		} else if (ae.getActionCommand().equals("Edit Button 2's Size")) {
			panel.editSize("Button 2");
		} else if (ae.getActionCommand().equals("Edit Button 3's Size")) {
			panel.editSize("Button 3");
		} else if (ae.getActionCommand().equals("Resize All Components")) {
			panel.editSize("All");
		} else if (ae.getActionCommand().equals("Add a Button")) {
			panel.addLayoutComponent(new JButton("new"), "button");
		} else if (ae.getActionCommand().equals("Add a Label")) {
			panel.addLayoutComponent(new JLabel("new"), "label");
		} else if (ae.getActionCommand().equals("View Original Component Statuses")) {
			display();
		}
		
	}
	
	/*This is the display method, it utilizes JDialog and the overridden toString method 
	 * to create a dialog which displays the various statuses of components. It also
	 * offers a resizable dialog so the user can view all the components.
	 */
	public void display() { 
		//creating the JDialog and storing the component statuses
		JDialog display = new JDialog(this, "Component Statuses");
		String info = ""; //temp string var
		//for loop to run through all components and store them into a string
		for (int i = 0; i < panel.components.size(); i++)
			info += toString(panel.components.get(i));
		
		//displaying the info on the dialog
		JLabel data = new JLabel(info); 
		data.setFont(new Font("Serif", Font.PLAIN, 10));
		display.setSize(300,110);
		display.setLayout(new FlowLayout());
		display.add(data);
		display.setLocationRelativeTo(this);
		display.setVisible(true);
	}
	
	// This is an overridden toString method. It provides details on a component's status
	public String toString(Component c) { 
		return "<html>" + panel.getLocation(c) + "<br/> <html> " + panel.getSize(c) + "<br/>";
	}
	
	//main method to run the program, this is the driver class.
	public static void main(String[] args) {
		new AbsoluteLayoutDemo();
	}
}
