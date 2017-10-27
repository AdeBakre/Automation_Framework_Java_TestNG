package com.automation.interview.testng.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.text.WordUtils;

public class BaseUtility {
	
	   Properties prop = new Properties();
	   InputStream input = null;  
	   WordUtils wordUtils = new WordUtils();
	
	   public Properties loadProperties(String filename)
	   {
		   prop = new Properties();
		   String propValue = null;
		   try{
			   input = getClass().getClassLoader().getResourceAsStream(filename);			   
			   if(input != null){
				   prop.load(input);
			   }
			   else{
				   throw new FileNotFoundException("property file'"+filename+"'not found in the classpath");
			   }
		   }catch(IOException er){
			   er.printStackTrace();
		   }
		   finally{
			   if(input!=null){
				   try{
					   input.close();
				   }
				   catch(IOException e){
					   e.printStackTrace();
				   }
			   }
		   }  
		return prop;
	   }
	   
		public void sleep(int seconds) {
	        try {
	            Thread.sleep(seconds * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}
