package co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.*;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@NoArgsConstructor
public class EmployeeDTO {

    private String name;
    private String document;
    private LocalDate startDate;
    private String job;
    private String salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public EmployeeDTO(String document, String name, LocalDate startDate, String job, String salary) {
        this.name = name;
        this.document = document;
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

    public String getDocument() {
        return document;
    }

    public LocalDate getStartDate() {
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
                new Document(employeeDTO.getDocument()),
                new Job(employeeDTO.getJob()),
                new Name(employeeDTO.getName()),
                new Salary(employeeDTO.getSalary()),
                new StartDate(employeeDTO.getStartDate()));
    }


}
