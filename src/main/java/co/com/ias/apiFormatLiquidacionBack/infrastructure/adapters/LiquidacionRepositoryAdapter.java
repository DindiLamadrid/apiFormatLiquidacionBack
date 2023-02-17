package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.Liquidacion.dto.Liquidacion;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.ILiquidacionRepository;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.ILiquidacionRepositoryAdapter;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.LiquidacionDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class LiquidacionRepositoryAdapter implements ILiquidacionRepository {

    private final ILiquidacionRepositoryAdapter iLiquidacionRepositoryAdapter;

    @Override
    public Liquidacion saveLiquidacion(Liquidacion liquidacion) {
        LiquidacionDBO liquidacionDBO = LiquidacionDBO.fromDomain(liquidacion);
        LiquidacionDBO liquidacionSaved = iLiquidacionRepositoryAdapter.save(liquidacionDBO);
        return LiquidacionDBO.toDomain(liquidacionSaved);
    }

    @Override
    public Liquidacion updateLiquidacion(Liquidacion liquidacion) {
        return null;
    }

    @Override
    public List<Liquidacion> findAllLiquidacion() {
        return null;
    }

    @Override
    public Boolean deleteLiquidacion(Long liquidacion) {
        return null;
    }

    @Override
    public Liquidacion findLiquidacionById(Long liquidacion) {
        return null;
    }
}
