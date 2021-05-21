package Week5Day2Assignment;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcell {
	public static String[][] readExcellData(String sheetName) throws InvalidFormatException, IOException
	{
		//To get test data excell
		File filename = new File("D:\\Roobini\\Training\\TestData.xlsx");
		XSSFWorkbook wbook = new XSSFWorkbook(filename);
		//To get worksheet
		XSSFSheet sheet = wbook.getSheet(sheetName);
		//To get row and column
		int row = sheet.getLastRowNum();
		int column = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[row][column];
		for(int i=1;i<=row;i++)
		{
			XSSFRow r = sheet.getRow(i);
			for(int j=0;j<column;j++)
			{
				XSSFCell cell = r.getCell(j);
				System.out.println(cell.getStringCellValue());
				data[i-1][j] = cell.getStringCellValue();
			}
		}
		return data;
		
	}
	

}












