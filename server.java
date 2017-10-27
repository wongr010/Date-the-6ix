//package com.opencsv;
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
import org.json.*;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;

public class server{
    public static void main(String[] args){
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

            String addedColumn = "noo";
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
}
