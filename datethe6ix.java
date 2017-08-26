import java.net.*;
import java.io.*;

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
		try{
			InputStream response=connection.getInputStream();
		}
		catch(IOException e){
			System.out.print("InputStream error");
		}
	//HttpURLConnection con=(HttpURLConnection) url.openConnection();
	//con.setRequestMethod("GET");

		

	}
}