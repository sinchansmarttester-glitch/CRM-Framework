package CreateGenericUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws IOException, ParseException
	{
		FileReader file=new FileReader(".\\configAppData\\DDT1.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(file);
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("url"));
		String data=(String)map.get(key);
		return data;
	}
}
