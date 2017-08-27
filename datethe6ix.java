
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;
import org.json.*;
import org.apache.commons.io.FileUtils;
import java.util.ArrayList;


//javac -cp /usr/share/java/json-20160212.jar JsonParser.java
// java -cp ".;java-json.jar;commons-io-2.5.jar;commons-io-2.5-javadoc.jar" datethe6ix

//access token: 737721599747740|qANITqJEuZ7d-0pFTjEtznP9Sjc
public class datethe6ix{
	public static String photo(String link){
		//System.out.println(link);
		String url=null;
		URLConnection connection=null;
		try{
			connection=new URL(link).openConnection();
		}catch(IOException e){
			System.out.println("connection error1!");
		}

		try{
			InputStream response=connection.getInputStream();

			try(Scanner scanner=new Scanner(response)){
				String responseBody=scanner.useDelimiter("\\A").next();
				
				JSONObject resobj=null;
				try{
					resobj=new JSONObject(responseBody);

					JSONObject newobj=(JSONObject) resobj.optJSONObject("data");
					
					url=newobj.getString("url");
					System.out.println(url);
					/* JSONObject img = array.getJSONObject(0);
					 System.out.println(img);
					 url=img.getString("url");*/
  //get your values
  
					//System.out.println(resobj);
					
					//url=resobj.getString("url");
					//System.out.println(url);
				}
				catch(JSONException e){
					System.out.println(e);
				}
				
			}
		}
		catch(IOException e){
			System.out.println("Nola");
			System.out.print(e);
		}
		return url;
	}



	 public static void column(ArrayList<String> list){
        BufferedReader br=null;
        BufferedWriter bw=null;
        final String lineSep=System.getProperty("line.separator");

        try {
            File file = new File("json.csv");
        File file2 = new File("app.csv");//so the
                    //names don't conflict or just use different folders

        br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
        String line = null;
        int i=0;
        for ( line = br.readLine(); line != null; line = br.readLine(),i++)
        {               

            String addedColumn = list.get(i);
            bw.write(line+","+addedColumn+lineSep);
        }

    }catch(Exception e){
        System.out.println(e);
    }finally  {
        if(br!=null)
            try{
            br.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        if(bw!=null)
            try{
            bw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

}




	public static void main(String [] args){
		String url="https://graph.facebook.com/search?q=music&type=event&access_token=EAACEdEose0cBAEvdBAxnLBqZCZBifou1gRCw6ewZCVGoW2ESlFdJRge0ota62GBfDHCJXYTRjMWAjtZBPCUlLZBhqQAA3QmrJDOfjaGZBeZBV7yhUz2jgDfWLaimorvtkDEFDcfWjZCubjJZAByBTZAzFfqOMhFWjROmSAeN3vVDBBJrgRDEVX4hI3OGOo8HDb5yxChxQyUrDdSQZDZD";
		ArrayList<String> urllist=new ArrayList<String>();
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
					JSONArray doc=resobj.getJSONArray("data");

					

					for (int i=0; i<doc.length(); ++i){
						JSONObject one=doc.getJSONObject(i);
						String id=one.getString("id");
						String pic="https://graph.facebook.com/"+id+"/picture?redirect=0";
						String link=photo(pic);
						urllist.add(link);

						//System.out.println(link);
					}

					File file=new File("json.csv");
					String csv=CDL.toString(doc);
					FileUtils.writeStringToFile(file, csv);
					column();
					
					//System.out.println(resobj);
				}
				catch(JSONException e){
					System.out.println(e);
				}
				catch(IOException e){
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