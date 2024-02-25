package employee;

import Client.EmployeeClient;
import data.EmployeeDataFactory;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOSTPUT;
import models.response.EmployeeResponseModelGETALL;
import models.response.EmployeeResponseModelDELETE;
import models.response.EmployeeResponseModelGETById;
import models.response.EmployeeResponseModelPOSTPUT;
import org.junit.Test;

import static mother.EmployeeMother.createBodyForEmployeesPOSTPUT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EmployeeTests {

    @Test
    public void postEmployeeRequestDefaultValues(){
        //kreirame request body i zadavame vrednosti na atributite
        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPOSTPUT())
                .createRequest();

        //go kreirame request body-to so POST request
        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);
        //go zacuvuvame request body-to kako klasen tip (Response --> EmployeeResponse)
        // za da mozime da gi pristapime atributite na modelite
        EmployeeResponseModelPOSTPUT employeesResponse = postResponse.body().as(EmployeeResponseModelPOSTPUT.class);
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

        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPOSTPUT())
                .setName("Petko")
                .setAge("30")
                .setSalary("10 000")
                .createRequest();



        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);

        EmployeeResponseModelPOSTPUT employeesResponse = postResponse.body().as(EmployeeResponseModelPOSTPUT.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("success", employeesResponse.getStatus());
        assertEquals("Petko", employeesResponse.getData().getName());
        assertEquals("30", employeesResponse.getData().getAge());
        assertEquals("10 000", employeesResponse.getData().getSalary());
        assertEquals("Successfully! Record has been added.", employeesResponse.getMessage());
    }
    @Test
    public void getAllEmployeesTest(){
        Response getResponse = new EmployeeClient()
                .getAllEmployees();

        EmployeeResponseModelGETALL employeesResponse = getResponse.body().as(EmployeeResponseModelGETALL.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("success", employeesResponse.getStatus());
        assertFalse(employeesResponse.getData().isEmpty());
        assertEquals("Successfully! All records has been fetched.", employeesResponse.getMessage());

    }
    @Test
    public void getEmployeeByIdTest (){
        Response getResponse = new EmployeeClient()
                .getOneEmployee("3");

        EmployeeResponseModelGETById employeeResponse = getResponse.body().as(EmployeeResponseModelGETById.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Ashton Cox",employeeResponse.getData().getEmployee_name());
        assertEquals(86000, employeeResponse.getData().getEmployee_salary());
        assertEquals(66, employeeResponse.getData().getEmployee_age());
        assertEquals("Successfully! Record has been fetched.",employeeResponse.getMessage());

    }
    @Test
    public void putUpdateEmployeeTest(){
        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPOSTPUT())
                .setName("Zhivko Petkov")
                .setAge("40")
                .setSalary("10 000")
                .createRequest();

        Response putUpdateResponse = new EmployeeClient()
                .putUpdateEmployee(requestBody,"10");

        EmployeeResponseModelPOSTPUT employeePutResponse = putUpdateResponse.body().as(EmployeeResponseModelPOSTPUT.class);

        assertEquals(200, putUpdateResponse.statusCode());
        assertEquals("success", employeePutResponse.getStatus());
        assertEquals("Zhivko Petkov", employeePutResponse.getData().getName());
        assertEquals("40", employeePutResponse.getData().getAge());
        assertEquals("10 000", employeePutResponse.getData().getSalary());
        assertEquals("Successfully! Record has been updated.", employeePutResponse.getMessage());

    }
    @Test
    public void deleteEmployeeTest (){
        String id = "20";

        Response deleteResponse = new EmployeeClient()
                .deleteEmployee(id);

        EmployeeResponseModelDELETE deleteEmployeeResponse = deleteResponse.body().as(EmployeeResponseModelDELETE.class);

        assertEquals(200, deleteResponse.statusCode());
        assertEquals("success", deleteEmployeeResponse.getStatus());
        assertEquals(id , deleteEmployeeResponse.getData());
        assertEquals("Successfully! Record has been deleted", deleteEmployeeResponse.getMessage());

    }


}





