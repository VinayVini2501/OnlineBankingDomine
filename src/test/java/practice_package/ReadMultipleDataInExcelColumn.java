package practice_package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataInExcelColumn {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("TestData");	
		int count = sh.getLastRowNum();
		for(int i=0; i<=count; i++)
		{
			  
				String data = sh.getRow(i).getCell(0).getStringCellValue();
				String data1 = sh.getRow(i).getCell(1).getStringCellValue();
				System.out.println(data+ "  " +data1);
			}




		}

	}
//}
