package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModelGETById {
    /*{
    "status": "success",
    "data": {
        "id": 5,
        "employee_name": "Airi Satou",
        "employee_salary": 162700,
        "employee_age": 33,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}*/

    String status;
    EmployeeResponseModelGETData data;
    String message;

}
