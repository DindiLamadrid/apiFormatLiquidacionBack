package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa;

import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.HistorySalaryDBO;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.SalaryDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface IHistorySalaryRepositoryAdapter extends JpaRepository<HistorySalaryDBO, Long> {

    List<HistorySalaryDBO> findByIdEmployeeIn(Collection<Long> idEmployee);
}
