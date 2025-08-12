package CreateGenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandomNumber() {
	Random ran=new Random();
	int randomNum=ran.nextInt(5000);
	return randomNum;
}
public String getSystemDateYYYYDDMM()
{
	Date d=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String date=sdf.format(d);
	return date;
}
public String getRequiredDateYYYYDDMM(int days)
{
	Date d=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String date=sdf.format(d);
    Calendar c=sdf.getCalendar();
    c.add(Calendar.DAY_OF_MONTH,days);
    String reqDate=sdf.format(c.getTime());
    return reqDate;
	
}
}
