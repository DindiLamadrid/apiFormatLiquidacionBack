package co.com.ias.apiFormatLiquidacionBack.domain.model.gateway;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;

import java.util.List;

public interface IEmployeeRepository {

    Employee saveEmployee(Employee employee, List<Salary> salaries);

    Employee updateEmployee(Employee employee);

    List<Employee> findAllEmployee();

    Boolean deleteEmployee(Long employee);

    Employee findEmployeeById(Long employee);

}
