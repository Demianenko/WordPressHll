package hill.rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.07.2016.
 */
public class Rest {
    public static void main(String[] args)  {
        String address = "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=7405968f6a0106c84de31bcfec65e460";
        String p1 ="https://service-amsup.lab.nordigy.ru/phonedevices/confirm.asp?";
        String p2 ="SS_ID=4045";
        String p3 ="&PO=080304153246|401836436006";
        String p4 ="&SN=CBT43500J5";
        String p5 ="&TN=323456789987456";
        String p6 ="&LINE_NUM=800589958006";
        address = p1+p2+p3+p4+p5+p6;
        address = "https://wordpress.com/v1.1/sites/50525957/users";


        try {
            get(address);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

    }

    public static void get(String address) throws IOException, URISyntaxException {
        URI uri = stringToURI(address);
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(uri);
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        }

    }
    public static void post(String address, String postData) throws IOException {
        URI uri = stringToURI(address);
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpPost post = new HttpPost(uri);
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
    private static URI stringToURI(String address) {
        String nullFragment = null;
        URL url = null;
        URI uri = null;
        try {
            url = new URL(address);
            uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }
}



