package address.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Directory {
	
    public static void writeToFile (String directory)	{
	//This function writes the a directory to the direct.txt file		
		try	{
			FileWriter fw = new FileWriter ("direct.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println(directory);
			pw.close();
			
		} catch (IOException e)	{
			System.out.println("ERROR WRITING TO DIRECT.TXT");
		}
	}
    
    
	public static String loadFromFile()	{
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
		
		writeToFile("C:\\");
		return "C:\\";
	}

}
