package proj.proj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
/**
 * Hello world!
 *
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App
{
    public static void main(String args[]) throws IOException, ParseException
    {
    FileWriter	fw = new FileWriter("data.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        
        
    	
    	
    	        	FileReader fr = new FileReader("t.json");
            BufferedReader in = new BufferedReader(fr);
            String str;
            while ((str = in.readLine()) != null) 
            { JSONParser parser = new JSONParser();
                Object object = parser
                        .parse(str);
                
                //convert Object to JSONObject
                JSONObject jsonObject = (JSONObject)object;
                
              String reviewerID=(String) jsonObject.get("reviewerID");
    		String asin=(String) jsonObject.get("asin");
               String reviewerName=(String) jsonObject.get("reviewerName");
               JSONArray  helpful=(JSONArray)jsonObject.get("helpful");
               String reviewText=(String)jsonObject.get("reviewText");
               Double overall=(Double) jsonObject.get("overall");
               String summary =(String) jsonObject.get("summary");
               Long unixReviewTime=(Long) jsonObject.get("unixReviewTime");
               String reviewTime=(String) jsonObject.get("reviewTime");
                String rt="";
                
                //Reading the String
                String name = (String) jsonObject.get("Name");
                Long age = (Long) jsonObject.get("Age");
                
                //Reading the array
             
                for(Object helpfuls : helpful)
                {
                    rt=rt+","+helpfuls.toString();
                }
            
                String val=reviewerID+","+asin+","+reviewerName+","+helpful+","+reviewText+","+overall+","+summary+","+unixReviewTime+","+reviewTime;
                
            out.println(val);

            
            }
            in.close();
            out.close();

    }}