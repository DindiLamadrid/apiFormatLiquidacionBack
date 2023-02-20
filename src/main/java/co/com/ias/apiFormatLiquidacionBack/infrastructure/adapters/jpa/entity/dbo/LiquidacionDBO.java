package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.apiFormatLiquidacionBack.domain.model.liquidacion.Liquidacion;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Liquidacion")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LiquidacionDBO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Double salario;
    private Double auxilio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String motivo;
    private int diasLaborados;
    private Double salarioBase;
    private Double primaServicios;
    private Double cesantias;
    private Double interesesCesantias;
    private Double vacaciones;
    private Double auxTransporte;
    private Double bono;
    private Double totalLiquidacion;
    @ManyToOne
    @JoinColumn(name = "Employee")
    private EmployeeDBO employeeDBO;


    public LiquidacionDBO(Double salario, Double auxilio, LocalDate fechaInicio, LocalDate fechaFin, String motivo,
                          int diasLaborados, Double salarioBase, Double primaServicios, Double cesantias, Double interesesCesantias,
                          Double vacaciones, Double auxTransporte, Double bono, Double totalLiquidacion, EmployeeDBO employeeDBO) {
        this.salario = salario;
        this.auxilio = auxilio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.motivo = motivo;
        this.diasLaborados = diasLaborados;
        this.salarioBase = salarioBase;
        this.primaServicios = primaServicios;
        this.cesantias = cesantias;
        this.interesesCesantias = interesesCesantias;
        this.vacaciones = vacaciones;
        this.auxTransporte = auxTransporte;
        this.bono = bono;
        this.totalLiquidacion = totalLiquidacion;
        this.employeeDBO = employeeDBO;
    }


    public static Liquidacion toDomain(LiquidacionDBO liquidacionDBO) {
        return new Liquidacion(liquidacionDBO.getSalario(),
                liquidacionDBO.getAuxilio(), liquidacionDBO.getFechaInicio(), liquidacionDBO.getFechaFin(),
                liquidacionDBO.getMotivo(), liquidacionDBO.getDiasLaborados(), liquidacionDBO.getSalarioBase(), liquidacionDBO.getPrimaServicios(),
                liquidacionDBO.getCesantias(), liquidacionDBO.getInteresesCesantias(), liquidacionDBO.getVacaciones(), liquidacionDBO.getAuxTransporte(),
                liquidacionDBO.getBono(), liquidacionDBO.getTotalLiquidacion(), EmployeeDBO.toDomain(liquidacionDBO.getEmployeeDBO()));
    }

    public static LiquidacionDBO fromDomain(Liquidacion liquidacion) {
        return new LiquidacionDBO(liquidacion.getSalario(), liquidacion.getAuxilio(), liquidacion.getFechaInicio(), liquidacion.getFechaFin(),
                liquidacion.getMotivo(), liquidacion.getDiasLaborados(), liquidacion.getSalarioBase(), liquidacion.getPrimaServicios(),
                liquidacion.getCesantias(), liquidacion.getInteresesCesantias(), liquidacion.getVacaciones(), liquidacion.getAuxTransporte(),
                liquidacion.getBono(), liquidacion.getTotalLiquidacion(), EmployeeDBO.fromDomain(liquidacion.getEmployee()));

    }
}
