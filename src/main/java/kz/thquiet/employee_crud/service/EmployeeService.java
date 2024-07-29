package kz.thquiet.employee_crud.service;

import kz.thquiet.employee_crud.dto.*;
import kz.thquiet.employee_crud.dto.common.PageDTO;

import java.util.List;

public interface EmployeeService {
    public EmployeeDTO add( EmployeeToCreateDTO dto);
    public EmployeeDTO get(Integer id);
    public EmployeeDTO updateById(Integer id,  EmployeeToCreateDTO dto);
    public void deleteById(Integer id);
    public List<EmployeeSpecialDTO> getList(EmployeeListDTO dto);
    PageDTO<EmployeeSpecialDTO> getPages(EmployeeFilterDTO dto);
}
