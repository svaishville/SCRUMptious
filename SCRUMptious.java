
 
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFormattedTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
 
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
 
/* MenuLookDemo.java requires images/middle.gif. */
 
/*
 * This class exists solely to show you what menus look like.
 * It has no menu-related event handling.
 */
public class SCRUMptious extends JPanel implements ActionListener {
	JTextArea output;
	JScrollPane scrollPane;
 
	public JMenuBar createMenuBar() {
    	JMenuBar menuBar;
    	JMenu menu, submenu;
    	JMenuItem menuItem;
    	JRadioButtonMenuItem rbMenuItem;
    	JCheckBoxMenuItem cbMenuItem;
 
    	//Create the menu bar.
    	menuBar = new JMenuBar();
 
    	//Build the first menu.
    	menu = new JMenu("Backlog");
    	menu.setMnemonic(KeyEvent.VK_A);
    	menu.getAccessibleContext().setAccessibleDescription(
            	"The only menu in this program that has menu items");
    	menuBar.add(menu);
 
   	 
  	 

    	submenu = new JMenu("Add New...");
    	submenu.setMnemonic(KeyEvent.VK_S);
 
    	menuItem = new JMenuItem("Team Member");
    	menuItem.setAccelerator(KeyStroke.getKeyStroke(
            	KeyEvent.VK_2, ActionEvent.ALT_MASK));
    	submenu.add(menuItem);
 
    	menuItem = new JMenuItem("Note");
    	submenu.add(menuItem);
    	menu.add(submenu);
   	 
  	 
    	//a group of JMenuItems
    	menuItem = new JMenuItem("New Item",
                             	KeyEvent.VK_T);
    	//menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
    	menuItem.setAccelerator(KeyStroke.getKeyStroke(
            	KeyEvent.VK_1, ActionEvent.ALT_MASK));
    	menuItem.getAccessibleContext().setAccessibleDescription(
            	"This doesn't really do anything");
    	menuItem.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null, "You suck");
    			new InternalFrameDemo();
    		}
    	}
    	);
    	menu.add(menuItem);
 
    	ImageIcon icon = createImageIcon("images/middle.gif");
    	menuItem = new JMenuItem("Close", icon);
    	menuItem.setAccelerator(KeyStroke.getKeyStroke(
            	KeyEvent.VK_F4, ActionEvent.ALT_MASK));
    	menuItem.setMnemonic(KeyEvent.VK_B);
    	menu.add(menuItem);
 
    	menuItem = new JMenuItem(icon);
    	menuItem.setMnemonic(KeyEvent.VK_D);
    	menu.add(menuItem);
 
    	//a group of radio button menu items
    	menu.addSeparator();
    	ButtonGroup group = new ButtonGroup();
 
    	rbMenuItem = new JRadioButtonMenuItem("Grid View");
    	rbMenuItem.setSelected(true);
    	rbMenuItem.setMnemonic(KeyEvent.VK_R);
    	group.add(rbMenuItem);
    	menu.add(rbMenuItem);
 
    	rbMenuItem = new JRadioButtonMenuItem("List View");
    	rbMenuItem.setMnemonic(KeyEvent.VK_O);
    	group.add(rbMenuItem);
    	menu.add(rbMenuItem);
 
    	//a group of check box menu items
    	menu.addSeparator();
    	cbMenuItem = new JCheckBoxMenuItem("Show urgent notes on top");
    	cbMenuItem.setMnemonic(KeyEvent.VK_C);
    	menu.add(cbMenuItem);
 
    	cbMenuItem = new JCheckBoxMenuItem("Show sprint team name");
    	cbMenuItem.setMnemonic(KeyEvent.VK_H);
    	menu.add(cbMenuItem);
 
    	//a submenu
   	 
 
    	//Build second menu in the menu bar.
    	menu = new JMenu("Sprints");
    	menu.setMnemonic(KeyEvent.VK_N);
    	menu.getAccessibleContext().setAccessibleDescription(
            	"This menu does nothing");
    	menuBar.add(menu);
    	menuItem = new JMenuItem("New Item",
            	KeyEvent.VK_T);
//menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
    	menuItem.setAccelerator(KeyStroke.getKeyStroke(
   			 KeyEvent.VK_1, ActionEvent.ALT_MASK));
    	menuItem.getAccessibleContext().setAccessibleDescription(
   			 "This doesn't really do anything");
    	menu.add(menuItem);
   	 
   	 
    	//Build second menu in the menu bar.
    	menu = new JMenu("Team View");
    	menu.setMnemonic(KeyEvent.VK_N);
    	menu.getAccessibleContext().setAccessibleDescription(
            	"This menu does nothing");
    	menuBar.add(menu);
    	menuItem = new JMenuItem("New Item",
            	KeyEvent.VK_T);
       
//menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
    	menuItem.setAccelerator(KeyStroke.getKeyStroke(
   			 KeyEvent.VK_1, ActionEvent.ALT_MASK));
    	menuItem.getAccessibleContext().setAccessibleDescription(
   			 "This doesn't really do anything");
    	
    	menu.add(menuItem);
   	 
  	 
 
    	return menuBar;
   	 
   	 
  	 
	}
	

 
	public Container createContentPane() {
    	//Create the content-pane-to-be.
    	JPanel contentPane = new JPanel(new BorderLayout());
    	contentPane.setOpaque(true);
 
    	//Create a scrolled text area.
    	output = new JTextArea(25,60);
    	output.setEditable(true);
    	scrollPane = new JScrollPane(output);
    	output.setFont(new Font("Serif", Font.BOLD, 16));
 
    	//Add the text area to the content pane.
    	contentPane.add(scrollPane, BorderLayout.CENTER);
 
    	return contentPane;
	}
 
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
    	java.net.URL imgURL = SCRUMptious.class.getResource(path);
    	if (imgURL != null) {
        	return new ImageIcon(imgURL);
    	} else {
        	System.err.println("Couldn't find file: " + path);
        	return null;
    	}
	}
 
	/**
 	* Create the GUI and show it.  For thread safety,
 	* this method should be invoked from the
 	* event-dispatching thread.
 	*/
	private static void createAndShowGUI() {
    	//Create and set up the window.
    	JFrame frame = new JFrame("MenuLookDemo");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    	//Create and set up the content pane.
    	SCRUMptious demo = new SCRUMptious();
    	frame.setJMenuBar(demo.createMenuBar());
    	frame.setContentPane(demo.createContentPane());
 
    	//Display the window.
    	frame.setSize(450, 260);
    	frame.setVisible(true);
	}
 
	public static void main(String[] args) {
    	//Schedule a job for the event-dispatching thread:
    	//creating and showing this application's GUI.
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	public void run() {
            	createAndShowGUI();
        	}
    	});
	}

	  //React to menu selections.
    public void actionPerformed(ActionEvent e) {
        if ("New Item".equals(e.getActionCommand())) { //new
            InternalFrameDemo();
        } else { //quit
            try {
				wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }



	private void InternalFrameDemo() {
		// TODO Auto-generated method stub
		
	}
 
    
    
    
   
}
