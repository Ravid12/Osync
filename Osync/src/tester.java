import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;


public class tester extends JPanel  {
	
//Not sure what this is for, eclipse told me to put it in.
	private static final long serialVersionUID = 3896634138026354101L;
	
	static String currentDir = ReadDir();
	static JTextField directoryDisplay = new JTextField(currentDir);
	
    public tester() {

    	int firstX = 0;
    	int firstY = 0; 	
    	
        JButton directoryButton;        
        directoryButton = new JButton("Locate Directory");
        directoryButton.setActionCommand("DirectorySearch");
        directoryButton.addActionListener(new ButtonClickListener());
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        gbc.weightx = 0.5;
        
        //Locate Directory Button
        gbc.gridx = firstX;
        gbc.gridy = firstY;
        gbc.gridwidth = 1;
        add(directoryButton, gbc);

        //Current Directory Text Field
        gbc.gridx = firstX + 1;
        gbc.gridy = firstY;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        directoryDisplay.setEditable(false);
        add(directoryDisplay, gbc);
    }
    
    public static void DirSearch ()  {
    		JFileChooser fc = new JFileChooser();
    		fc.setCurrentDirectory(new java.io.File("C:/" ));
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        	String dir;

            //Handle open button action.
            fc.showOpenDialog(null);
            
            dir=fc.getSelectedFile().getAbsolutePath();
            tester.directoryDisplay.setText(dir);
            WriteDir(dir);  // writes directory to direct.txt
    }
//writes the osu and music directories to the direct.txt file
    public static void WriteDir (String directory)  {
		try  {
			FileWriter fw = new FileWriter ("direct.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println(directory);
	
			pw.close();
			
		} catch (IOException e)	{
			System.out.println("ERROR WRITING TO DIRECT.TXT");
		}
	}
	
//Reads direct.txt to find last directory
	public static String ReadDir()  {
		String str;
		
		try  {
			FileReader fr = new FileReader("direct.txt");
			BufferedReader br = new BufferedReader(fr);
			
			str=br.readLine();
			br.close();
			if (str !=null)  {
				return str;
			}
			
		} catch (IOException e)  {
			System.out.println("file not found");
		}
		
		WriteDir("C:\\");
		return "C:\\";
	}
    
    public static void main(String[] args)  {
    	
    	tester t = new tester(); 
    	JFrame window = new JFrame ();
    	window.setTitle("Osync");
    	window.setSize(300, 300);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setVisible(true);
    	window.add(t);
    	
    }

}
