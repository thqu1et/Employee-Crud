package kz.thquiet.employee_crud.repository;

import kz.thquiet.employee_crud.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> , JpaSpecificationExecutor<EmployeeEntity>{

}
