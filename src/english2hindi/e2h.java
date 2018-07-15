package english2hindi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
public class e2h {

	
	static String data ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {			
			data = readfile();
			//URL url = new URL("https://www.google.com/inputtools/request?text=How are you&ime=transliteration_en_hi");http://localhost:8080/RESTfulExample/json/product/get
			URL url = new URL("http://localhost:8080/RESTfulExample/json/product/get");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	
	public static String readfile() throws IOException {
		
		File f = new File(System.getProperty("user.dir") + "//src//file//english.txt");
		BufferedReader br = null;
		String st=null;
		String data = null;
		try {
			br = new BufferedReader(new FileReader(f));
			data = br.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		  while ((st = br.readLine()) != null) {
		    System.out.println(st);		 
		    break;
		  }
		
		return st;
		
	}
	

}
