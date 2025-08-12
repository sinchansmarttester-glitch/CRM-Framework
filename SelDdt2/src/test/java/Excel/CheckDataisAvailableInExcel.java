package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CheckDataisAvailableInExcel {

	public static void main(String[] args) throws IOException {
		String expectedtestId = "TC_02";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		//boolean flag=false;
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestDataBengaluru.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();

		for (int i = 0; i <= rowcount; i++) {
			try {
				String data = sh.getRow(i).getCell(0).toString();
				if (data.equals(expectedtestId)) {
					//flag=true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();
					System.out.println(data1);
					System.out.println(data2);
					System.out.println(data3);
				}
			} catch (Exception e) {
			
			}
		}

		
//		if (flag==true) {
//			System.out.println(data1);
//			System.out.println(data2);
//			System.out.println(data3);
//		} else {
		//	System.out.println(expectedtestId + " data is not available");
		//}

		wb.close();
	}
}

