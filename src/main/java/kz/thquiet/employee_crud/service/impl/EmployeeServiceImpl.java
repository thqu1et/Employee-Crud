package kz.thquiet.employee_crud.service.impl;

import kz.thquiet.employee_crud.dto.*;
import kz.thquiet.employee_crud.dto.common.PageDTO;
import kz.thquiet.employee_crud.entity.EmployeeEntity;
import kz.thquiet.employee_crud.exception.EmptyValueException;
import kz.thquiet.employee_crud.exception.NotFoundException;
import kz.thquiet.employee_crud.repository.EmployeeRepository;
import kz.thquiet.employee_crud.repository.specification.EmployeeSpecification;
import kz.thquiet.employee_crud.service.EmployeeService;
import kz.thquiet.employee_crud.util.PageableUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public EmployeeDTO add(EmployeeToCreateDTO dto) {
        EmployeeEntity entity = new EmployeeEntity();
        if (dto.getFirst_name().equals("") || dto.getFirst_name() == null){
            throw new EmptyValueException("First name is not null or empty!");
        }
        entity.setFirst_name(dto.getFirst_name());

        if (dto.getLast_name().equals("") || dto.getLast_name() == null){
            throw new EmptyValueException("Last name is not null or empty!");
        }
        entity.setLast_name(dto.getLast_name());

        if (dto.getDepartment().equals("") || dto.getDepartment() == null){
            throw new EmptyValueException("Department is not null or empty!");
        }
        entity.setDepartment(dto.getDepartment());

        if (dto.getPosition().equals("") || dto.getPosition() == null){
            throw new EmptyValueException("Position is not null or empty!");
        }
        entity.setPosition(dto.getPosition());

        if (dto.getGrade().equals("") || dto.getGrade() == null){
            throw new EmptyValueException("Grade is not null or empty!");
        }
        entity.setGrade(dto.getGrade());
        entity.setSalary(dto.getSalary());
        entity = repository.save(entity);
        return convert(entity);
    }

    @Override
    public EmployeeDTO get(Integer id) {
        Optional<EmployeeEntity> entity = repository.findById(id);
        if(!entity.isPresent()){
            throw new NotFoundException("Employee not found with id " + id);
        }
        return convert(entity.get());
    }

    @Override
    public EmployeeDTO updateById(Integer id, EmployeeToCreateDTO dto) {
        EmployeeEntity entity = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Employee not found with id"));
        if (dto.getFirst_name().equals("") || dto.getFirst_name() == null){
            throw new EmptyValueException("First name is not null or empty!");
        }
        entity.setFirst_name(dto.getFirst_name());

        if (dto.getLast_name().equals("") || dto.getLast_name() == null){
            throw new EmptyValueException("Last name is not null or empty!");
        }
        entity.setLast_name(dto.getLast_name());

        if (dto.getDepartment().equals("") || dto.getDepartment() == null){
            throw new EmptyValueException("Department is not null or empty!");
        }
        entity.setDepartment(dto.getDepartment());

        if (dto.getPosition().equals("") || dto.getPosition() == null){
            throw new EmptyValueException("Position is not null or empty!");
        }
        entity.setPosition(dto.getPosition());

        if (dto.getGrade().equals("") || dto.getGrade() == null){
            throw new EmptyValueException("Grade is not null or empty!");
        }
        entity.setGrade(dto.getGrade());
        entity.setSalary(dto.getSalary());
        entity = repository.save(entity);
        return convert(entity);
    }

    @Override
    public void deleteById(Integer id) {
        EmployeeEntity entity = repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Employee not found with id"));
        repository.delete(entity);
    }

    @Override
    public List<EmployeeSpecialDTO> getList(EmployeeListDTO dto) {
        EmployeeEntity e = new EmployeeEntity();
        e.setId(dto.getId());
        e.setSalary(dto.getSalary());
        e.setFirst_name(dto.getFirst_name());
        e.setLast_name(dto.getLast_name());
        e.setDepartment(dto.getDepartment());
        e.setGrade(dto.getGrade());
        e.setPosition(dto.getPosition());
        Specification<EmployeeEntity> specification = EmployeeSpecification.filterEmployee(e);
        return repository.findAll(specification)
                .stream().sorted(Comparator.comparing(EmployeeEntity::getId))
                .map(this::convertToDtoWithId)
                .collect(Collectors.toList());
    }

    @Override
    public PageDTO<EmployeeSpecialDTO> getPages(EmployeeFilterDTO dto) {
        EmployeeEntity e = new EmployeeEntity();
        e.setId(dto.getId());
        e.setSalary(dto.getSalary());
        e.setFirst_name(dto.getFirst_name());
        e.setLast_name(dto.getLast_name());
        e.setDepartment(dto.getDepartment());
        e.setGrade(dto.getGrade());
        e.setPosition(dto.getPosition());

        Specification<EmployeeEntity> specification = EmployeeSpecification.filterEmployee(e);
        Page<EmployeeSpecialDTO> page = repository.findAll(specification,
                PageableUtils.createPageRequest(dto))
                .map(this::convertToDtoWithId);
        List<EmployeeSpecialDTO> list = page.toList();

        return new PageDTO<>(page, list);
    }

    private EmployeeDTO convert(EmployeeEntity entity) {
        return EmployeeDTO.builder()
                .id(entity.getId())
                .fio(entity.getFirst_name() + " " + entity.getLast_name())
                .department(entity.getDepartment())
                .position(entity.getPosition())
                .grade(entity.getGrade())
                .salary(entity.getSalary())
                .build();
    }

    private EmployeeSpecialDTO convertToDtoWithId(EmployeeEntity entity) {
        return EmployeeSpecialDTO.builder()
                .id(entity.getId())
                .first_name(entity.getFirst_name())
                .last_name(entity.getLast_name())
                .department(entity.getDepartment())
                .position(entity.getPosition())
                .grade(entity.getGrade())
                .salary(entity.getSalary())
                .build();
    }
}
