package co.com.ias.apiFormatLiquidacionBack.domain.usecase;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.Liquidacion.dto.Liquidacion;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IEmployeeRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.ILiquidacionRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.dto.LiquidacionDTO;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LiquidacionUseCase {
    private final ILiquidacionRepository iLiquidacionRepository;
    private final IEmployeeRepository iEmployeeRepository;

    public LiquidacionUseCase(ILiquidacionRepository iLiquidacionRepository, IEmployeeRepository iEmployeeRepository) {
        this.iLiquidacionRepository = iLiquidacionRepository;
        this.iEmployeeRepository = iEmployeeRepository;
    }

    public LiquidacionDTO saveLiquidacion(LiquidacionDTO liquidacionDTO) {
        Employee employeeById = this.iEmployeeRepository.findEmployeeById(liquidacionDTO.getIdEmployee());

        Double salaryBase = employeeById.getSalary().getValue();
        LocalDate startDate = employeeById.getStartDate().getValue();
        Period period = Period.between(startDate, liquidacionDTO.getFechaFin());
        int diasLaborados = period.getDays();

        Double primaServicio = (salaryBase * (diasLaborados / 6)) / 360;

        Liquidacion liquidacion = LiquidacionDTO.toDomain(salaryBase, 0d, startDate, liquidacionDTO.getFechaFin(), liquidacionDTO.getMotivo(),
                diasLaborados, salaryBase, primaServicio, 0d, 0d, 0d, 0d, 0d, 0d);
        return LiquidacionDTO.fromDomain(this.iLiquidacionRepository.saveLiquidacion(liquidacion));
    }

    public LiquidacionDTO findLiquidacionById(Long id) {
        Liquidacion liquidacion = this.iLiquidacionRepository.findLiquidacionById(id);
        if (liquidacion != null) {
            return LiquidacionDTO.fromDomain(liquidacion);
        }
        return null;
    }


    public ArrayList<LiquidacionDTO> findAllLiquidaciones() {
        List<Liquidacion> liquidaciones = this.iLiquidacionRepository.findAllLiquidacion();
        return (ArrayList<LiquidacionDTO>) liquidaciones.stream().map(LiquidacionDTO::fromDomain).collect(Collectors.toList());
    }


    public Boolean deleteLiquidacion(Long id) {
        return iLiquidacionRepository.deleteLiquidacion(id);
    }

//    public LiquidacionDTO updateLiquidacion(LiquidacionDTO liquidacionDTO) {
//        Liquidacion liquidacion = liquidacionDTO.toDomain(liquidacionDTO);
//        return LiquidacionDTO.fromDomain(iLiquidacionRepository.updateLiquidacion(liquidacion));
//    }
}
