package CreateGenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\TestCaseToScript.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\TestCaseToScript.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		int data=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return data;
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int celNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\TestCaseToScript.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fo=new FileOutputStream(".\\src\\test\\resources\\TestCaseToScript.xlsx");
        wb.write(fo);
        wb.close();
	}
	 public String getCellDataAsString(String sheetName, int rowNum, int cellNum) throws IOException {
	        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestCaseToScript.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sheet = wb.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);
	        Cell cell = row.getCell(cellNum);
	        String data = cell.toString(); 
	        wb.close();
	        return data;
	    }

	    public void fetchDataFromExcelSheet(String sheetName) throws IOException {
	        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestCaseToScript.xlsx");
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);
            int columnCount = sheet.getRow(0).getLastCellNum();

	        for (Row row : sheet) {
	            for (int i = 0; i < columnCount; i++) {
	                Cell cell = row.getCell(i);
	                String value = (cell == null) ? "" : cell.toString();
	                System.out.print("| " + value + " ");
	            }
	            System.out.println("|");
	        }

	        workbook.close();
	        fis.close();
	    }

}