package mother;

import models.request.EmployeeRequestModelPOSTPUT;

public class EmployeeMother{

    public static EmployeeRequestModelPOSTPUT createBodyForEmployeesPOSTPUT(){
        return EmployeeRequestModelPOSTPUT.builder()
                .name("Default name")
                .age("Default age")
                .salary("Default salary")
                .build();
    }
}
