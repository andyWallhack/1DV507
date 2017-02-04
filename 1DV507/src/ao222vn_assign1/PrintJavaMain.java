package ao222vn_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintJavaMain {

	public static void main(String[] args)  {

		File startDir = null;
		
//		Open file
		try {
			 startDir =  new File(args[0]);
		}
		catch(ArrayIndexOutOfBoundsException exception ) {
			System.err.println("File not found");
			exception.getMessage();
		}
		
		fileWriter(startDir);
	}
	/**
	 * Method that goes through directories and prints them out with file size at the end
	 * @param dir input Directory
	 */
	private static void fileWriter (File dir)  {
//		checks if there is a next directory
		if(dir.isDirectory()) {
			int depth = 0;
			if(dir.getName().charAt(0) != '.')
				depth++;
				System.out.println(dir.getName());
			
//				Adds all inner files to array sub
			File [] sub = dir.listFiles();
			for(File s : sub) {		
//				Check if java file
				int breaker = s.getName().indexOf(".");
				if(breaker > 0 ) 
					if( s.getName().substring(breaker+1, s.getName().length()).equals("java")) {
						Scanner file = null;
						try {
							 file = new Scanner(s);
						}
						catch (FileNotFoundException exception) {
							System.err.println("File not found");
						}
//						Open file and reads how many lines in file
						int counter = 0;
						while(file.hasNextLine()) {
							counter ++;
							file.nextLine();
						}
						StringBuffer buf = new StringBuffer();
						for(int i = 0; i < depth; i++)
							buf.append("       " );
						System.out.println(buf.toString() + s.getName() +  " (" + counter + ")");
					}
//				Calls method again 
				fileWriter(s);	
			}
			depth --;
		}
	}
} 
