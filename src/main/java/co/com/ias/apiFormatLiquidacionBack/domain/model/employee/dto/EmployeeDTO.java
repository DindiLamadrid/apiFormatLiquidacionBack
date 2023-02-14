package co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.*;

public class EmployeeDTO {

    private String name;
    private Long id;
    private String startDate;
    private String job;
    private String salary;

    public EmployeeDTO(Long id, String name, String startDate, String job, String salary) {
        this.name = name;
        this.id = id;
        this.startDate = startDate;
        this.job = job;
        this.salary = salary;
    }

    public static EmployeeDTO fromDomain(Employee employee) {
        return new EmployeeDTO(employee.getDocument().getValue(),
                employee.getName().getValue(),
                employee.getStartDate().getValue(),
                employee.getJob().getValue(),
                employee.getSalary().getValue());
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getJob() {
        return job;
    }

    public String getSalary() {
        return salary;
    }


    public Employee toDomain(EmployeeDTO employeeDTO) {
        return new Employee(
                new Document(employeeDTO.getId()),
                new Job(employeeDTO.getJob()),
                new Name(employeeDTO.getName()),
                new Salary(employeeDTO.getSalary()),
                new StartDate(employeeDTO.getStartDate()));
    }


}
