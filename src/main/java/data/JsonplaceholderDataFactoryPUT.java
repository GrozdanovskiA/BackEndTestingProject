package data;

import models.JsonplaceholderRequestResponseModelPUT;

public class JsonplaceholderDataFactoryPUT {
    private JsonplaceholderRequestResponseModelPUT jsonUpdateRequest;

    public JsonplaceholderDataFactoryPUT(JsonplaceholderRequestResponseModelPUT jsonPutRequest){
        jsonUpdateRequest = jsonPutRequest;

    }
    public JsonplaceholderDataFactoryPUT setId(int value){
        jsonUpdateRequest.setId(value);
        return this;
    }
    public JsonplaceholderDataFactoryPUT setitle(String value){
        jsonUpdateRequest.setTitle(value);
        return this;
    }
    public JsonplaceholderDataFactoryPUT setbody(String value){
        jsonUpdateRequest.setBody(value);
        return this;
    }
    public JsonplaceholderDataFactoryPUT setuserid (int value){
        jsonUpdateRequest.setUserId(value);
        return this;
    }
    public JsonplaceholderRequestResponseModelPUT createPutRequest(){
        return jsonUpdateRequest;
    }
}
