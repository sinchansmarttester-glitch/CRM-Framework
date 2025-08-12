package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream f=new FileInputStream("E:\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		Sheet sh=wb.getSheet("Sheet1");
        Row row=sh.getRow(1);
        String c1=row.getCell(0).toString();
        String c2=row.getCell(1).toString();
        String c3=row.getCell(2).toString();
        System.out.println(c1+"\t"+c2+"\t"+c3);
        wb.close();
        
	}

}
