import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

//access token: 737721599747740|qANITqJEuZ7d-0pFTjEtznP9Sjc
public class datethe6ix{
	public static void main(String[] args){
		String url="https://facebook.com/v2.10/dialog/oauth";
		URLConnection connection=null;
		
		try{
			connection=new URL(url).openConnection();
		}catch(IOException e){
			System.out.print("connection error!");
		}
		connection.setRequestProperty("client_id", "737721599747740");
		connection.setRequestProperty("redirect_uri", "http://www.internest.ca");
		connection.setRequestProperty("response_type", "token");
		try{
			InputStream response=connection.getInputStream();
				try (Scanner scanner=new Scanner(response)){
		String responseBody=scanner.useDelimiter("\\A").next();
		System.out.println(responseBody);
	}
		}
		catch(IOException e){
			System.out.print("InputStream error");
		}
	//HttpURLConnection con=(HttpURLConnection) url.openConnection();
	//con.setRequestMethod("GET");
	
	

	}


}