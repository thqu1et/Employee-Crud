package kz.thquiet.employee_crud.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeToCreateDTO {
    private String first_name;
    private String last_name;
    private String department;
    private String position;
    private String grade;
    private int salary;
}
