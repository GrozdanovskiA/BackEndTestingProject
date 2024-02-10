package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModelDataPOST {
//     "data": {
//                    "name": "Zhivko Petkov",
//                    "salary": "10000",
//                    "age": "40",
//                    "id": 5786

    String name;
    String salary;
    String age;
    String id;


}

