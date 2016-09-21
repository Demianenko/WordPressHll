package hill.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;

public class ReaderFromXLSX {
    @DataProvider(name = "new")
    public static Object[][] readFromExcel() throws IOException {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream("src\\test\\resources\\dataForLogin.xlsx"));
        XSSFSheet sheet = myExcelBook.getSheetAt(0);
        int totalNoOfRows = sheet.getLastRowNum() + 1;
        String[][] arrayExcelData = new String[totalNoOfRows][2];
        for (int i= 0 ; i < totalNoOfRows; i++) {
            Row row = sheet.getRow(i);
            Cell cell1 = row.getCell(0);
            Cell cell2 = row.getCell(1);
            cell1.setCellType(1);
            cell2.setCellType(1);
            arrayExcelData[i][0] = cell1.getStringCellValue();
            arrayExcelData[i][1] = cell2.getStringCellValue();
        }

        myExcelBook.close();
        return arrayExcelData;
    }
}
