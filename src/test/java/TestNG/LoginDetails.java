package TestNG;

import org.testng.annotations.DataProvider;

public class LoginDetails {

    @DataProvider(name = "loginInfo")
    public Object[][] loginData() {
        Object[][] objArr = new Object[1][2]; 
        objArr[0][0] = "admin";  
        objArr[0][1] = "admin";  
        return objArr;
    }
}