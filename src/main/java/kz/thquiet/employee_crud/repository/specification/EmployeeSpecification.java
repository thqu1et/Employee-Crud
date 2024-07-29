package kz.thquiet.employee_crud.repository.specification;

import jakarta.persistence.criteria.Predicate;
import kz.thquiet.employee_crud.entity.EmployeeEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


import static java.util.Objects.nonNull;

public class EmployeeSpecification {
    public static Specification<EmployeeEntity> filterEmployee(EmployeeEntity sample) {
        return (Root<EmployeeEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (sample.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), sample.getId()));
            }
            if (sample.getFirst_name() != null && !sample.getFirst_name().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("first_name")), "%" + sample.getFirst_name().toLowerCase() + "%"));
            }
            if (sample.getLast_name() != null && !sample.getLast_name().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("last_name")), "%" + sample.getLast_name().toLowerCase() + "%"));
            }
            if (sample.getDepartment() != null && !sample.getDepartment().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("department"), sample.getDepartment()));
            }
            if (sample.getPosition() != null && !sample.getPosition().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("position"), sample.getPosition()));
            }
            if (sample.getGrade() != null && !sample.getGrade().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("grade"), sample.getGrade()));
            }
            if (sample.getSalary() != -1) {
                predicates.add(criteriaBuilder.equal(root.get("salary"), sample.getSalary()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
