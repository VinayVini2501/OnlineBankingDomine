package com.onlineBanking.genericutilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtility
{
	/**
	 * its used to read the data from Excel base don below the arguments
	 * @param SheetName
	 * @param rowNum
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String SheetName, int rowNum, int CellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(rowNum).getCell(CellNum).getStringCellValue();
		return data;
	}

	/**
	 *  This method is used to get LastRow Number
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowCount(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;	
	}
	
	/**
	 * This method is used to  Write data into Excel
	 * @param SheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void WriteDataExcel(String SheetName, int rowNum, int celNum, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstantants.ExcelPath);
		wb.write(fos);
	}

	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public ArrayList<String> getList(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		ArrayList<String> all = new ArrayList<String>();
		for(int i=0; i<count; i++)
		{
			String values = sh.getRow(i).getCell(1).getStringCellValue();
		}
		return all;
	}

	public Map<String, String> getList1(String sheetName, int keyCell, int valueCell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		Map<String, String> map =new HashedMap<String, String>();
		for(int i=0; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCell).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
}
