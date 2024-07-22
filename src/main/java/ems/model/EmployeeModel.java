package ems.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {


    private Long id;
    private String address;
    private String firstName;
    private String lastName;
    private String email_id;
}
