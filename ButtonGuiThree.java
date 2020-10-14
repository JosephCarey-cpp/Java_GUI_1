/*
Name: Joseph Carey
Program: Chapter 9 Sample Program 9.9 ButtonGuiThree.java
Date: 10/11/2020
Description: Shows how to make a GUI program with buttons and events, and implemented the BoxLayout manager
*/
// To Compile in terminal type: javac ButtonGuiThree.java
// To Run the program in terminal type java ButtonGuiThree
/// To Compile & Run at the same time type: compile ButtonGuiThree
/// NOTE: must have compile.bat in order to do above
import javax.swing.*;
import java.awt.event.*; // this is needed for the event handlers
import java.awt.Container; // need this to add controls
import java.awt.Component; // need this for BoxLayout

public class ButtonGuiThree extends JFrame
{
    private JFrame mainFrame;
    private JButton firstB; // Phase 1 - Step 1 (part 1): Declare a button variable name
    private JButton secondB; /// ADDED another button
    public ButtonGuiThree() // a constructor
    {
        mainFrame = new JFrame("Example of a GUI with a button");

        // create a button object
        //Phase 1 - Step 1 (part 2): Instantiate a button, and put the text "Press me" in it (part 2)
        firstB = new JButton("Press me");

        /// ADDED another button
        secondB = new JButton ("Or press me?");

        // get the content pane
        // Phase 1 - Step 2 (part 1) : Get the content pane of JFrame
        Container c = mainFrame.getContentPane();

        mainFrame.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS)); /// ADDED: a layout for multiple buttons

        // add the button to the Container
        // Phase 1 - Step 2 (part 2): Add the button to the content pane of JFrame
        firstB.setAlignmentX(Component.CENTER_ALIGNMENT); /// ADDED - since we have a layout, it needs to be aligned
        //^^^^^^^^^^^^^^^^^^ALIGN BUTTON
        c.add(firstB); // then add it

        secondB.setAlignmentX(Component.CENTER_ALIGNMENT); /// ADDED - since we have a layout, it needs to be aligned
        c.add(secondB); /// ADDED the addition of the button to the content pane

        // create a ToolTip, when you mouse over the button, the text "This is a button" will appear
        // this is a shortcut, if you press ALT + p, the button will be pressed
        firstB.setToolTipText("This is a button");
        firstB.setMnemonic('p');

        /// ADDED a ToolTip and a shortcut for the second button
        secondB.setToolTipText("This is another button");
        secondB.setMnemonic('o');

        mainFrame.setSize(300,300); // MODIFIED the pane size

        // define and register window event handler
        // Phase 2 - Step 1: Write the code for an event handler class (a listener class)
        mainFrame.addWindowListener(new WindowAdapter()
        {// anonymous class!!
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        // MODIFIED the button handlers since there is now 2 events
        // create and register the button event handler
        // Phase 2 - Step 2: Create an instance of the event handler class (a listener class)
        ButEventHandler1 bhandler = new ButEventHandler1();
        ButEventHandler2 bhandler2 = new ButEventHandler2(); /// ADDED another handler

        // Phase 2 - Step 3: Register the handler class (a listener class)
        firstB.addActionListener(bhandler);
        secondB.addActionListener(bhandler2); /// ADDED: created the button and registered it

        mainFrame.setVisible(true);
    }

    // inner class for the button event handler
    class ButEventHandler1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "Button 1 was pressed",
                    "First Event Handler Message", JOptionPane.INFORMATION_MESSAGE);
            // modified the handler message message and title
        }
    }//end of listener class


    /// ADDED another inner class for the button event handler
    class ButEventHandler2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "Button 2 was pressed",
                    "Second Event Handler Message", JOptionPane.INFORMATION_MESSAGE);
            // modified the handler message message and title
        }
    }//end of listener class

    public static void main(String[] args)
    {
        new ButtonGuiThree(); // automatically calls the constructor
    }
} // end of Button GUI Three Class

/*Program Test Runs:
With Original Code:
C:\Users\Joseph Carey\Desktop\Fall2020_CSIS24_programs>compile ButtonGuiThree
C:\Users\Joseph Carey\Desktop\Fall2020_CSIS24_programs>javac ButtonGuiThree.java
C:\Users\Joseph Carey\Desktop\Fall2020_CSIS24_programs>java ButtonGuiThree

With Modified Code:
C:\Users\Joseph Carey\Desktop\Fall2020_CSIS24_programs>compile ButtonGuiThree
C:\Users\Joseph Carey\Desktop\Fall2020_CSIS24_programs>javac ButtonGuiThree.java
C:\Users\Joseph Carey\Desktop\Fall2020_CSIS24_programs>java ButtonGuiThree
*/