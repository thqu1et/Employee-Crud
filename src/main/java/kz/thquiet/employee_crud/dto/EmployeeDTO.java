package kz.thquiet.employee_crud.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {
    private Integer id;
    private String fio;
    private String department;
    private String position;
    private String grade;
    private int salary;
}
