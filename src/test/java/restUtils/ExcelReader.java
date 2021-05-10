package restUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader  {

	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public String excelPath = "./ExternalData/ApiData.xlsx";

	public int getRowCount(String sheetName) throws IOException {
		fis = new FileInputStream(excelPath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum(); //Finds the last ROW Number
		workbook.close();
		fis.close();
		return rowCount;
	}

	public int getColumnCount(String sheetName, int rowNum) throws IOException {
		fis = new FileInputStream(excelPath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);//find ROW number
		int cellCount = row.getLastCellNum();//to get the last CELL Number in a ROW.
		workbook.close();
		fis.close();
		return cellCount;

	}

	public String getCellData(String sheetName, int rowNum, int colNum) throws Exception {
		fis = new FileInputStream(excelPath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum); //get ROW
		cell = row.getCell(colNum); //get CELL
		DataFormatter dataFormatter = new DataFormatter();//Returns the formatted value of the CELL as String regardless of CELL type
		String data;
		data = dataFormatter.formatCellValue(cell);
		workbook.close();
		fis.close();
		return data;
	}

}
