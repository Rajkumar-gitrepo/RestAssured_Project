package apiCalls;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import restUtils.ExcelReader;

public class BaseTest extends restUtils.ExcelReader{

	public static FileInputStream fis;
	public static Properties pro;
	public static ExcelReader reader;
	
	@BeforeClass
	public static void readPropertyFile() throws IOException
	{
		 fis = new FileInputStream("./src/test/java/restUtils/utilities.properties");
		 pro = new Properties();
		 pro.load(fis);
	}
	
	//update passenger details
		@DataProvider
		public String[][] updatePasenger() throws Exception {
			reader = new ExcelReader();
			int totalRows = reader.getRowCount("UpdatePassenger");
			int totalColumns = reader.getColumnCount("UpdatePassenger", totalRows);

			String loginData[][] = new String[totalRows][totalColumns];
			for (int i = 1; i <= totalRows; i++) {
				for (int j = 0; j < totalColumns; j++) {
					loginData[i - 1][j] = reader.getCellData("UpdatePassenger", i, j);
				}
			}
			return loginData;

		}
}
