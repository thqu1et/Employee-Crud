package kz.thquiet.employee_crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EmployeeEntity",schema = "public")
public class EmployeeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name" , nullable = false)
    private String first_name;
    @Column(name = "last_name" , nullable = false)
    private String last_name;
    @Column(name = "department" , nullable = false)
    private String department;
    @Column(name = "position" , nullable = false)
    private String position;
    @Column(name = "grade" , nullable = false)
    private String grade;
    @Column(name = "salary")
    private int salary;
}
