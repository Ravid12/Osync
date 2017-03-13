import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener	{
    	public void actionPerformed(ActionEvent e)	{
    		String command = e.getActionCommand();
    		
    		if (command.equals("DirectorySearch"))	{
    			tester.DirSearch();  			    			
    		}
    	}
    }