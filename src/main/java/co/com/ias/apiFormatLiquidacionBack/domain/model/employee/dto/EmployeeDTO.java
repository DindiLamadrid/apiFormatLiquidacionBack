package co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class EmployeeDTO {
    @JsonIgnoreProperties
    private Long id;
    private String name;
    private String document;
    @DateTimeFormat(pattern = "yyyy/dd/MM")
    private LocalDate startDate;
    private String job;

    private Double salary;

    public List<Long> getSalaryList() {
        return salaryList;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @JsonIgnoreProperties
    private List<Long> salaryList;

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

    public EmployeeDTO(String document, String name, LocalDate startDate, String job) {
        this.name = name;
        this.document = document;
        this.startDate = startDate;
        this.job = job;
    }

    public static EmployeeDTO fromDomain(Employee employee) {
        return new EmployeeDTO(employee.getDocument().getValue(),
                employee.getName().getValue(),
                employee.getStartDate().getValue(),
                employee.getJob().getValue());
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

    public void setSalaryList(List<Long> salaryList) {
        this.salaryList = salaryList;
    }

    public Employee toDomain(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(),
                new Document(employeeDTO.getDocument()),
                new Job(employeeDTO.getJob()),
                new Name(employeeDTO.getName()),
                new StartDate(employeeDTO.getStartDate()));
    }


}
