package data;

import models.request.JsonplaceholderRequestModelPOST;




public class JsonplaceholderDataFactoryPOST {

    private JsonplaceholderRequestModelPOST jsonRequest;

    public JsonplaceholderDataFactoryPOST(JsonplaceholderRequestModelPOST jsonRequestBody){
        jsonRequest = jsonRequestBody;
    }

    public JsonplaceholderDataFactoryPOST setTitle(String value){
        jsonRequest.setTitle(value);
        return this;
    }
    public JsonplaceholderDataFactoryPOST setBody(String value){
        jsonRequest.setBody(value);
        return this;
    }
    public JsonplaceholderRequestModelPOST createPostRequest(){
         return jsonRequest;
    }



}
