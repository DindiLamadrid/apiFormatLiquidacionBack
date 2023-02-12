package co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.*;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.EmployeeValue;

import java.util.List;

public class EmployeeDTO {

    private String name;
    private Long id;
    private String startDate;
    private String job;
    private String salary;
    private String value;
    private List<Long> employeesId;



    public EmployeeDTO(Long id, String name, String startDate, String job, String salary, String value, List<Long> employeesId) {
        this.name = name;
        this.id = id;
        this.startDate = startDate;
        this.job = job;
        this.salary = salary;
        this.employeesId = employeesId;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getJob(){
        return job;
    }

    public String getSalary(){
        return salary;
    }

    public String getValue(){
        return value;
    }

    public List<Long> getEmployeesId() {
        return employeesId;
    }

    public Employee toDomain(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getName(), employeeDTO.getId(), employeeDTO.getStartDate());
    }

    public static EmployeeDTO fromDomain(Employee employee) {
        return new EmployeeDTO(employee.getId(),
                employee.getName(),
                employee.getStartDate(),
                employee.getJob(),
                employee.getSalary(),
                employee.getValue(),
                employee.getEmployeesId());
    }
}
