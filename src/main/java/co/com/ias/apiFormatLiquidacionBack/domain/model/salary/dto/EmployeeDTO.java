package co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.*;
import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private String document;
    @DateTimeFormat(pattern = "yyyy/dd/MM")
    private LocalDate startDate;
    private String job;

    private Salary salary;

    public Salary getSalary() {
        return salary;
    }

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

    public EmployeeDTO(Long id, String document, String name, LocalDate startDate, String job, Salary salary) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.startDate = startDate;
        this.job = job;
        this.salary = salary;
    }

    public static EmployeeDTO fromDomain(Employee employee) {
        return new EmployeeDTO(employee.getIdEmployee(), employee.getDocument().getValue(),
                employee.getName().getValue(),
                employee.getStartDate().getValue(),
                employee.getJob().getValue(), employee.getSalary());
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Employee toDomain(EmployeeDTO employeeDTO, Salary salaryDTO) {
        return new Employee(employeeDTO.getId(),
                new Document(employeeDTO.getDocument()),
                new Job(employeeDTO.getJob()),
                new Name(employeeDTO.getName()),
                new StartDate(employeeDTO.getStartDate()), salaryDTO
        );
    }


}