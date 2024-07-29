package kz.thquiet.employee_crud.repository.specification;

import jakarta.persistence.criteria.Predicate;
import kz.thquiet.employee_crud.entity.EmployeeEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class EmployeeSpecification {
    public static Specification<EmployeeEntity> filterEmployee(EmployeeEntity employee) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (nonNull(employee.getId())) {
                predicates.add(criteriaBuilder.equal(root.get("id"), employee.getId()));
            }
            if (nonNull(employee.getFirst_name())) {
                predicates.add(criteriaBuilder.like(root.get("first_name"), "%" + employee.getFirst_name() + "%"));
            }
            if (nonNull(employee.getLast_name())) {
                predicates.add(criteriaBuilder.like(root.get("last_name"), "%" + employee.getLast_name() + "%"));
            }
            if (nonNull(employee.getDepartment())) {
                predicates.add(criteriaBuilder.equal(root.get("department"), employee.getDepartment()));
            }
            if (nonNull(employee.getPosition())) {
                predicates.add(criteriaBuilder.equal(root.get("position"), employee.getPosition()));
            }
            if (nonNull(employee.getGrade())) {
                predicates.add(criteriaBuilder.equal(root.get("grade"), employee.getGrade()));
            }
            if (nonNull(employee.getSalary())) {
                predicates.add(criteriaBuilder.equal(root.get("salary"), employee.getSalary()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
