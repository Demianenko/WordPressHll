package hill.util;

import org.codehaus.jettison.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by user on 02.08.2016.
 */
public class FileWrite {
    public static void write(String jsonString) throws IOException {
        FileWriter file = new FileWriter("D:\\08\\test.json");

        file.write(jsonString);
        file.flush();
        file.close();

        System.out.println("Successfully Copied JSON Object to File...");
        System.out.println("\nJSON Object: " + jsonString);
    }
    public static void write(JSONObject json) throws IOException {
        FileWriter file = new FileWriter("D:\\08\\test.json");

        file.write(json.toString());
        file.flush();
        file.close();

        System.out.println("Successfully Copied JSON Object to File...");
        System.out.println("\nJSON Object: " + json);
    }
}
