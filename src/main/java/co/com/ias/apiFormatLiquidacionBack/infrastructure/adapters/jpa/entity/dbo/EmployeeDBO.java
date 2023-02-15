package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Employee")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDBO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idEmployee;
    private String document;
    private String name;
    private LocalDate startDate;
    private String job;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "salaryList")
    @JsonIgnoreProperties("salaryList")
    private List<SalaryDBO> salaryList;


    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long id_employee) {
        this.idEmployee = id_employee;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public EmployeeDBO(Long idEmployee, String document, String name, LocalDate startDate, String job) {
        this.idEmployee = idEmployee;
        this.document = document;
        this.name = name;
        this.startDate = startDate;
        this.job = job;
    }

    public static Employee toDomain(EmployeeDBO employeeDBO) {
        return new Employee(employeeDBO.getIdEmployee(),
                new Document(employeeDBO.getDocument()),
                new Job(employeeDBO.getJob()),
                new Name(employeeDBO.getName()),
                new StartDate(employeeDBO.getStartDate()));
    }

    public static EmployeeDBO fromDomain(Employee employee) {
        return new EmployeeDBO(employee.getIdEmployee(),
                employee.getDocument().getValue(),
                employee.getName().getValue(),
                employee.getStartDate().getValue(),
                employee.getJob().getValue()
        );
    }
}

