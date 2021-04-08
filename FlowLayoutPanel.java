/* Ryken Santillan
 * Ms. Krasteva
 * 4/7/2021
 * This program creates the panel used for FlowLayoutDemo
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class FlowLayoutPanel extends JPanel {
	//arraylist to store components
	ArrayList<Component> components = new ArrayList<>();
	
	//creating buttons
	JButton b1 = new JButton("Button1");
	JButton b2 = new JButton("Button2");
	JButton b3 = new JButton("Button3");
	
	//flowlayout variable
	FlowLayout fl;

	//no argument constructor
	public FlowLayoutPanel() {
		//instantiating fl
		fl = new FlowLayout();
		//setting the layout as flow layout
		setLayout(fl);
		//adding the buttons
		add(b1);
		add(b2);
		add(b3);
		//adding the components to the arraylist
		components.add(b1);
		components.add(b2);
		components.add(b3);
	}

	public void addLayoutComponent(Component comp) {
		setLayout(fl); //layout is set as flow layout
		add(comp); //component is added to the panel
		components.add(comp); //component is added to the arraylist
		revalidate(); //panel is refreshed
	}

	public void changeHGap() {
		//creating a miniature frame and setting up the basics
		JFrame hGap = new JFrame("Change Horizontal Gap");
		hGap.setLayout(new FlowLayout());
		hGap.setSize(400, 70);
		hGap.setResizable(false);
		
		//creating graphics for the frame
		JLabel hGapChange = new JLabel("Change Horizontal Gap:");
		JButton change = new JButton("Change");
		JTextField inputField = new JTextField(10);
		hGapChange.setFont(new Font("Serif", Font.PLAIN, 12));
		
		//adding the components to the frame
		hGap.add(hGapChange);
		hGap.add(inputField);
		hGap.add(change);
		
		hGap.setLocationRelativeTo(this);
		hGap.setVisible(true);
		
		//action listener for the change button
		change.addActionListener(new ActionListener() {
			//once clicked, hgap will change if the entered value is an integer
			public void actionPerformed(ActionEvent e) {
				try {
					fl.setHgap(Integer.parseInt(inputField.getText()));
					revalidate(); //refreshes the frame
					repaint();
				} catch (NumberFormatException x) { //exceptions are not allowed
					JOptionPane.showMessageDialog(null, "Please enter an integer value!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}}});
		
		//resources are disposed of upon closure
		hGap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void changeVGap() {
		//creating a miniature frame and setting up the basics
		JFrame vGap = new JFrame("Change Vertical Gap");
		vGap.setLayout(new FlowLayout());
		vGap.setSize(400, 70);
		vGap.setResizable(false);
		
		//creating graphics for the frame
		JLabel vGapChange = new JLabel("Change Vertical Gap:");
		JButton change = new JButton("Change");
		JTextField inputField = new JTextField(10);
		vGapChange.setFont(new Font("Serif", Font.PLAIN, 12));
		
		//adding the components to the frame
		vGap.add(vGapChange);
		vGap.add(inputField);
		vGap.add(change);
		
		vGap.setLocationRelativeTo(this);
		vGap.setVisible(true);
		
		//action listener for the change button
		change.addActionListener(new ActionListener() {
			//once clicked, vgap will change if the entered value is an integer
			public void actionPerformed(ActionEvent e) {
				try {
					fl.setVgap(Integer.parseInt(inputField.getText()));
					revalidate(); //refreshes the frame
					repaint();
				} catch (NumberFormatException x) { //exceptions are not allowed
					JOptionPane.showMessageDialog(null, "Please enter an integer value!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}}});
		
		//resources are disposed of upon closure
		vGap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setAlignment(String alignment) {
		//if structure to change the alignment depending on which menu item was selected
		if (alignment.equals("Center"))
			fl.setAlignment(FlowLayout.CENTER);
		else if (alignment.equals("Left"))
			fl.setAlignment(FlowLayout.LEFT);
		else if (alignment.equals("Right"))
			fl.setAlignment(FlowLayout.RIGHT);
		revalidate(); //refreshes the frame
	}
	
	public void changeSize() {
		//creating a miniature frame and setting up the basics
		JFrame dimension = new JFrame("Change Dimensions");
		dimension.setLayout(new FlowLayout());
		dimension.setSize(400, 100);
		dimension.setResizable(false);
		
		//creating graphics for the frame
		JLabel widthChange = new JLabel("Enter Width:");
		JLabel heightChange = new JLabel("Enter Height:");
		widthChange.setFont(new Font("Serif", Font.PLAIN, 12));
		heightChange.setFont(new Font("Serif", Font.PLAIN, 12));
		JButton change = new JButton("Change");
		JTextField widthField = new JTextField(10);
		JTextField heightField = new JTextField(10);
		
		//adding the components to the panel
		dimension.add(widthChange);
		dimension.add(widthField);
		dimension.add(heightChange);
		dimension.add(heightField);
		dimension.add(change);
		
		dimension.setLocationRelativeTo(this);
		dimension.setVisible(true);
		
		//action listener for the change button
		change.addActionListener(new ActionListener() {
			//method that will change the size of the component depending if what is entered is an integer
			public void actionPerformed(ActionEvent e) {
				try {
					int width = Integer.parseInt(widthField.getText());
					int height = Integer.parseInt(heightField.getText());
					for (int i = 0; i < components.size(); i++){
						components.get(i).setPreferredSize(new Dimension(width,height));
					}
					revalidate();
					repaint();
				} catch (NumberFormatException x) { //exceptions are not allowed
					JOptionPane.showMessageDialog(null, "Please enter an integer value!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}}});
		
		//resources are disposed of upon closure
		dimension.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	//--------------The Following are getter Methods--------------//
	
	public String getGaps() {
		return "Current Vertical Gap: " + fl.getVgap() + ", Current Horizontal Gap: " + fl.getHgap();
	}
	
	public String retrieveAlignment() {
		String currAlign = "";
		   if (fl.getAlignment() == FlowLayout.CENTER)
			   currAlign = "The components are aligned in the center";
		   else if (fl.getAlignment() == FlowLayout.LEFT)
			   currAlign = "The components are aligned to the left";
		   else 
			   currAlign = "The components are aligned to the right";
		return currAlign;
	}
	
	public String getDimensions() {
		Dimension currComp = b1.getPreferredSize();
		return "Width: " + currComp.width + ", Height: " + currComp.height;
	}
	
	
	//-----------------------------------------------------------//
}
