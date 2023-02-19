package co.com.ias.apiFormatLiquidacionBack.domain.model.gateway;

import co.com.ias.apiFormatLiquidacionBack.domain.model.historysalary.HistorySalary;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.HistorySalaryDBO;

import java.util.List;

public interface IHistorySalaryRepository {

    HistorySalary saveHistorySalary(Long salary, Long employee);

    List<HistorySalaryDBO> findHistoryById(Long history);




}
