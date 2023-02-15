package co.com.ias.apiFormatLiquidacionBack.domain.usecase;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.EmployeeDTO;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IEmployeeRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.ISalaryRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUseCase {
    private final IEmployeeRepository iEmployeeRepository;
    private final ISalaryRepository iSalaryRepository;

    public EmployeeUseCase(IEmployeeRepository iEmployeeRepository, ISalaryRepository iSalaryRepository) {
        this.iEmployeeRepository = iEmployeeRepository;
        this.iSalaryRepository = iSalaryRepository;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        List<Salary> salaries = new ArrayList<>();
        if (employeeDTO.getSalary() > 0) {
            Salary salary = new Salary(employeeDTO.getSalary());
            this.iSalaryRepository.saveSalary(salary);
        }
        Employee employee = employeeDTO.toDomain(employeeDTO);
        return EmployeeDTO.fromDomain(this.iEmployeeRepository.saveEmployee(employee, salaries));
    }

    public EmployeeDTO findEmployeeById(Long id) {
        Employee employee = this.iEmployeeRepository.findEmployeeById(id);
        if (employee != null) {
            return EmployeeDTO.fromDomain(employee);
        }
        return null;
    }


    public ArrayList<EmployeeDTO> findAllEmployees() {
        List<Employee> employee = this.iEmployeeRepository.findAllEmployee();
        return (ArrayList<EmployeeDTO>) employee.stream().map(EmployeeDTO::fromDomain).collect(Collectors.toList());
    }


    public Boolean deleteEmployee(Long id) {
        return iEmployeeRepository.deleteEmployee(id);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.toDomain(employeeDTO);
        return EmployeeDTO.fromDomain(iEmployeeRepository.updateEmployee(employee));
    }
}
