package hill.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by user on 05.08.2016.
 */
public class DataProviders {
    @DataProvider(name = "ReadFromFile")
    public static Object[][] readFromFile() throws IOException {
        return new Object[1][1];
    }
    @DataProvider(name = "getJson")
    public static Iterator<Object[]> remoteServiceDataProvider(Method m) throws ParseException, IOException {
         DataSource sourceAnnotation = m.getAnnotation(DataSource.class);
         final String jsonFile = sourceAnnotation.json();
        Collection<Object[]> dp = new ArrayList<Object[]>() {
            {
                BufferedReader br = new BufferedReader(new FileReader(jsonFile));
                try {
                    String line = br.readLine();
                    while (line != null) {
                        add(new Object[]{line,br.readLine()});
                        line = br.readLine();
                    }
                } finally {
                    br.close();
                }
            }
        };
        return dp.iterator();
    }

    @DataProvider(name = "getXLSX")
    public static Iterator<Object[]> XLSXDataProvider(Method m) throws ParseException, IOException {
        DataSource sourceAnnotation = m.getAnnotation(DataSource.class);
        final String xlsx = sourceAnnotation.xlsx();
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlsx));
        final XSSFSheet sheet = myExcelBook.getSheetAt(0);

        Collection<Object[]> dp = new ArrayList<Object[]>() {
            {
                int leighOfAnswer = 7;
                int totalNoOfRows = sheet.getLastRowNum() + 1;
                for (int i= 0 ; i < totalNoOfRows; i++) {
                    Row row = sheet.getRow(i);
                    String[] objects = new String[leighOfAnswer];
                    for (int j = 0; j < leighOfAnswer; j++){
                        Cell cell = row.getCell(j);
                        cell.setCellType(1);
                        objects[j] = cell.getStringCellValue();
                    }
                    add(objects);
                }
            }
        };
        return dp.iterator();
    }
}
