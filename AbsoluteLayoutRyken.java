/* Ryken Santillan
 * Ms. Krasteva
 * 4/8/2021
 * AbsoluteLayout Panel for CardLayout
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AbsoluteLayoutRyken extends JPanel{
	//creating buttons
	JButton b1 = new JButton("X-Pos");
	JButton b2 = new JButton("Y-Pos");
	JButton b3 = new JButton("Enlarge");
	JButton b4 = new JButton("Status");
	
	//integer values for each button
	int b1X;
	int b2Y;
	int b3Width, b3Height;
	int b4X, b4Y, b4Width, b4Height;
	
	//no argument constructor
	public AbsoluteLayoutRyken() {
        setLayout(null); //null layout
		
		//setting names for future reference
        b4.setName("Status Button");
		
		//manually assigning values to the 8 variables
		b1X = 0;
		b2Y = 100;
		b3Width = 100;
		b3Height = 100;
		b4X = 360;
		b4Y = 20;
		b4Width = 100;
		b4Height = 70;
		
		//adding the components to the panel
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		//manually setting the location and size of the components
		b1.setBounds(b1X,0,100,50);
		b2.setBounds(100,b2Y,150,50);
		b3.setBounds(200,200,b3Width,b3Height);
		b4.setBounds(b4X, b4Y, b4Width, b4Height);

		//calling on the methods
		editPosition();
		editSize();
		obtainStatus();
	}
	
	
	public void editPosition() {
		b1.addActionListener(new ActionListener() {
			//small method that allows for the user to change the x position of b1
			public void actionPerformed(ActionEvent e) {
				b1X += 10;
				b1.setBounds(b1X,0,100,50);
				revalidate();
				}});
		b2.addActionListener(new ActionListener() {
			//small method that allows for the user to change the y positions of b2
			public void actionPerformed(ActionEvent e) {
				b2Y += 10;
				b2.setBounds(100,b2Y,150,50);
				revalidate();
				}});
	}
	
	public void editSize() {
		b3.addActionListener(new ActionListener() {
			//small method that allows for the user to change the size of b3
			public void actionPerformed(ActionEvent e) {
				b3Width +=10;
				b3Height +=10;
				b3.setBounds(200,200,b3Width,b3Height);
				revalidate();
				}});
	}
	
	public void obtainStatus() {
		b4.addActionListener(new ActionListener() {
			//small method that allows for the user to change the size of b3
			public void actionPerformed(ActionEvent e) {
				//creating a miniature frame and setting up the basics
				JFrame component = new JFrame("Status");
				component.setLayout(null);
				component.setSize(300,100);
				component.setResizable(false);
				
				//storing the info in a String
				String info = "<html> Status Button's Coordinates: (" + b4X + "," + b4Y + ") <br/>"
						     +"<html> Status Button's Size ~ Width: " + b4Width + ", Height: " + b4Height + "<br/>";
				
				//creating graphics for the miniature frame
				JLabel b4Status = new JLabel(info);
				b4Status.setFont(new Font("Serif", Font.PLAIN, 12));
			
				//adding components to the frame
				component.add(b4Status);
				
				//setting the location and size of each individual component
				b4Status.setBounds(40,5,300,60);
				
				//making the frame visible
				component.setVisible(true);
				
				//dispose of all resources once closed
				component.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}});
	}
}
