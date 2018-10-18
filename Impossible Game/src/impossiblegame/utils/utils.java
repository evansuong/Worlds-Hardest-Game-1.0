package impossiblegame.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class utils {
	
	public static String fileToString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return builder.toString();	
	}
	
	public static int toInteger(String number) {
		return Integer.parseInt(number);
	}
}
