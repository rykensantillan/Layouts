/* Ryken Santillan
 * Ms. Krasteva
 * 4/8/2021
 * This program is the CardLayout Program and it combines 3 different layouts using 3 different "cards".
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutRyken extends JFrame implements ActionListener {
	 
	public CardLayoutRyken() {
		//name of the frame
		super("Card Layout");

		//declaring and initializing the menu items
		JMenuItem quitItem = new JMenuItem("Quit");
		
		//declaring and initializing the menus
		JMenu fileMenu = new JMenu("File");
		
		//adding the menu items to the menus
		fileMenu.add(quitItem);

		//creating a menu bar object
		JMenuBar myMenus = new JMenuBar();
		
		//adding the menus to the menu bar
		myMenus.add(fileMenu);

		//menu bar is added to the frame
		setJMenuBar(myMenus);
		
		//action listeners for the menu items
		quitItem.addActionListener(this);
		
		//setting up the contents for the CardLayout
		JPanel panel = new JPanel(new CardLayout());
		JPanel borderPanel = new JPanel(new BorderLayout());
		AbsoluteLayoutRyken al = new AbsoluteLayoutRyken();
		FlowLayoutRyken fl = new FlowLayoutRyken();
		SpringLayoutRyken sl = new SpringLayoutRyken();
		JTabbedPane tp = new JTabbedPane();
		
		//adding the layouts to the cardlayout
		panel.add(al, "AbsoluteLayout");
		tp.add("AbsoluteLayout", al);
		panel.add(fl, "FlowLayout");
		tp.add("FlowLayout", fl);
		panel.add(sl, "SpringLayout");
		tp.add("SpringLayout", sl);
		
		//-----------------Setting Up the Border Layout-----------------//
		//3 layouts and one JLabel to be used, order will differ from outline
		AbsoluteLayoutRyken al2 = new AbsoluteLayoutRyken();
		FlowLayoutRyken fl2 = new FlowLayoutRyken();
		FlowLayoutRyken fl3 = new FlowLayoutRyken();
		SpringLayoutRyken sl2 = new SpringLayoutRyken();
		JLabel layoutsNAuthor = new JLabel("<html> AbsoluteLayout - Ryken <br/>"
				                         + "<html> FlowLayout - Ryken <br/>"
		                                 + "<html> SpringLayout - Ryken <br/>");
		
		//sizes are changed to fit on the BorderLayout
		al2.setPreferredSize(new Dimension(500,300));
		fl2.setPreferredSize(new Dimension(200,100));
		fl3.setPreferredSize(new Dimension(200,100));
		sl2.setPreferredSize(new Dimension(480,100));
		
		//all 3 layouts and 1 label are added, and the entire borderlayout is added to the panel
		borderPanel.add(al2, BorderLayout.LINE_START);
		borderPanel.add(fl2, BorderLayout.PAGE_START);
		borderPanel.add(layoutsNAuthor, BorderLayout.CENTER);
		borderPanel.add(fl3, BorderLayout.PAGE_END);
		borderPanel.add(sl2, BorderLayout.LINE_END);
		panel.add(borderPanel, "Border Layout");
		tp.add("Border Layout", borderPanel);
		//--------------------------------------------------------------//
		
		//adds the JPanels to the frame
		getContentPane().add(panel);
		getContentPane().add(tp);
		
		//setting up the rest of the frame
		setSize(1200, 800);
		setVisible(true);
		
		//everything is exited
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//This method checks if a menu item is clicked. Depending on the menu item, it responds respectively
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Quit")) {
			dispose();
		} 
	}
	
	//main method
	public static void main(String[] args) {
		new CardLayoutRyken();
	} 
	
}
