import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;


public class tester extends JPanel{
	
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
    
    public static void DirSearch ()	{
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
    
    public static void WriteDir (String directory)	{
	//This function writes the osu and music directories to the direct.txt file
	//		directory: A string input which is the directory to record.
		
		try	{
			FileWriter fw = new FileWriter ("direct.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println(directory);
	
			pw.close();
			
		} catch (IOException e)	{
			System.out.println("ERROR WRITING TO DIRECT.TXT");
		}
	}
    
	public static String ReadDir()	{
		String str;
		
		try {
			FileReader fr = new FileReader("direct.txt");
			BufferedReader br = new BufferedReader(fr);
			
			str=br.readLine();
			br.close();
			if (str !=null)	{
				return str;
			}
			
		} catch (IOException e) {
			System.out.println("file not found");
		}
		
		WriteDir("C:\\");
		return "C:\\";
	}
    
    public static void main(String[] args) {
    	
    	tester t = new tester(); 
    	JFrame window = new JFrame ();
    	window.setTitle("Osync");
    	window.setSize(300, 300);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setVisible(true);
    	window.add(t);
    	
    }

}