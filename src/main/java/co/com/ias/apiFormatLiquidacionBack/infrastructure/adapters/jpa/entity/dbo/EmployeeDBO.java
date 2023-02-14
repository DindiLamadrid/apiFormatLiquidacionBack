package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.*;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Table(name = "Employee")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String startDate;
    private String job;
    private String salary;

//		@ManyToMany(fetch = FetchType.LAZY,
//				   cascade = {
//						   CascadeType.PERSIST,
//						   CascadeType.MERGE
//		           },
//			       mappedBy = "employeeList")
//	@JsonIgnoreProperties("employeeList")
//	@ManyToMany(mappedBy = "employeeList")
//	@ManyToMany
//	@JoinTable(
//		name = "employee",
//		joinColumns = @JoinColumn(name = "employee_id"),
//		inverseJoinColumns = @JoinColumn(name = "employee_id"))
//	private List<EmployeeDBO> employeesList;


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


    public static Employee toDomain(EmployeeDBO employeeDBO) {
        return new Employee(
                new Document(employeeDBO.getId()),
                new Job(employeeDBO.getJob()),
                new Name(employeeDBO.getName()),
                new Salary(employeeDBO.getSalary()),
                new StartDate(employeeDBO.getStartDate()));
    }

    public static EmployeeDBO fromDomain(Employee employee) {
        return new EmployeeDBO(
                employee.getDocument().getValue(),
                employee.getName().getValue(),
                employee.getStartDate().getValue(),
                employee.getJob().getValue(),
                employee.getSalary().getValue()
        );
    }
}

