import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class excel单元格加竖线 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("C:\\Users\\Administrator\\Desktop\\用于加竖线.xlsx");
		File xlsxFile=new File("C:\\Users\\Administrator\\Desktop\\竖线添加后.xlsx");
		File txtFile=new File("C:\\Users\\Administrator\\Desktop\\竖线添加后.txt");
		FileWriter fw=new FileWriter(txtFile);
		XSSFWorkbook toWorkbook=new XSSFWorkbook();
		Sheet toSheet=toWorkbook.createSheet("sheet");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheetAt(0);
		int i=0;
		for (Row row : sheet) {
			Row toRow=toSheet.createRow(i++);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				String value=row.getCell(j).getStringCellValue();
				System.out.print(value);
				if(j==0)
				{
					toRow.createCell(j).setCellValue("|"+value+"|");
					fw.write("|"+value+"|");
				}
				else
				{
					toRow.createCell(j).setCellValue(value+"|");
					fw.write(value+"|");
				}
					
			}
			fw.write("\n");
			System.out.println();
		}
		workbook.close();
		fis.close();
		
		fw.close();
		
		FileOutputStream fos=new FileOutputStream(xlsxFile);
		toWorkbook.write(fos);
		toWorkbook.close();
		fos.close();
	}

}
