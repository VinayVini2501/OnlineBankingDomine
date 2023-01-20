package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsetdataInToExcel {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("TestData");
		Row r = sh.createRow(6);
		Cell cel = r.createCell(0);
		cel.setCellValue("jmc2");

		FileOutputStream fos = new FileOutputStream("./src/test/resources/Testdata.xlsx");
		wb.write(fos);



	}

}
