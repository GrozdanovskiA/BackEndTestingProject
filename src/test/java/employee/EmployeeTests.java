package employee;

import Client.EmployeeClient;
import data.EmployeeDataFactory;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOST;
import models.response.EmployeeResponseModelPOST;
import org.junit.Test;

import static mother.EmployeeMother.createBodyForEmployeesPOST;
import static org.junit.Assert.assertEquals;

public class EmployeeTests {

    @Test
    public void postEmployeeRequestDefaultValues(){
        //kreirame request body i zadavame vrednosti na atributite
        EmployeeRequestModelPOST requestBody = new EmployeeDataFactory(createBodyForEmployeesPOST())
                .createRequest();

        //go kreirame request body-to so POST request
        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);
        //go zacuvuvame request body-to kako klasen tip (Response --> EmployeeResponse)
        // za da mozime da gi pristapime atributite na modelite
        EmployeeResponseModelPOST employeesResponse = postResponse.body().as(EmployeeResponseModelPOST.class);
        //pravime sporedbi na vrednostite
        assertEquals(200, postResponse.statusCode());
        assertEquals("success", employeesResponse.getStatus());
        assertEquals("Default name", employeesResponse.getData().getName());
        assertEquals("Default age", employeesResponse.getData().getAge());
        assertEquals("Default salary", employeesResponse.getData().getSalary());
        assertEquals("Successfully! Record has been added.", employeesResponse.getMessage());
   }

    @Test
    public void postEmployeeRequest(){

        EmployeeRequestModelPOST requestBody = new EmployeeDataFactory(createBodyForEmployeesPOST())
                .setName("Petko")
                .setAge("30")
                .setSalary("10 000")
                .createRequest();



        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);

        EmployeeResponseModelPOST employeesResponse = postResponse.body().as(EmployeeResponseModelPOST.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("success", employeesResponse.getStatus());
        assertEquals("Petko", employeesResponse.getData().getName());
        assertEquals("30", employeesResponse.getData().getAge());
        assertEquals("10 000", employeesResponse.getData().getSalary());
        assertEquals("Successfully! Record has been added.", employeesResponse.getMessage());
    }


}





