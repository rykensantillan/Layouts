/* Ryken Santillan
 * Ms. Krasteva
 * 4/8/2021
 * SpringLayout Panel for CardLayout
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SpringLayoutRyken extends JPanel {
	// creating buttons
	JButton b1 = new JButton("Click Me!");
	JButton hp1 = new JButton("Hot Potato P1");
	JButton hp2 = new JButton("Hot Potato P2");
	JButton hp3 = new JButton("Hot Potato P3");
	JButton hp4 = new JButton("Hot Potato P4");
	JButton statusb = new JButton("View Status");

	int b1X, b1Y; //used to keep track of the position
	String spring; //used to keep track of spring attachment
	SpringLayout sp; //spring layout var

	//no argument constructor
	public SpringLayoutRyken() {
		// sets the layout as Spring Layout
		sp = new SpringLayout();
		setLayout(sp);

		// adding the buttons to the pane
		add(b1);
		add(hp1);
		add(hp2);
		add(hp3);
		add(hp4);
		add(statusb);

		// adding constraints to the layout
			// constraints for b1
		sp.putConstraint(SpringLayout.WEST, b1, 5, SpringLayout.WEST, this);
		b1X += 5;
		sp.putConstraint(SpringLayout.NORTH, b1, 5, SpringLayout.NORTH, this);
		b1Y += 5;
			// constraints for hp1
		sp.putConstraint(SpringLayout.WEST, hp1, 175, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, hp1, 5, SpringLayout.NORTH, this);
			//constraints for hp2
		sp.putConstraint(SpringLayout.WEST, hp2, 5, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, hp2, 130, SpringLayout.NORTH, this);
			//constraints for hp3
		sp.putConstraint(SpringLayout.WEST, hp3, 370, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, hp3, 130, SpringLayout.NORTH, this);
			//constraints for hp4
		sp.putConstraint(SpringLayout.WEST, hp4, 175, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, hp4, 310, SpringLayout.NORTH, this);
			//constraints for statusb
		sp.putConstraint(SpringLayout.WEST, statusb, 350, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, statusb, 5, SpringLayout.NORTH, this);
		
		//adds the methods
		adjustSprings(this);
		hotPotato();
		obtainStatus();
	}

	public void adjustSprings(Container c) {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spring = "Hot Potato 1";
				//moves b1 10 pixels to the right and 10 down, distance of sqrt(200);
				b1X += 5;
				sp.putConstraint(SpringLayout.WEST, b1, b1X, SpringLayout.WEST, c);
				b1Y += 5;
				sp.putConstraint(SpringLayout.NORTH, b1, b1Y, SpringLayout.NORTH, c);
				revalidate();
			}});
	}

	
	public void hotPotato() {
		//anticlimactic game of hot potato..
		hp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spring = "Hot Potato 1";
				//moves Button1 15 pixels to the right and 40 down from hp1's x,y coordinates
				sp.putConstraint(SpringLayout.WEST, b1, 15, SpringLayout.WEST, hp1);
				b1X = 190;
				sp.putConstraint(SpringLayout.NORTH, b1, 40, SpringLayout.NORTH, hp1);
				b1Y = 45;
				revalidate();
			}});
		hp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spring = "Hot Potato 2";
				//moves Button1 130 pixels to the right from hp2's x,y coordinates
				sp.putConstraint(SpringLayout.WEST, b1, 130, SpringLayout.WEST, hp2);
				b1X = 135;
				sp.putConstraint(SpringLayout.NORTH, b1, 0, SpringLayout.NORTH, hp2);
				b1Y = 130;
				revalidate();
			}});
		hp3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spring = "Hot Potato 3";
				//moves Button1 100 pixels to the left from hp3's x,y coordinates
				sp.putConstraint(SpringLayout.WEST, b1, -100, SpringLayout.WEST, hp3);
				b1X = 270;
				sp.putConstraint(SpringLayout.NORTH, b1, 0, SpringLayout.NORTH, hp3);
				b1Y = 130;
				revalidate();
			}});
		hp4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spring = "Hot Potato 4";
				//moves Button1 15 pixels to the right and 40 up from hp4's x,y coordinates
				sp.putConstraint(SpringLayout.WEST, b1, 15, SpringLayout.WEST, hp4);
				b1X = 190;
				sp.putConstraint(SpringLayout.NORTH, b1, -40, SpringLayout.NORTH, hp4);
				b1Y = 270;
				revalidate();
			}});
	}
	
	public void obtainStatus() {
		statusb.addActionListener(new ActionListener() {
			//small method that allows for the user to view the status of the Click Me! BUtton
			public void actionPerformed(ActionEvent e) {
				//creating a miniature frame and setting up the basics
				JFrame component = new JFrame("Status");
				component.setLayout(null);
				component.setSize(320,110);
				component.setResizable(false);
				
				//storing the info in a String
				String info = "<html> 'Click Me!' Button's Coordinates: " + getPosition() + "<br/>"
						     +"<html> 'Click Me!' Button's Spring ~ Currently Attached to: <br/> " + getSpring();
				
				//creating graphics for the miniature frame
				JLabel cmStatus = new JLabel(info);
				cmStatus.setFont(new Font("Serif", Font.PLAIN, 12));
			
				//adding components to the frame
				component.add(cmStatus);
				
				//setting the location and size of each individual component
				cmStatus.setBounds(10,5,300,60);
				
				//making the frame visible
				component.setVisible(true);
				
				//dispose of all resources once closed
				component.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}});
	}
	
	//--------The following are getter methods--------//
	
	public String getPosition() {
		return "(" + b1X + "," + b1Y + ")";
	}
	
	public String getSpring() {
		if (b1X == 190 && b1Y == 45 && spring.equals("Hot Potato 1"))
			return "Hot Potato 1";
		else if (b1X == 135 && b1Y == 130 && spring.equals("Hot Potato 2"))
			return "Hot Potato 2";
		else if (b1X == 270 && b1Y == 130 && spring.equals("Hot Potato 3"))
			return "Hot Potato 3";
		else if (b1X == 190 && b1Y == 270 && spring.equals("Hot Potato 4"))
			return "Hot Potato 4";
		else
			return "The JPanel Container";
	}
	
	//--------------------------------------------//
}
