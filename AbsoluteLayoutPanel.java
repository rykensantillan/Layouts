/* Ryken Santillan
 * Ms. Krasteva
 * 4/7/2021
 * This program creates the panel for the AbsoluteLayoutDemo
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class AbsoluteLayoutPanel extends JPanel{
	//arraylist to store components
	ArrayList<Component> components = new ArrayList<>();
	
	//creating buttons
	JButton b1 = new JButton("Button1");
	JButton b2 = new JButton("Button2");
	JButton b3 = new JButton("Button3");
	
	//integer values for each button
	int b1X, b1Y, b1Width, b1Height;
	int b2X, b2Y, b2Width, b2Height;
	int b3X, b3Y, b3Width, b3Height;
	
	//no argument constructor
	public AbsoluteLayoutPanel() {
        setLayout(null); //null layout
		
		//setting names for future reference
		b1.setName("Button 1");
		b2.setName("Button 2");
		b3.setName("Button 3");
		
		//manually assigning values to the 12 variables
		b1X = 0;
		b1Y = 0;
		b1Width = 100;
		b1Height = 50;
		b2X = 100;
		b2Y = 100;
		b2Width = 150;
		b2Height = 50;
		b3X = 200;
		b3Y = 200;
		b3Width = 300;
		b3Height = 100;
		
		//adding the components to the panel
		add(b1);
		add(b2);
		add(b3);
		
		//manually setting the location and size of the components
		b1.setBounds(b1X,b1Y,b1Width,b1Height);
		b2.setBounds(b2X,b2Y,b2Width,b2Height);
		b3.setBounds(b3X,b3Y,b3Width,b3Height);
		
		//adding the components to the arraylist for future use
		components.add(b1);
		components.add(b2);
		components.add(b3);
	}
	
	public void addLayoutComponent(Component c, String str) {
		//creating a miniature frame and setting up the basics
		JFrame component = new JFrame("Add a new " + str);
		component.setLayout(null);
		component.setSize(400,300);
		component.setResizable(false);
		
		//creating graphics for the miniature frame
		JLabel xPosChange = new JLabel("Enter X-Position:");
		JLabel yPosChange = new JLabel("Enter Y-Position:");
		JLabel widthChange = new JLabel("Enter New Width:");
		JLabel heightChange = new JLabel("Enter New Height:");
		JButton create = new JButton("Create Component");
		JTextField widthField = new JTextField(10);
		JTextField heightField = new JTextField(10);
		JTextField xPosField = new JTextField(10);
		JTextField yPosField = new JTextField(10);
		xPosChange.setFont(new Font("Serif", Font.PLAIN, 12));
		yPosChange.setFont(new Font("Serif", Font.PLAIN, 12));
		widthChange.setFont(new Font("Serif", Font.PLAIN, 12));
		heightChange.setFont(new Font("Serif", Font.PLAIN, 12));
	
		//adding components to the frame
		component.add(xPosChange);
		component.add(xPosField);
		component.add(yPosChange);
		component.add(yPosField);
		component.add(widthChange);
		component.add(widthField);
		component.add(heightChange);
		component.add(heightField);
		component.add(create);
		
		//setting the location and size of each individual component
		xPosChange.setBounds(20,30,100,10);
		xPosField.setBounds(130,25,200,20);
		yPosChange.setBounds(20,80,100,10);
		yPosField.setBounds(130,75,200,20);
		widthChange.setBounds(20,130,100,10);
		widthField.setBounds(130,125,200,20);
		heightChange.setBounds(20,175,100,15);
		heightField.setBounds(130,175,200,20);
		create.setBounds(100,215,175,40);
		
		component.setLocationRelativeTo(this);
		component.setVisible(true);
		
		//action listener for the create button
		create.addActionListener(new ActionListener() {
			//small method that allows for the user to create a new specified component
			public void actionPerformed(ActionEvent e) {
				try {
					c.setBounds(Integer.parseInt(xPosField.getText()),Integer.parseInt(yPosField.getText()), Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()));
					add(c);
					components.add(c);
					c.setName("new");
					revalidate();
					repaint();
				} catch (NumberFormatException x) { //exceptions are not allowed
					JOptionPane.showMessageDialog(null, "Please enter an integer value!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}}});
		//dispose of all resources once closed
		component.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	public void editPosition(JButton b) {
		//creating a miniature frame and setting up the basics
		JFrame position = new JFrame("Edit Positions");
		position.setLayout(null);
		position.setSize(400,300);
		position.setResizable(false);
		
		//creating graphics for the miniature frame
		JLabel xPosChange = new JLabel("Enter X-Position:");
		JLabel yPosChange = new JLabel("Enter Y-Position:");
		JButton relocate = new JButton("Relocate");
		JTextField xPosField = new JTextField(10);
		JTextField yPosField = new JTextField(10);
		xPosChange.setFont(new Font("Serif", Font.PLAIN, 12));
		yPosChange.setFont(new Font("Serif", Font.PLAIN, 12));
		
		//adding components to the frame
		position.add(xPosChange);
		position.add(xPosField);
		position.add(yPosChange);
		position.add(yPosField);
		position.add(relocate);
		
		//setting the location and size of each individual component
		xPosChange.setBounds(20,30,100,10);
		xPosField.setBounds(130,25,200,20);
		yPosChange.setBounds(20,80,100,10);
		yPosField.setBounds(130,75,200,20);
		relocate.setBounds(150,180,100,30);

		position.setLocationRelativeTo(this);
		position.setVisible(true);
		
		//action listener for the relocate button
		relocate.addActionListener(new ActionListener() {
			//small method that allows for the user to change the x,y positions of the buttons
			public void actionPerformed(ActionEvent e) {
				try {
					int xPos = Integer.parseInt(xPosField.getText());
					int yPos = Integer.parseInt(yPosField.getText());
				
					if (b == b1) {
						b1X = xPos;
						b1Y = yPos;
						b1.setBounds(b1X,b1Y, b1Width, b2Height);
					} else if (b == b2) {
						b2X = xPos;
						b2Y = yPos;
						b2.setBounds(b2X,b2Y, b2Width, b2Height);
					} else if (b == b3) {
						b3X = xPos;
						b3Y = yPos;
						b3.setBounds(b3X,b3Y, b3Width, b3Height);
					} 
					revalidate();
					repaint();
				} catch (NumberFormatException x) { //exceptions are not allowed
					JOptionPane.showMessageDialog(null, "Please enter an integer value!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}}});
		//dispose all resources once done
		position.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void editSize(String str) {
		//creating a miniature frame and setting up the basics
		JFrame size = new JFrame("Edit size");
		size.setLayout(null);
		size.setSize(400,300);
		size.setResizable(false);
		
		//creating graphics for the miniature frame
		JLabel widthChange = new JLabel("Enter New Width:");
		JLabel heightChange = new JLabel("Enter New Height:");
		JButton resize = new JButton("Resize");
		JTextField widthField = new JTextField(10);
		JTextField heightField = new JTextField(10);
		widthChange.setFont(new Font("Serif", Font.PLAIN, 12));
		heightChange.setFont(new Font("Serif", Font.PLAIN, 12));
		
		//adding components to the frame
		size.add(widthChange);
		size.add(widthField);
		size.add(heightChange);
		size.add(heightField);
		size.add(resize);
		
		//setting the location and size of each individual component
		widthChange.setBounds(20,30,100,10);
		widthField.setBounds(130,25,200,20);
		heightChange.setBounds(20,80,100,10);
		heightField.setBounds(130,75,200,20);
		resize.setBounds(150,180,100,30);

		size.setLocationRelativeTo(this);
		size.setVisible(true);
		
		//action listener for the resize button
		resize.addActionListener(new ActionListener() {
			//small method that allows for the user to change the width or size of components
			public void actionPerformed(ActionEvent e) {
				try {
					int width = Integer.parseInt(widthField.getText());
					int height = Integer.parseInt(heightField.getText());
				
					if (str.equals("Button 1")) {
						b1Width = width;
						b1Height = height;
						b1.setBounds(b1X,b1Y, b1Width, b2Height);
					} else if (str.equals("Button 2")) {
						b2Width = width;
						b2Height = height;
						b2.setBounds(b2X,b2Y, b2Width, b2Height);
					} else if (str.equals("Button 3")) {
						b3Width = width;
						b3Height = height;
						b3.setBounds(b3X, b3Y, b3Width, b3Height);
					} else if (str.equals("All")){
						for (int i = 0; i < components.size(); i++) {
							components.get(i).setBounds((int)components.get(i).getLocation().getX(),(int)components.get(i).getLocation().getY(), width, height);
						} 
					}
					revalidate();
					repaint();
				} catch (NumberFormatException x) { //exceptions are not allowed
					JOptionPane.showMessageDialog(null, "Please enter an integer value!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}}});
		//dispose all resources once done
		size.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//----The following are getter methods with parameters----//

	public String getLocation(Component c) {
		String name = c.getName();
		return "For Component " + name + "~ X-Coordinate: " + c.getLocation().getX() + ". Y-Coordinate: " + c.getLocation().getY();
	}
	
	public String getSize(Component c) {
		String name = c.getName();
		return "For Component " + name + "~ Width: " + c.getWidth() + ". Height: " + c.getHeight();
	}
	
	//--------------------------------------------------------//
	
}
