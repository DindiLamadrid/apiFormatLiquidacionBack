package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.EmployeeValue;

import java.util.Date;
import java.util.List;

public class Employee {
    public String name;
    public Long id;
    public String startDate;
    public String job;
    public String salary;
    public EmployeeName getName;
    public EmployeeName getId;
    private String value;
    private List<Long> employeesId;

    public Employee(String name, Long id, String startDate, String job, String salary, List employeesId, String value) {
        this.name = name;
        this.id = id;
        this.startDate = startDate;
        this.job = job;
        this.salary = salary;
        this.employeesId = employeesId;
        this.value = value;
    }

    public Employee(EmployeeName employeeName, EmployeeId employeeId, EmployeeStartDate employeeStartDate, EmployeeJob employeeJob, EmployeeSalary employeeSalary, EmployeeValue employeeValue, EmployeesId employeesId) {

    }

    public Employee(String name, Long id, String startDate) {

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

    public String getValue() {
        return value;
    }

    public List<Long> getEmployeesId() {
        return employeesId;
    }
}
