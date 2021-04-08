/* Ryken Santillan
 * Ms. Krasteva
 * 4/8/2021
 * This program creates the FlowLayout Panel for CardLayout
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class FlowLayoutRyken extends JPanel {
	//arraylist to store components
	ArrayList<Component> components = new ArrayList<>();
	
	//creating buttons
	JButton b1 = new JButton("Create Component");
	JButton b2 = new JButton("Increase HGap");
	JButton b3 = new JButton("Increase VGap");
	JButton b4 = new JButton("Change Alignment");
	JButton b5 = new JButton("Enlarge");
	JButton b6 = new JButton("Status");
	
	//flowlayout variable
	FlowLayout fl;

	//no argument constructor
	public FlowLayoutRyken() {
		//instantiating fl
		fl = new FlowLayout();
		
		//setting the layout as flow layout
		setLayout(fl);
		
		//adding the buttons
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		//adding the components to the arraylist
		components.add(b1);
		components.add(b2);
		components.add(b3);
		components.add(b4);
		components.add(b5);
		components.add(b6);
		
		//adds the methods
		addLayoutComponent();
		changeGaps();
		changeAlignment();
		changeSize();
		obtainStatus(this);
	}

	public void addLayoutComponent() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rnd = (int)(Math.random() * 1);
				setLayout(fl); //layout is set as flow layout
				if (rnd == 0) {
					JButton temp = new JButton("new");
					components.add(temp);
					add(temp); 
				}
				else {
					JLabel temp = new JLabel("new");
					components.add(temp);
					add(temp); 
				}
				revalidate(); //panel is refreshed
			}});
	}

	public void changeGaps() {
		//increases hgap
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fl.setHgap(fl.getHgap() * 2);
				revalidate(); //panel is refreshed
			}});
		//increases vgap
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fl.setVgap(fl.getVgap() * 2);
				revalidate(); //panel is refreshed
			}});	
	}

	public void changeAlignment() {
		//changes alignment each click
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fl.getAlignment() == FlowLayout.CENTER)
					fl.setAlignment(FlowLayout.LEFT);
				else if (fl.getAlignment() == FlowLayout.LEFT)
					fl.setAlignment(FlowLayout.RIGHT);
				else
					fl.setAlignment(FlowLayout.CENTER);
				revalidate(); //panel is refreshed
			}});
	}
	
	public void changeSize() {
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < components.size(); i++){
					components.get(i).setPreferredSize(new Dimension(b1.getPreferredSize().width + 10, b1.getPreferredSize().height + 10));
				}
				revalidate(); //panel is refreshed
			}});
	}
	
	public void obtainStatus(Container c) { //resizable
		b6.addActionListener(new ActionListener() {
			//small method that allows for the user to view the status of the Click Me! BUtton
			public void actionPerformed(ActionEvent e) {
				//creating a miniature frame and setting up the basics
				JFrame component = new JFrame("Status");
				component.setLayout(null);
				component.setSize(320,400);
				String dimensions = "";
				for (int i = 0; i < components.size(); i++)
					dimensions+= "<html> Component "+ (i+1) + ": " + getDimensions(components.get(i)) + "<br/>";
				//storing the info in a String
				String info =  "<html>" + getGaps() + "<br/>"
						     + "<html> Alignment X: " + getAlignmentX() + ", Alignment Y: " + getAlignmentY() + "<br/> "
						     + "<html> Component Dimensions <br/>" + dimensions;
						     		
				//creating graphics for the miniature frame
				JLabel allStatus = new JLabel(info);
				allStatus.setFont(new Font("Serif", Font.PLAIN, 12));
			
				//adding components to the frame
				component.add(allStatus);
				
				//setting the location and size of each individual component
				allStatus.setBounds(10,0,300,400);
				
				//making the frame visible
				component.setVisible(true);
				
				//dispose of all resources once closed
				component.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}});
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
	
	public String getDimensions(Component comp) {
		Dimension currComp = comp.getPreferredSize();
		return "Width: " + currComp.width + ", Height: " + currComp.height;
	}
	
	//-----------------------------------------------------------//
}
