package JSON.com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json_Example 
{   static int k=1 , i;
    public static void main( String[] args ) throws IOException, ParseException
    {JSONParser parser = new JSONParser();    
    try {
 Object obj = parser.parse(new FileReader( "src/test/resources/Example_Json.json"));
 if(obj instanceof Map) {
	 JSONObject jsonObject = (JSONObject)obj ;
	 JSON_Function((JSONObject) jsonObject);
 	}else
 	{
	 JSONArray jsonArray = (JSONArray) obj ;
 	 function((JSONArray) jsonArray);
 	}      
    } catch (FileNotFoundException e) {
    } catch (IOException ioe) {
    }       
}
    public static void JSON_Function(JSONObject jsonObj) 
    {
    	StringBuilder value = new StringBuilder();    	
        for (Object keyObj : jsonObj.keySet()) 
        {
            String key = (String)keyObj;
            Object valObj = jsonObj.get(key);
            if (valObj instanceof JSONObject) 
            {
            	System.out.println("key="+k+" : "+key);
            	k++;
            	value.append(jsonObj.get(key).toString());
                System.out.println("value==>"+value);
                JSON_Function((JSONObject) valObj);
            }else
            if (valObj instanceof JSONArray) 
            {
            	System.out.println("key="+k+" : "+key);
            	k++;
                System.out.println("value==>"+valObj.toString());
                JSONArray no_of_key = (JSONArray)jsonObj.get(key);
                for( i=0 ; i<no_of_key.size();i++)
                {    
                	
                	JSONObject innerObj = (JSONObject)no_of_key.get(i);
                	JSON_Repeat_Function((JSONObject) innerObj );
                }      
            }else 
            {
                System.out.println("key="+k+" : "+key);
                k++;
                System.out.println("value : "+valObj.toString());
            }
        }
    }
	public static void JSON_Repeat_Function(JSONObject jsonObj1) 
	{
	    for (Object keyObj1 : jsonObj1.keySet()) 
	    {
	        String key1 = (String)keyObj1;
	        Object valObj1 = jsonObj1.get(key1);
	        if (valObj1 instanceof JSONObject) 
	        {
	        	System.out.println("key="+k+" : "+key1);
	        	k++;
	            System.out.println("value==>"+jsonObj1.get(key1));
	            JSON_Repeat_Function((JSONObject) valObj1);
	        }else
	        {
	            System.out.println("key="+k+" : "+key1);
	            k++;
	            System.out.println("value :"+jsonObj1.get(key1));
	        }
	    }
	}
	public static void function(JSONArray jsonArray)
	{
 		System.out.println("JSONARRAY");
 		System.out.println(jsonArray.size());
        for(int i=0 ; i<jsonArray.size();i++) {
        	JSONObject obj1 = (JSONObject)jsonArray.get(i);
        	JSON_Function((JSONObject) obj1);
        }         
	}
}	
            

    