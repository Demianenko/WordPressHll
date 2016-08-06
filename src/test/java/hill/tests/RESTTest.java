package hill.tests;

import com.sun.jersey.api.client.WebResource;
import hill.util.DataProviders;
import hill.util.DataSource;
import hill.util.FileRead;
import hill.util.FileWrite;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by user on 05.08.2016.
 */
public class RESTTest  extends TestNgTestBase {
    @Test(enabled=false)
    public void test3() throws JSONException {
        String pathApi = "rest/v1.1/sites/autocource.wordpress.com/posts";
        Assert.assertTrue(foundReturnString(urlApi,pathApi,"posts").contains("test"));
    }
    @Test(enabled=false)
    public void test4() throws JSONException {
        String pathApi = "rest/v1.1/sites/autocource.wordpress.com/posts/4/likes/";
        System.out.println(foundReturnString(urlApi,pathApi,"found") + " before click");
    }
    @Test(enabled=false)
    public void testWrite() throws JSONException, IOException {
        String pathApi = "/rest/v1.1/sites/autocource.wordpress.com/posts/";
        FileWrite.write(foundReturnString(urlApi,pathApi,"found"));
        String exept = FileRead.read();
        System.out.println(exept);
        Assert.assertEquals(foundReturnString(urlApi,pathApi,"found"),exept);

    }
    @Test(dataProvider = "getJson",dataProviderClass = DataProviders.class, enabled = true)
    @DataSource(json = "src/test/resources/test.txt")
    public void fromDataProvider(String exeptedJSON) throws JSONException, IOException {
        String pathApi = "rest/v1.1/sites/autocource.wordpress.com/posts";
        Assert.assertEquals(foundReturnString(urlApi,pathApi,"found"),exeptedJSON);
    }




    private String foundReturnString(String url, String puth, String value){
        String actual = "";
        try{
            WebResource webResource = client().resource(url);
            JSONObject json = webResource.path(puth).get(JSONObject.class);
            actual = json.get(value).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return actual;
    }
    private JSONObject foundReturnJson(String url, String puth, String value) throws JSONException {
        WebResource webResource = client().resource(url);
        JSONObject json = webResource.path(puth).get(JSONObject.class);
        JSONObject result = (JSONObject)json.get(value);
        return result;
    }
}
