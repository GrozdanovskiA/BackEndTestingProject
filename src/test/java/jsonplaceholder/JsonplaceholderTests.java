package jsonplaceholder;

import Client.JsonplaceholderClient;
import data.JsonplaceholderDataFactory;
import io.restassured.response.Response;
import models.request.JsonplaceholderRequestModelPOST;
import models.response.JsonplaceholderResponseModelPOST;
import org.junit.Test;

import static mother.JsonplaceholderMother.createBodyForJsonPOST;
import static org.junit.Assert.assertEquals;

public class JsonplaceholderTests {

    @Test
    public void postJsonplaceholderDefaultValues(){

        JsonplaceholderRequestModelPOST requestbody = new JsonplaceholderDataFactory(createBodyForJsonPOST())
                .createRequest();

        Response postResponse = new JsonplaceholderClient()
                .postJsonplaceholder(requestbody);

        JsonplaceholderResponseModelPOST jsonResponse = postResponse.body().as(JsonplaceholderResponseModelPOST.class);

                assertEquals(201, postResponse.statusCode());
                assertEquals("Default title", jsonResponse.getTitle());
                assertEquals("Default body", jsonResponse.getBody());
    }

    @Test
    public void postJsonplaceholder(){

        JsonplaceholderRequestModelPOST requestbody = new JsonplaceholderDataFactory(createBodyForJsonPOST())
                .setTitle("Makedonija osvoi svetsko prvenstvo vo fudbal")
                .setBody("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid")
                .createRequest();

        Response postResponse = new JsonplaceholderClient()
                .postJsonplaceholder(requestbody);
        JsonplaceholderResponseModelPOST jsonResponse = postResponse.body().as(JsonplaceholderResponseModelPOST.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Makedonija osvoi svetsko prvenstvo vo fudbal", jsonResponse.getTitle());
        assertEquals("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid", jsonResponse.getBody());
    }



}
