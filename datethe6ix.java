import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;
import java.io.FileWriter;
import org.json.*;

//javac -cp /usr/share/java/json-20160212.jar JsonParser.java
// java -cp ".;java-json.jar" datethe6ix

//access token: 737721599747740|qANITqJEuZ7d-0pFTjEtznP9Sjc
public class datethe6ix{
	public static void main(String[] args){
		String url="https://graph.facebook.com/search?q=music&type=event&access_token=EAACEdEose0cBAPuXnTbZCRmmuGcKfZB8GjhEuuqRIF1a4AE0LIlYBOnbZBwubbZAE2MvIx9YdcpZBQqs7KuwZCXqMZBZCZBO9AzfWVM3LTr1rFMQC2K7OdqKDpnwjL1lDgBEWhmzsHlNlU37YzL94JsIzQZCYjruwshxjwRZCEjl6xkZAJwfFvrUyNe9IjUVf13yluTRTXun0TDZCXQZDZD";
		URLConnection connection=null;
		
		try{
			connection=new URL(url).openConnection();
		}catch(IOException e){
			System.out.print("connection error!");
		}
		//connection.setRequestProperty("q", "food");
		//connection.setRequestProperty("type", "event");
		//connection.setRequestProperty("access_token", "EAACEdEose0cBAKfqZCX5kRDZAV0vUKeIfBoBDXlPMoo1jb3lAOJhgizQ5pWVOpNSZAGILgrNlDMG69Bhubpg6Qt9TrX7HqfhZAoaxiqI6Hdb8kaH2gJu0PLC89Cx7c1qNKkZAaH2W34mxyRdZAB8oVmRxL2JsD8htm2GIL3aLBGYCzxPpuR3VkzZAh08PreTybmomkLYTk1YAZDZD");
		try{
			InputStream response=connection.getInputStream();

			try (Scanner scanner=new Scanner(response)){
				String responseBody=scanner.useDelimiter("\\A").next();
				JSONObject resobj=null;
				try{
					resobj=new JSONObject(responseBody);
					//System.out.println(resobj);
				}
				catch(JSONException e){
					System.out.println(e);
				}

				try{
					FileWriter writer = new FileWriter("6ix.txt");
					writer.write(resobj.toString());
					//writer.close();
				} catch (IOException e) {
					System.out.println("Stop!");
					System.out.println(e);
				}
				System.out.println("Done!");
			}
		}
		catch(IOException e){
			System.out.println("No");
			System.out.print(e);
		}
	//HttpURLConnection con=(HttpURLConnection) url.openConnection();
	//con.setRequestMethod("GET");



	}


}