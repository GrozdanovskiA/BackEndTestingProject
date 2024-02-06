package data;

import models.request.JsonplaceholderRequestModelPOST;
import models.response.JsonplaceholderResponseModelPOST;


public class JsonplaceholderDataFactory {

    private JsonplaceholderRequestModelPOST jsonRequest;

    public JsonplaceholderDataFactory (JsonplaceholderRequestModelPOST jsonRequestBody){
        jsonRequest = jsonRequestBody;
    }

    public JsonplaceholderDataFactory setTitle(String value){
        jsonRequest.setTitle(value);
        return this;
    }
    public JsonplaceholderDataFactory setBody(String value){
        jsonRequest.setBody(value);
        return this;
    }
    public JsonplaceholderRequestModelPOST createRequest(){
         return jsonRequest;
    }
}
