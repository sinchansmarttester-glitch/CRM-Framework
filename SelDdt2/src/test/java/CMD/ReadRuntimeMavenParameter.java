package CMD;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameter {
	@Test
	public void RuntimeParameterTest()
	{
		String URL=System.getProperty("url");
		String BROWSER=System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		System.out.println("Env Data ==>URL ====>"+URL);
		System.out.println("Browser Data ==>BROWSER ====>"+BROWSER);
		System.out.println("Username Data ==>USERNAME ====>"+USERNAME);
		System.out.println("Password Data ==>PASSWORD ====>"+PASSWORD);
	}

}
