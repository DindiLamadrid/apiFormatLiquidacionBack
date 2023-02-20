package co.com.ias.apiFormatLiquidacionBack.domain.usecase;

import co.com.ias.apiFormatLiquidacionBack.domain.model.dto.LiquidacionDTO;
import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IEmployeeRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.ILiquidacionRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.liquidacion.Liquidacion;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.EmployeeDBO;

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
        Employee employee = this.iEmployeeRepository.findEmployeeById(liquidacionDTO.getIdEmployee());

        //variables
        Double primaServicio = 0d;
        Double cesantias = 0d;
        Double interesesCesantias = 0d;
        Double vacaciones = 0d;
        Double auxTransporte = 0d;
        Double bono = 0d;
        Double totalLiquidacion = 0d;

        Double salaryBase = employeeById.getSalary().getSalary();
        LocalDate startDate = employeeById.getStartDate().getValue();
        Period period = Period.between(startDate, liquidacionDTO.getFechaFin());
        int diasLaborados = period.getDays();
        int primeraño = diasLaborados % 360;

        if ("VOLUNTARIO".equals(liquidacionDTO.getMotivo()) || "JUSTIFICADO".equals(liquidacionDTO.getMotivo())) {
            primaServicio = (salaryBase * (diasLaborados / 6)) / 360;
            cesantias = (salaryBase * (diasLaborados)) / 360;
            interesesCesantias = cesantias * (diasLaborados * 0.12) / 360;
            vacaciones = salaryBase * (diasLaborados / 720);
            auxTransporte = (double) (102854 / 30);
        } else {
            primaServicio = (salaryBase * (diasLaborados / 6)) / 360;
            cesantias = (salaryBase * (diasLaborados)) / 360;
            interesesCesantias = cesantias * (diasLaborados * 0.12) / 360;
            vacaciones = salaryBase * (diasLaborados / 720);
            auxTransporte = (double) (102854 / 30);
            bono = (salaryBase) + (salaryBase * 20 * primeraño);
        }


        Liquidacion liquidacion = LiquidacionDTO.toDomain(salaryBase, auxTransporte, startDate, liquidacionDTO.getFechaFin(),
                liquidacionDTO.getMotivo(), diasLaborados, salaryBase, primaServicio, cesantias, interesesCesantias,
                vacaciones, auxTransporte, bono, totalLiquidacion, employee);
        return LiquidacionDTO.fromDomain(this.iLiquidacionRepository.saveLiquidacion(liquidacion, employee));
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


    public List<LiquidacionDTO> findLiquidacionByEmployeeId(Long id) {
        Employee employeeById = this.iEmployeeRepository.findEmployeeById(id);
        EmployeeDBO employeeDBO = EmployeeDBO.fromDomain(employeeById);
        List<Liquidacion> historyByEmployee = this.iLiquidacionRepository.findHistoryByEmployee(employeeDBO);
        return historyByEmployee.stream().map(LiquidacionDTO::fromDomain).collect(Collectors.toList());
    }
}
