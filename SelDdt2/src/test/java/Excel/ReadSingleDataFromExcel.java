package Excel;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSingleDataFromExcel {

	public static void main(String[] args) throws Throwable, Throwable  {
	FileInputStream f=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(f);
	Sheet sh=wb.getSheet("Sheet1");
	Row row=sh.getRow(1);
	String cel=row.getCell(2).toString();
	//String data=cel.getStringCellValue().toString();
	System.out.println(cel);
	wb.close();
	}

}
