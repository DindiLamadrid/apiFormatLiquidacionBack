package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
	private String name;
	private Long id;
	private String startDate;
	private String job;
	private String salary;
	private String value;
	private List<Long> employeesId;

		@ManyToMany(fetch = FetchType.LAZY,
				   cascade = {
						   CascadeType.PERSIST,
						   CascadeType.MERGE
		           },
			       mappedBy = "employeeList")
	@JsonIgnoreProperties("employeeList")
//	@ManyToMany(mappedBy = "employeeList")
//	@ManyToMany
//	@JoinTable(
//		name = "employee",
//		joinColumns = @JoinColumn(name = "employee_id"),
//		inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<EmployeeDBO> employeesList;

	public EmployeeDBO(Long id, String name, String startDate, String job, String salary, String value, List<Long> employeesId) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.job = job;
		this.salary = salary;
		this.value = value;
		this.employeesId = employeesId;
	}

	public EmployeeDBO(String value, String value1, String startDate, String job, String salary, String value2, List<Long> employeesId) {

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


	public static Employee toDomain(EmployeeDBO employeeDBO){
		return new Employee(
				new EmployeeName(employeeDBO.getName()),
				new EmployeeId(employeeDBO.getId()),
				new EmployeeStartDate(employeeDBO.getStartDate()),
				new EmployeeJob(employeeDBO.getJob()),
				new EmployeeSalary(employeeDBO.getSalary()),
				new EmployeeValue(employeeDBO.getValue()),
				new EmployeesId(employeeDBO.getEmployeesId())
		);
	}

    public static EmployeeDBO fromDomain(Employee employee){
		return new EmployeeDBO(
				employee.getName.getValue(),
				employee.getId.getValue(),
				employee.getStartDate(),
				employee.getJob(),
				employee.getSalary(),
				employee.getValue(),
				employee.getEmployeesId()
		);
	}
}

