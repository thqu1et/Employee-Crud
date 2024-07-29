package kz.thquiet.employee_crud.service;

import kz.thquiet.employee_crud.dto.EmployeeDTO;
import kz.thquiet.employee_crud.dto.EmployeeListDTO;
import kz.thquiet.employee_crud.dto.EmployeeSpecialDTO;
import kz.thquiet.employee_crud.dto.EmployeeToCreateDTO;

import java.util.List;

public interface EmployeeService {
    public EmployeeDTO add( EmployeeToCreateDTO dto);
    public EmployeeDTO get(Integer id);
    public EmployeeDTO updateById(Integer id,  EmployeeToCreateDTO dto);
    public void deleteById(Integer id);
    public List<EmployeeSpecialDTO> getList(EmployeeListDTO dto);
}
