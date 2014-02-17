import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import javax.swing.JFormattedTextField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
 
import javax.swing.JPanel;
import javax.swing.JScrollPane;

 
import java.awt.event.*;
import java.awt.*;
 
/*
 * InternalFrameDemo.java requires:
 *   MyInternalFrame.java
 */
public class InternalFrameDemo extends JFrame
                               implements ActionListener {
    JDesktopPane desktop;
 
    public InternalFrameDemo() {
        super("InternalFrameDemo");
 
        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
 
        //Set up the GUI.
        desktop = new JDesktopPane(); //a specialized layered pane
        //createFrame(); //create first "window" //took out so we don't have a starting note
        setContentPane(desktop);
        setJMenuBar(createMenuBar());
 
        //Make dragging a little faster but perhaps uglier.
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }
 
    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
    	JMenu menu, submenu;
    	JMenuItem menuItem;
    	JRadioButtonMenuItem rbMenuItem;
    	JCheckBoxMenuItem cbMenuItem;

        
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
        menuItem = new JMenuItem("New Note");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("new");
        menuItem.addActionListener(this);
        menu.add(menuItem);
    	
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
    			JOptionPane.showMessageDialog(null, "What's up, 370 class?");
    			new InternalFrameDemo();
    		}
    	}
    	);
    	menu.add(menuItem);
 
//    	ImageIcon icon = createImageIcon("images/middle.gif");
    	//menuItem = new JMenuItem("Close", icon);
    	menuItem.setAccelerator(KeyStroke.getKeyStroke(
            	KeyEvent.VK_F4, ActionEvent.ALT_MASK));
    	menuItem.setMnemonic(KeyEvent.VK_B);
    	menu.add(menuItem);
 
    	//menuItem = new JMenuItem(icon);
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
   	      
        
        
        
        //Set up the lone menu.
        menu = new JMenu("Document");
        menu.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menu);
 
        //Set up the first menu item.
        menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("new");
        menuItem.addActionListener(this);
        menu.add(menuItem);
 
        //Set up the second menu item.
        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);
 
        return menuBar;
    }
 
    //React to menu selections.
    public void actionPerformed(ActionEvent e) {
        if ("new".equals(e.getActionCommand())) { //new
            createFrame();
        } else { //quit
            quit();
        }
    }
 
   
    protected Component textfield()
    {
		
    	return new JTextArea("");
    	
    	
    	
    }
  

	//Create a new internal frame.
    protected void createFrame() {
        MyInternalFrame frame = new MyInternalFrame();
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);
        frame.add(textfield());
        
        
        
        
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
 
    //Quit the application.
    protected void quit() {
        System.exit(0);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
 
        //Create and set up the window.
        InternalFrameDemo frame = new InternalFrameDemo();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Display the window.
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
}
