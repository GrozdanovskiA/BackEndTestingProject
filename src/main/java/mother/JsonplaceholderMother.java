package mother;

import models.request.JsonplaceholderRequestModelPOST;



public class JsonplaceholderMother {

    public static JsonplaceholderRequestModelPOST createBodyForJsonPOST(){
        return  JsonplaceholderRequestModelPOST
                .builder()
                .title("Default title")
                .body("Default body")
                .build();

    }

}
