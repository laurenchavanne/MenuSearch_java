// Filename: MenuSearch.java
// Author: Lauren
// Date: 2/12/19

import java.util.*;
import javax.swing.*;

public class MenuSearch 
{
	public static void main(String[] args)
	{
		// Variables and constants
		String[] menuChoices = new String[10];
		String entry = "", menuString = "";
		int x = 0;
		int numEntered;
		int highestSub = menuChoices.length - 1;
		
		Arrays.fill(menuChoices, "zzzzzzzz");
		
		menuChoices[x] = JOptionPane.showInputDialog(null, "Enter an item for today's menu, or type zzz to quit");
		
		while(!menuChoices[x].equalsIgnoreCase("zzz") && x < highestSub)
		{
			menuString = menuString + menuChoices[x] + "\n";
			++x;
			if(x < highestSub)
			{
				menuChoices[x] = JOptionPane.showInputDialog(null, "Enter an item for today's menu, or type zzz to quit");	
			}
		}
		numEntered = x;
		
		// When the menu is complete, display it for the user and allow them to request an item 
		entry = JOptionPane.showInputDialog(null, "Today's menu is:\n" + menuString + "Please make a selection: ");
		
		// Perform sort before doing any binary search
		Arrays.sort(menuChoices, 0, numEntered);
		
		// Search for the requested entry in the now sorted array 
		x = Arrays.binarySearch(menuChoices, entry);
		
		// if statement checks for any non-negative value taht was returned by the binary search
		if(x >= 0 && x < numEntered)
		{
			JOptionPane.showMessageDialog(null, "Excellent choice!");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry - that item is NOT on tonight's menu!");
		}
	}
}