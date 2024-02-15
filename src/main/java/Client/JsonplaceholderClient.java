package Client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.JsonplaceholderRequestModelPOST;
import models.JsonplaceholderRequestResponseModelPUT;

import static util.Configuration.JSON_POST_GETALL_GETONEPOST_POST_PUT_DELETE;

public class JsonplaceholderClient {


    public Response postJsonplaceholder(JsonplaceholderRequestModelPOST requestJson){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestJson)
                .post(JSON_POST_GETALL_GETONEPOST_POST_PUT_DELETE)
                .thenReturn();
    }
    public Response getAllJsonplaceholder(){
        return RestAssured
                .given()
                .when().log().all()
                .get(JSON_POST_GETALL_GETONEPOST_POST_PUT_DELETE)
                .thenReturn();
    }
    public Response getOnePostJsonplaceholder(String id){
        return RestAssured
                .given()
                .when().log().all()
                .get(JSON_POST_GETALL_GETONEPOST_POST_PUT_DELETE + "/" + id)
                .thenReturn();
    }
    public Response putUpdateJsonplaceholder(JsonplaceholderRequestResponseModelPUT requestJson, String id) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestJson)
                .put(JSON_POST_GETALL_GETONEPOST_POST_PUT_DELETE + "/" + id)
                .thenReturn();
    }
    public Response deletePostJsonplaceholder(String id){
        return RestAssured
                .given()
                .when().log().all()
                .delete(JSON_POST_GETALL_GETONEPOST_POST_PUT_DELETE + "/" + id)
                .thenReturn();
    }
}
