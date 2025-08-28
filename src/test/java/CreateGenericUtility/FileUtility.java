package CreateGenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertiesFile(String key) throws IOException {
	FileInputStream f=new FileInputStream(".\\configAppData\\DDT.properties");
	Properties p=new Properties();
	p.load(f);
	String data=p.getProperty(key);
	return data;
	}
}
