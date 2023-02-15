package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters;

import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.ISalaryRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.ISalaryRepositoryAdapter;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.SalaryDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class SalaryRepositoryAdapter implements ISalaryRepository {

    private final ISalaryRepositoryAdapter iSalaryRepositoryAdapter;

    @Override
    public Salary findSalaryById(Long id) {
        Optional<SalaryDBO> dbo = iSalaryRepositoryAdapter.findById(id);
        if (dbo.isEmpty()) {
            throw new NullPointerException("Not exist salary with id: " + id);
        } else {
            return SalaryDBO.toDomain(dbo.get());
        }
    }

    @Override
    public Salary saveSalary(Salary salary) {
        SalaryDBO salaryDBO = SalaryDBO.fromDomain(salary);
        SalaryDBO salarySaved = iSalaryRepositoryAdapter.save(salaryDBO);
        return SalaryDBO.toDomain(salarySaved);
    }

}

