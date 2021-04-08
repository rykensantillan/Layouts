/* Ryken Santillan
 * Ms. Krasteva
 * 4/7/2021
 * 1.) This program demonstrates the Flow Layout, created by Ryken Santillan
 * 2.) FlowLayout is a type of layout manager that places components in a row. Multiple rows are used if certain components (buttons / labels) do not fit on a single line.
 * 3.) The neat, uniform arrangement of FlowLayout makes it ideal for a program where simplicity is needed. Two examples of this might be a simple toolbar where items are lined up linearly, or for application shortcuts where apps are lined up.
 * 4.) Problem 1: Resizing the tab can cause components to move from its original position, and could possibly cause distortions to the intended design. Problem 2: FlowLayout is very simplistic, and therefore does not offer as much utility as other layouts. Therefore, customizing the size can get out of hand, and attempts to set the preferred size can ruin the aesthetic appeal of the program.
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo extends JFrame implements ActionListener {
	//creates a FlowLayoutPanel object
	FlowLayoutPanel test = new FlowLayoutPanel();
	
	public FlowLayoutDemo() {
		//name of the frame
		super("Flow Layout Demonstration");

		//declaring and initializing the menu items
		JMenuItem quitItem = new JMenuItem("Quit");
		JMenuItem vGapItem = new JMenuItem("Change VGap");
		JMenuItem hGapItem = new JMenuItem("Change HGap");
		JMenuItem addButton = new JMenuItem("Add a Button");
		JMenuItem addLabel = new JMenuItem("Add a Label");
		JMenuItem center = new JMenuItem("Center");
		JMenuItem left = new JMenuItem("Left");
		JMenuItem right = new JMenuItem("Right");
		JMenuItem dimensions = new JMenuItem("Change Component Dimensions");
		JMenuItem statuses = new JMenuItem("Component Statuses");
		
		//declaring and initializing the menus
		JMenu fileMenu = new JMenu("File");
		JMenu gapEditorMenu = new JMenu ("Edit Gaps");
		JMenu addComponentMenu = new JMenu("Add Component");
		JMenu setAlignmentMenu = new JMenu("Change Alignment");
		JMenu changeSize = new JMenu("Component Size");
		JMenu display = new JMenu("Display");
		
		//adding the menu items to the menus
		fileMenu.add(quitItem);
		gapEditorMenu.add(vGapItem);
		gapEditorMenu.add(hGapItem);
		addComponentMenu.add(addButton);
		addComponentMenu.add(addLabel);
		setAlignmentMenu.add(center);
		setAlignmentMenu.add(left);
		setAlignmentMenu.add(right);
		changeSize.add(dimensions);
		display.add(statuses);

		//creating a menu bar object
		JMenuBar myMenus = new JMenuBar();

		//adding the menus to the menu bar
		myMenus.add(fileMenu);
		myMenus.add(gapEditorMenu);
		myMenus.add(addComponentMenu);
		myMenus.add(setAlignmentMenu);
		myMenus.add(changeSize);
		myMenus.add(display);

		//menu bar is added to the frame
		setJMenuBar(myMenus);
		
		//action listeners for the menu items
		quitItem.addActionListener(this);
		vGapItem.addActionListener(this);
		hGapItem.addActionListener(this);
		addButton.addActionListener(this);
		addLabel.addActionListener(this);
		center.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);
		dimensions.addActionListener(this);
		statuses.addActionListener(this);
		
		//setting up the rest of the frame
		setSize(500, 400);
		setVisible(true);
		add(test);
		
		//everything is exited
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//This method checks if a menu item is clicked. Depending on the menu item, it responds respectively
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Quit")) {
			dispose();
		} else if (ae.getActionCommand().equals("Change VGap")) {
		    test.changeVGap();
		} else if (ae.getActionCommand().equals("Change HGap")) {
			test.changeHGap();
		} else if (ae.getActionCommand().equals("Add a Button")) {
			test.addLayoutComponent(new JButton("new"));
		} else if (ae.getActionCommand().equals("Add a Label")) {
			test.addLayoutComponent(new JLabel("new"));
		} else if (ae.getActionCommand().equals("Center")) {
			test.setAlignment("Center");
		} else if (ae.getActionCommand().equals("Left")) {
			test.setAlignment("Left");
		} else if (ae.getActionCommand().equals("Right")) {
			test.setAlignment("Right");
		} else if (ae.getActionCommand().equals("Change Component Dimensions")) {
			test.changeSize();
		} else if (ae.getActionCommand().equals("Component Statuses")) {
			display();
		}
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
	
	//uses getAlignmentX and getAlignmentY, they shouldn't change for FlowLayout. Only the information for the three original buttons are displayed
	public String toString() { 
		return "<html> Gaps - " + test.getGaps() + "<br/>" + "<html> Original Component Dimensions - " + test.getDimensions() +  "<br/>" + "<html> Alignments - " + " Alignment X: " + test.getAlignmentX()+ ", Alignment Y: " + test.getAlignmentY()+ "<br/>" +  "Overall Alignment: " + test.retrieveAlignment() + ".";
	}
	
	//main method
	public static void main(String[] args) {
		new FlowLayoutDemo();
	} 
	
}
