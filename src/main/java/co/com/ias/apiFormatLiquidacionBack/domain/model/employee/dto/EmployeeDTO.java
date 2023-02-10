package co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;

public class EmployeeDTO {

    public String name;
    public String id;
    public String startDate;


    public EmployeeDTO(String id, String name, String startDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public Employee toDomain(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getName(), employeeDTO.getId(), employeeDTO.getStartDate());
    }

    public static EmployeeDTO fromDomain(Employee employee) {
        return new EmployeeDTO(employee.getSalary(),
                employee.getName(),
                employee.getStartDate());
    }
}
