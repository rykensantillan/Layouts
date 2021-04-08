/* Ryken Santillan
 * Ms. Krasteva
 * 4/8/2021
 * 1.) This program demonstrates the Spring Layout, created by Ryken Santillan
 * 2.) SpringLayout is a fairly flexible layout manager that is based on this idea of imaginary “springs” that separate components from one another. The springs act as constraints, and keep component 1’s x,y coordinates a certain distance (the spring) from component 2’s x,y coordinates.
 * 3.) SpringLayout was designed for GUI projects, and as such, offers utility methods to automatically define these constraints and create GUI programs. One example where SpringLayout would be good to use is if you are creating a program that defines a grid. The SpringLayout class has utility methods which can create a grid or compact grid easily. Another example is a dynamic list of items. This list can be new additions such as names, scores, etc. SpringLayout offers proportional resizing which will ensure that when using these utility methods, everything will be included proportionally and will not be cut off.
 * 4.) The SpringLayout, similar to NullLayout doesn’t place components automatically. In this program, its “constraints” must be defined before being added. By this notion, two cautions can be derived from the complexity of the layout. If the program is intended to display simple elements, then it is not a good choice to use SpringLayout. The second caution is that if an individual struggles spatially or is a beginner at using GUI, other layouts should be used.
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SpringLayoutDemo extends JFrame implements ActionListener {
	//creates a FlowLayoutPanel object
	SpringLayoutPanel panel = new SpringLayoutPanel();
	
	public SpringLayoutDemo() {
		//name of the frame
		super("Spring Layout Demonstration");

		//declaring and initializing the menu items
		JMenuItem quitItem = new JMenuItem("Quit");
		JMenuItem springX = new JMenuItem("Adjust Spring (Container): WEST");
		JMenuItem springY = new JMenuItem("Adjust Spring (Container): NORTH");
		JMenuItem hpRules = new JMenuItem("Rules");
		JMenuItem componentStatus = new JMenuItem("View Button1's Status");
		
		//declaring and initializing the menus
		JMenu fileMenu = new JMenu("File");
		JMenu adjustSpringMenu = new JMenu("Adjust Springs");
		JMenu hotPotato = new JMenu("Hot Potato");
		JMenu display = new JMenu("Display");
		
		//adding the menu items to the menus
		fileMenu.add(quitItem);
		adjustSpringMenu.add(springX);
		adjustSpringMenu.add(springY);
		hotPotato.add(hpRules);
		display.add(componentStatus);

		//creating a menu bar object
		JMenuBar myMenus = new JMenuBar();
		
		//adding the menus to the menu bar
		myMenus.add(fileMenu);
		myMenus.add(adjustSpringMenu);
		myMenus.add(hotPotato);
		myMenus.add(display);

		//menu bar is added to the frame
		setJMenuBar(myMenus);
		
		//action listeners for the menu items
		quitItem.addActionListener(this);
		springX.addActionListener(this);
		springY.addActionListener(this);
		componentStatus.addActionListener(this);
		hpRules.addActionListener(this);
		
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
		} else if (ae.getActionCommand().equals("Adjust Spring (Container): WEST")) {
			panel.adjustSpringWest(this);
		} else if (ae.getActionCommand().equals("Adjust Spring (Container): NORTH")) {
			panel.adjustSpringNorth(this);
		} else if (ae.getActionCommand().equals("Rules")) {
			hotPotatoRules();
		} else if (ae.getActionCommand().equals("View Button1's Status")) {
			display();
		}
	}
	
	public void hotPotatoRules() {
		//creating the dialog
		JDialog display = new JDialog(this, "Hot Potato Rules");
		String rules = "<html>The rules are simple, there are no rules! <br/> "
				+ "<html>Spring Layouts are separated by an imaginary 'spring'. This imaginary spring <br/>"
				+ "<html>is dictated in the constraints by two components. The first component <br/>"
				+ "<html>in this program is the button1, and the second component is the container itself.<br/>"
				+ "<html>Therefore if you experiment with 'Adjust Springs', you'll find that<br/>"
				+ "<html>a positive west and north value moves the button further away from (0,0)<br/>"
				+ "<html>in a diagonal-like manner! This game will teach you that the springs can<br/>"
				+ "<html>not only form between the container and a component, but between components<br/>"
				+ "<html>as well. Click on the 4 Hot Potato buttons, and witness this great undertaking!";
	
		//displaying the information
		JLabel ruleDisplay = new JLabel(rules);
		ruleDisplay.setFont(new Font("Serif", Font.PLAIN, 12));
		display.setSize(450,250);
		display.setResizable(false);
		display.setLayout(new FlowLayout());
		display.add(ruleDisplay);
		display.setLocationRelativeTo(this);
		display.setVisible(true);
	}
	
	//This method creates a dialog and uses the toString method to display different component statuses
	public void display() {
		//creating the dialog
		JDialog display = new JDialog(this, "Component Statuses");
		//displaying the information
		JLabel data = new JLabel(toString());
		data.setFont(new Font("Serif", Font.PLAIN, 10));
		display.setSize(300,110);
		display.setResizable(false);
		display.setLayout(new FlowLayout());
		display.add(data);
		display.setLocationRelativeTo(this);
		display.setVisible(true);
	}
	
	
	//uses getAlignmentX and getAlignmentY, the values shouldn't change for SpringLayout. 
	public String toString() { 
		return  "<html>" + panel.getPosition() + "<br/> <html>" + panel.getSpring() + " <br/> <html> Alignment X: " + panel.getAlignmentX() + ", Alignment Y: " + panel.getAlignmentX() + "; Overall Alignment: Centered <br/>";
	}
	
	//main method
	public static void main(String[] args) {
		new SpringLayoutDemo();
	} 
	
}
