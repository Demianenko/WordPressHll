package Hill.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by user on 06.07.2016.
 */
public class ReaderFromXLSX {
    @DataProvider(name = "LoginPage")
    public static Object[][] readFromExcel(String file) throws IOException {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = myExcelBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        ArrayList<String[]> arrList = new ArrayList<String[]>();
        while (it.hasNext()) {
            Row row = it.next();
            Cell cell1 = row.getCell(0);
            Cell cell2 = row.getCell(1);
            cell1.setCellType(1);
            cell2.setCellType(1);
            String c0 = cell1.getStringCellValue();
            String c1 = cell2.getStringCellValue();
            arrList.add(new String[2]);
            arrList.get(arrList.size()-1)[0] = c0;
            arrList.get(arrList.size()-1)[1] = c1;
        }
        String[][] result = new String[arrList.size()][2];
        for (int i = 0; i < result.length; i++){
            result[i] = arrList.get(i);
        }
        myExcelBook.close();
        return result;
    }
}
