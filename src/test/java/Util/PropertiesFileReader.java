package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
	private Properties prop;
	
	public PropertiesFileReader(String filePath){
		
		File src = new File(filePath);
		FileInputStream input;
		
		try { 
			input = new FileInputStream(src);
			prop = new Properties();
			prop.load(input);
			
		} catch(IOException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	
	}
	
	public String getValue(String key) {
		
		return prop.getProperty(key);
	}
}
