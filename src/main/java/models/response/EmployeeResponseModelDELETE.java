package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModelDELETE {
   /* {
        "status": "success",
            "data": "20",
            "message": "Successfully! Record has been deleted"
    }
    */

    String status;
    String data;
    String message;


}
