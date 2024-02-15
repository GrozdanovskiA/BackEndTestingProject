package jsonplaceholder;


import Client.JsonplaceholderClient;
import data.JsonplaceholderDataFactoryPOST;
import data.JsonplaceholderDataFactoryPUT;
import io.restassured.response.Response;
import models.request.JsonplaceholderRequestModelPOST;
import models.JsonplaceholderRequestResponseModelPUT;
import models.response.*;

import org.junit.Test;

import java.util.List;

import static mother.JsonplaceholderMother.createBodyForJsonPOST;
import static mother.JsonplaceholderMother.createBodyForJsonPUT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class JsonplaeholderTest{


    String body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat " +
            "blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla";
    @Test
    public void postJsonplaceholderDefaultValuesTest(){

        JsonplaceholderRequestModelPOST requestbody = new JsonplaceholderDataFactoryPOST(createBodyForJsonPOST())
                .createPostRequest();

        Response postResponse = new JsonplaceholderClient()
                .postJsonplaceholder(requestbody);

        JsonplaceholderResponseModelPOST jsonResponse = postResponse.body().as(JsonplaceholderResponseModelPOST.class);

                assertEquals(201, postResponse.statusCode());
                assertEquals("Default title", jsonResponse.getTitle());
                assertEquals("Default body", jsonResponse.getBody());
    }

    @Test
    public void postJsonplaceholderTest(){

        JsonplaceholderRequestModelPOST requestbody = new JsonplaceholderDataFactoryPOST(createBodyForJsonPOST())
                .setTitle("Makedonija osvoi svetsko prvenstvo vo fudbal")
                .setBody("Noviot svetski prvak Makedonija go " +
                        "osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid")
                .createPostRequest();

        Response postResponse = new JsonplaceholderClient()
                .postJsonplaceholder(requestbody);
        JsonplaceholderResponseModelPOST jsonResponse = postResponse.body().as(JsonplaceholderResponseModelPOST.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Makedonija osvoi svetsko prvenstvo vo fudbal", jsonResponse.getTitle());
        assertEquals("Noviot svetski prvak Makedonija go" +
                " osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid", jsonResponse.getBody());
    }
    @Test
    public void getAllJsonplaceholdeTest (){
    Response getResponse = new  JsonplaceholderClient()
            .getAllJsonplaceholder();

        List<JsonplaceholderResponseModelGET> jsonResponse = getResponse
                .body()
                .jsonPath()
                .getList("", JsonplaceholderResponseModelGET.class);

        assertEquals(200, getResponse.statusCode());
        assertFalse(jsonResponse.isEmpty());

    }
    @Test
    public void getOnePostJsonplaceholderTest(){
        Response getResponse = new JsonplaceholderClient()
                .getOnePostJsonplaceholder("2");

        JsonplaceholderResponseModelGET jsonResponse = getResponse.body().as(JsonplaceholderResponseModelGET.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("qui est esse", jsonResponse.getTitle());
        assertEquals(body,jsonResponse.getBody());

    }
    @Test
    public void putUpdateJsonplaceholderTest() {
        JsonplaceholderRequestResponseModelPUT requestBody = new JsonplaceholderDataFactoryPUT(createBodyForJsonPUT())
                .setId(1)
                .setitle("Makedonija")
                .setbody("Makedonija e svetski prvak")
                .setuserid(1)
                .createPutRequest();

        Response putUpdateResponse = new JsonplaceholderClient()
                .putUpdateJsonplaceholder(requestBody, "1");

        JsonplaceholderRequestResponseModelPUT jsonResponse = putUpdateResponse.body().as(JsonplaceholderRequestResponseModelPUT.class);

        assertEquals(200, putUpdateResponse.statusCode());
        assertEquals("Makedonija", jsonResponse.getTitle());
        assertEquals("Makedonija e svetski prvak", jsonResponse.getBody());

    }
    @Test
    public void deletePostJsonplaceholderTest(){
        Response deleteResponse = new JsonplaceholderClient()
                .deletePostJsonplaceholder("20");

        assertEquals(200,deleteResponse.statusCode());

    }



}




