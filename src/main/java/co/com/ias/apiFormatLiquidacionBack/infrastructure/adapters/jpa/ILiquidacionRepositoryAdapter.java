package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa;

import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.LiquidacionDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILiquidacionRepositoryAdapter extends JpaRepository<LiquidacionDBO, Long> {
}
