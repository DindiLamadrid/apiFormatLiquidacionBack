package co.com.ias.apiFormatLiquidacionBack.domain.usecase;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.EmployeeDTO;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IEmployeeRepository;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.IEmployeeRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUseCase {
    private final IEmployeeRepository iEmployeeRepository;

    public EmployeeUseCase(IEmployeeRepository iEmployeeRepository, IEmployeeRepositoryAdapter iEmployeeRepositoryAdapter) {
        this.iEmployeeRepository = iEmployeeRepository;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee employee = employeeDTO.toDomain(employeeDTO);
        return EmployeeDTO.fromDomain(this.iEmployeeRepository.saveEmployee(employee));
    }

    public EmployeeDTO findEmployeeById(Long id) {
        co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee employee = this.iEmployeeRepository.findEmployeeById(id);
        if (employee != null) {
            return EmployeeDTO.fromDomain(employee);
        }
        return null;
    }


    public ArrayList<EmployeeDTO> findAllEmployees() {
        List<co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee> employee = this.iEmployeeRepository.findAllEmployee();
        return (ArrayList<EmployeeDTO>) employee.stream().map(EmployeeDTO::fromDomain).collect(Collectors.toList());
    }


    public Boolean deleteEmployee(Long id) {
        return iEmployeeRepository.deleteEmployee(id);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee employee = employeeDTO.toDomain(employeeDTO);
        return EmployeeDTO.fromDomain(iEmployeeRepository.updateEmployee(employee));
    }
}
