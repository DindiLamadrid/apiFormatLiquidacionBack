package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IEmployeeRepository;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.IEmployeeRepositoryAdapter;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.EmployeeDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryAdapter implements IEmployeeRepository {

    private final IEmployeeRepositoryAdapter iEmployeeRepositoryAdapter;


    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee saveEmployee(Employee employee, List<Employee> employees) {
        EmployeeDBO employeeDBO = EmployeeDBO.fromDomain(employee);
        if (!employees.isEmpty()) {
            List<EmployeeDBO> employeesDBO = employees.stream().map(EmployeeDBO::fromDomain).collect(Collectors.toList());
            employeeDBO.setEmployeesList(employeesDBO);
        }
        EmployeeDBO employeeSaved = iEmployeeRepositoryAdapter.save(employeeDBO);
        return EmployeeDBO.toDomain(employeeSaved);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        EmployeeDBO dbo = EmployeeDBO.fromDomain(employee);
        Optional<EmployeeDBO> elementFound = iEmployeeRepositoryAdapter.findById(dbo.getId());
        if (elementFound.isEmpty()){
            throw new NullPointerException("Employee not exist with id: " + employee.getId().getClass());

        } else {
            EmployeeDBO employeeSaved = iEmployeeRepositoryAdapter.save(dbo);
            return EmployeeDBO.toDomain(employeeSaved);
        }
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Optional<EmployeeDBO> dbo = iEmployeeRepositoryAdapter.findById(id);
        if (dbo.isEmpty()) {
            throw new NullPointerException("Not exist employee with id: " + id);
        } else {
            return EmployeeDBO.toDomain(dbo.get());
        }
    }

    @Override
    public List<Employee> findAllEmployee() {
        return iEmployeeRepositoryAdapter.findAll().stream().map(EmployeeDBO::toDomain).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<EmployeeDBO> dbo = iEmployeeRepositoryAdapter.findById(id);
        dbo.ifPresent(value -> {
            iEmployeeRepositoryAdapter.deleteById(id);
            bool.set(true);
        });
        return bool.get();
    }
}

