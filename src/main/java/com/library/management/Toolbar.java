package com.library.management;
//import the packages for using the classes in them into the program

import javax.swing.*;

public class Toolbar extends JToolBar {
	/***************************************************************************
	 ***      declaration of the private variables used in the program       ***
	 ***************************************************************************/

	//for creating the buttons to use them in ToolBar
	public JButton[] button;
	//for creating the name of the image file 24*24
	public String[] imageName24 = { "com/library/management/images/Add24.gif", "com/library/management/images/List24.gif",
            "com/library/management/images/List24.gif", "com/library/management/images/List24.gif", "com/library/management/images/Edit24.gif",
            "com/library/management/images/Delete24.gif", "com/library/management/images/Information24.gif",
            "com/library/management/images/Add24.gif", "com/library/management/images/List24.gif", "com/library/management/images/Edit24.gif",
            "com/library/management/images/Delete24.gif", "com/library/management/images/Information24.gif",
            "com/library/management/images/Find24.gif", "com/library/management/images/Export24.gif", "com/library/management/images/Import24.gif",
            "com/library/management/images/Help24.gif", "com/library/management/images/About24.gif", "com/library/management/images/Print24.gif",
            "com/library/management/images/Exit24.gif" };
	//for creating the tipText for the toolbar
	public String[] tipText = {"Add Books", "List All Books", "List Availble Books",
	                           "List Borrowed Books", "Edit Books", "Remove Books", "Book Information",
	                           "Add Members", "List Members", "Edit Members", "Remove Members", "Member Information",
	                           "Search", "Borrow Books", "Return Books", "Help", "About", "Print", "Exit"};

	public Toolbar() {
		button = new JButton[19];
		for (int i = 0; i < imageName24.length; i++) {
			if (i == 7 || i == 12 || i == 15 || i == 17)
			//for adding separator to the toolBar
				addSeparator();
			//for adding the buttons to toolBar
			add(button[i] = new JButton(new ImageIcon(ClassLoader.getSystemResource(imageName24[i]))));
			//for setting the ToolTipText to the button
			button[i].setToolTipText(tipText[i]);
		}
	}
}