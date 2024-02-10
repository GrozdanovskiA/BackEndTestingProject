package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModelPOST {
//    {
//        "status": "success",
//            "data": {
//                    "name": "Zhivko Petkov",
//                    "salary": "10000",
//                    "age": "40",
//                    "id": 5786
//    },
//        "message": "Successfully! Record has been added."
//    }
    String status;
    EmployeeResponseModelDataPOST data;
    String message;



}
