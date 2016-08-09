package hill.tests;

import com.sun.jersey.api.client.WebResource;
import hill.util.DataProviders;
import hill.util.DataSource;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by user on 05.08.2016.
 */
public class RESTTest  extends TestNgTestBase {

    @Test(dataProvider = "getJson",dataProviderClass = DataProviders.class, enabled = false)
    @DataSource(json = "src/test/resources/test.txt")
    public void fromDataProvider(String exeptedJSON) throws JSONException, IOException {
        String pathApi = "rest/v1.1/sites/autocource.wordpress.com/posts";
        Assert.assertEquals(foundReturnString(urlApiWordPress,pathApi,"found"),exeptedJSON);
    }



    @Test(dataProvider = "getXLSX",dataProviderClass = DataProviders.class, enabled = true)
    @DataSource(xlsx = "src/test/resources/testXLSX.xlsx")
    public void weatherTestProvider(String path, String p1, String v1, String p2, String v2, String question, String exceptedResult) throws JSONException {
        WebResource webResource = client().resource(urlApiSinoptik);
        String actualResult = webResource.path(path).queryParam(p1,v1).queryParam(p2,v2).get(JSONObject.class).getString(question);
        System.out.println("request = " + v2 + "  " + "actualResult = " + actualResult);
        Assert.assertEquals(actualResult,exceptedResult);
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
/*
 @Test(enabled=false)
    public void test3() throws JSONException {
        String pathApi = "rest/v1.1/sites/autocource.wordpress.com/posts";
        Assert.assertTrue(foundReturnString(urlApiWordPress,pathApi,"posts").contains("test"));
    }
    @Test(enabled=false)
    public void test4() throws JSONException {
        String pathApi = "rest/v1.1/sites/autocource.wordpress.com/posts/4/likes/";
        System.out.println(foundReturnString(urlApiWordPress,pathApi,"found") + " before click");
    }
    @Test(enabled=false)
    public void testWrite() throws JSONException, IOException {
        String pathApi = "/rest/v1.1/sites/autocource.wordpress.com/posts/";
        FileWrite.write(foundReturnString(urlApiWordPress,pathApi,"found"));
        String exept = FileRead.read();
        System.out.println(exept);
        Assert.assertEquals(foundReturnString(urlApiWordPress,pathApi,"found"),exept);

    }
 */