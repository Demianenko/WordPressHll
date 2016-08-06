package hill.util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
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
}
