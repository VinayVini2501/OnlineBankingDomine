package practice_package;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("TestData").getRow(1).getCell(0).getStringCellValue();	
		System.out.println(data);
	
	

	}

}
