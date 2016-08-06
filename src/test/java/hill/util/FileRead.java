package hill.util;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by user on 02.08.2016.
 */
public class FileRead {


    public static String read() throws IOException {
        String result;
        BufferedReader br = new BufferedReader(new FileReader("D:\\08\\test.json"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result  = sb.toString();
        } finally {
            br.close();
        }
        return result;
    }
    public static JSONObject readJSON() throws IOException, JSONException {
        String result;
        BufferedReader br = new BufferedReader(new FileReader("D:\\08\\test.json"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result  = sb.toString();
        } finally {
            br.close();
        }
        return new JSONObject(result);
    }
}

