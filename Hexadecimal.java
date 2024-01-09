import java.util.*; 
import java.io.*; 

/**
 * Salim Mohamed 
 * 20 February 2023
 * this program takes in a string with a hexadecimal ACSII code, (base 16), and will output the equivalent value in base 10. 
 * the hexadecimal is identifies with a % and the updated value will be put back into the string in the same place. 
 */
public class Hexadecimal {
	
	/**
	 * this is the main method, that does everyhting because there are no other methods lol! 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// string that will be set to equal the input string from the file. 
		String line = "";
		
		// this try-catch reads in a string from the file and locates the ACSII hex code. then, it changes it from base 16 to base 10. 
		// then it will replace the hex with the equivalent character to the base 10 value and print it to the screen. 
		try {
			BufferedReader inFile = new BufferedReader (new FileReader("Input.txt")); 
			while ((line = inFile.readLine())!=null) {
				int pos = 0; 
				while (line.indexOf("%", pos) > -1) { 
					pos = line.indexOf("%",pos)+1; 
					int hex = Integer.parseInt(line.substring(pos, pos+2), 16); 
					char replace = (char) hex; 
					line = (line.substring(0, pos-1) + replace + line.substring(pos+2));
				}
					System.out.println(line);
			}
			inFile.close ();
		}
		catch (FileNotFoundException e) {
			System.out.println("No file");
		}	
		catch (IOException e) {
			System.out.println("IOException");
		}	
	}
}
