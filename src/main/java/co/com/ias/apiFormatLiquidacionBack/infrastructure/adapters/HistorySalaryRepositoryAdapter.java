package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IHistorySalaryRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.ISalaryRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.historysalary.HistorySalary;
import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.IHistorySalaryRepositoryAdapter;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.ISalaryRepositoryAdapter;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.HistorySalaryDBO;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.SalaryDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class HistorySalaryRepositoryAdapter implements IHistorySalaryRepository {

    private final IHistorySalaryRepositoryAdapter iHistorySalaryRepositoryAdapter;


    @Override
    public HistorySalary saveHistorySalary(Long salary, Long employee) {
        HistorySalary historySalary = new HistorySalary(salary, employee);
        HistorySalaryDBO historySalaryDBO = HistorySalaryDBO.fromDomain(historySalary);
        HistorySalaryDBO salarySaved = iHistorySalaryRepositoryAdapter.save(historySalaryDBO);
        return HistorySalaryDBO.toDomain(salarySaved);
    }

    @Override
    public List<HistorySalaryDBO> findHistoryById(Long history) {
        return iHistorySalaryRepositoryAdapter.findByIdEmployeeIn(Collections.singleton(history));
    }
}

