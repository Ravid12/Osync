package address;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DirectTxt {
	
    public static void writeToDir (String directory)	{
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
    
    
	public String readFromDir()	{
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
		
		writeToDir("C:\\");
		return "C:\\";
	}
}
