package co.com.ias.apiFormatLiquidacionBack.domain.model.gateway;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.Liquidacion.dto.Liquidacion;

import java.util.List;

public interface ILiquidacionRepository {

    Liquidacion saveLiquidacion(Liquidacion liquidacion, Employee employee);

    Liquidacion updateLiquidacion(Liquidacion liquidacion);

    List<Liquidacion> findAllLiquidacion();

    Boolean deleteLiquidacion(Long liquidacion);

    Liquidacion findLiquidacionById(Long liquidacion);
}
