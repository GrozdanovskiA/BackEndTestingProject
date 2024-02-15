package mother;

import models.request.JsonplaceholderRequestModelPOST;
import models.JsonplaceholderRequestResponseModelPUT;


public class JsonplaceholderMother {

    public static JsonplaceholderRequestModelPOST createBodyForJsonPOST() {
        return JsonplaceholderRequestModelPOST
                .builder()
                .title("Default title")
                .body("Default body")
                .build();

    }

    public static JsonplaceholderRequestResponseModelPUT createBodyForJsonPUT() {
        return JsonplaceholderRequestResponseModelPUT
                .builder()
                .userId(1)
                .title("Default title")
                .body("Default body")
                .id(1)
                .build();
    }
}


