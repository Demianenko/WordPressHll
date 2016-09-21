package hill.rest;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 19.07.2016.
 */
public class JersyRest extends JerseyTest {
    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }
    @Test(enabled=false)
    public void test() throws JSONException {
        String url = "http://services.groupkt.com";
        WebResource webResource = client().resource(url);
        JSONObject json = webResource.path("/state/get/IND/all").get(JSONObject.class);
        String actual = json.get("RestResponse").toString();
        System.out.println(actual);
        Assert.assertEquals(actual,"Itanagar");
    }
    @Test(enabled=true)
    public void test1() throws JSONException {
        String url = "http://api.openweathermap.org";
        String puth = "/data/2.5/weather";

        String p1 ="APPID";
        String v1 = "7405968f6a0106c84de31bcfec65e460";
        String p2 ="q";
        String v2 ="London";
        WebResource webResource = client().resource(url);
        JSONObject json = webResource.path(puth).queryParam(p1,v1).queryParam(p2,v2).get(JSONObject.class);
        //String actual = json.get("").toString();
        String actual = json.get("coord").toString();
        Assert.assertEquals(actual,"{\"lon\":-0.13,\"lat\":51.51}");
    }


}
