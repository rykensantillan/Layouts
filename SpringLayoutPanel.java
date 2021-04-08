/* Ryken Santillan
 * Ms. Krasteva
 * 4/8/2021
 * This is the panel for the SpringLayoutDemo
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SpringLayoutPanel extends JPanel {
	// creating buttons
	JButton b1 = new JButton("Button1");
	JButton hp1 = new JButton("Hot Potato P1");
	JButton hp2 = new JButton("Hot Potato P2");
	JButton hp3 = new JButton("Hot Potato P3");
	JButton hp4 = new JButton("Hot Potato P4");

	int b1X, b1Y;
	String spring;
	SpringLayout sp;

	public SpringLayoutPanel() {
		// sets the layout as Spring Layout
		sp = new SpringLayout();
		setLayout(sp);

		// adding the buttons to the pane
		add(b1);
		add(hp1);
		add(hp2);
		add(hp3);
		add(hp4);

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
		hotPotato();
	}

	public void adjustSpringWest(Container c) {
		// creating a miniature frame and setting up the basics
		JFrame west = new JFrame("Change Horizontal Spring");
		west.setLayout(new FlowLayout());
		west.setSize(400, 70);
		west.setResizable(false);

		// creating graphics for the frame
		JLabel westChange = new JLabel("Change West Spring:");
		JButton change = new JButton("Change");
		JTextField inputField = new JTextField(10);
		west.setFont(new Font("Serif", Font.PLAIN, 12));

		// adding the components to the frame
		west.add(westChange);
		west.add(inputField);
		west.add(change);

		west.setLocationRelativeTo(this);
		west.setVisible(true);

		// action listener for the change button
		change.addActionListener(new ActionListener() {
			// once clicked, west spring will change if the entered value is an integer
			public void actionPerformed(ActionEvent e) {
				try {
					sp.putConstraint(SpringLayout.WEST, b1, Integer.parseInt(inputField.getText()), SpringLayout.WEST, c);
					b1X += Integer.parseInt(inputField.getText());
					revalidate(); // refreshes the frame
					repaint();
				} catch (NumberFormatException x) { // exceptions are not allowed
					JOptionPane.showMessageDialog(null, "Please enter an integer value!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}}});

		// resources are disposed of upon closure
		west.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void adjustSpringNorth(Container c) {
		// creating a miniature frame and setting up the basics
		JFrame north = new JFrame("Change Vertical Spring");
		north.setLayout(new FlowLayout());
		north.setSize(400, 70);
		north.setResizable(false);

		// creating graphics for the frame
		JLabel northChange = new JLabel("Change North Spring:");
		JButton change = new JButton("Change");
		JTextField inputField = new JTextField(10);
		north.setFont(new Font("Serif", Font.PLAIN, 12));

		// adding the components to the frame
		north.add(northChange);
		north.add(inputField);
		north.add(change);

		north.setLocationRelativeTo(this);
		north.setVisible(true);

		// action listener for the change button
		change.addActionListener(new ActionListener() {
			// once clicked, north spring will change if the entered value is an integer
			public void actionPerformed(ActionEvent e) {
				try {
					sp.putConstraint(SpringLayout.NORTH, b1, Integer.parseInt(inputField.getText()), SpringLayout.NORTH, c);
					b1Y += Integer.parseInt(inputField.getText());
					revalidate(); // refreshes the frame
					repaint();
				} catch (NumberFormatException x) { // exceptions are not allowed
					JOptionPane.showMessageDialog(null, "Please enter an integer value!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}}});
		
		// resources are disposed of upon closure
		north.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	
	//--------The following are getter methods--------//
	
	public String getPosition() {
		return "Button 1's X-Coordinate: " + b1X + ", Button 1's Y-Coordinate: " + b1Y;
	}
	
	public String getSpring() {
		if (b1X == 190 && b1Y == 45 && spring.equals("Hot Potato 1"))
			return "Button 1's Spring is connected to Hot Potato 1";
		else if (b1X == 135 && b1Y == 130 && spring.equals("Hot Potato 2"))
			return "Button 1's Spring is connected to Hot Potato 2";
		else if (b1X == 270 && b1Y == 130 && spring.equals("Hot Potato 3"))
			return "button 1's Spring is connected to Hot Potato 3";
		else if (b1X == 190 && b1Y == 270 && spring.equals("Hot Potato 4"))
			return "Button 1's Spring is connected to Hot Potato 4";
		else
			return "Button 1's Spring is connected to the JPanel Container";
	}
	
	//--------------------------------------------//
}
