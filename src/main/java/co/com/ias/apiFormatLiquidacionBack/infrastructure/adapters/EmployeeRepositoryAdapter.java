package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IEmployeeRepository;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.IEmployeeRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryAdapter implements IEmployeeRepository {

    private final IEmployeeRepositoryAdapter iEmployeeRepositoryAdapter;


    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return null;
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        return null;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return null;
    }
}
