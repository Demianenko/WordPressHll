import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.07.2016.
 */
public class Rest {
    public static void main(String[] args)  {
        String address = "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=7405968f6a0106c84de31bcfec65e460";
        try {
            get(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void get(String address)throws ClientProtocolException,IOException{
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(address);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
           System.out.println(line);
        }
    }
    public static void post(String address, String postData) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(address);
        List nameValuePairs = new ArrayList(1);
        nameValuePairs.add(new BasicNameValuePair("name", "value")); //you can as many name value pair as you want in the list.
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }
}



