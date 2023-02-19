package co.com.ias.apiFormatLiquidacionBack.domain.usecase;

import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IHistorySalaryRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.dto.SalaryDTO;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.HistorySalaryDBO;

import java.util.List;

public class HistorySalaryUseCase {

    private final IHistorySalaryRepository iHistorySalaryRepository;


    public HistorySalaryUseCase(IHistorySalaryRepository iHistorySalaryRepository) {
        this.iHistorySalaryRepository = iHistorySalaryRepository;
    }

    public List<HistorySalaryDBO> findSalaryById(Long id) {
        List<HistorySalaryDBO> historyById = this.iHistorySalaryRepository.findHistoryById(id);
        if (historyById.isEmpty()) {
            return null;
        }
        return historyById;
    }


}
