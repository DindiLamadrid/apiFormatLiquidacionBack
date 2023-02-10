package co.com.ias.apiFormatLiquidacionBack.domain.model.gateway;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    List<Employee> findAllEmployee();

    Boolean deleteEmployee(Long employee);

    Employee findEmployeeById(Long employee);

}
