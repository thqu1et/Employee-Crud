package kz.thquiet.employee_crud.dto;

import kz.thquiet.employee_crud.dto.common.PageableDTO;
import lombok.Data;

@Data
public class EmployeeFilterDTO extends PageableDTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private String department;
    private String position;
    private String grade;
    private int salary;
}
