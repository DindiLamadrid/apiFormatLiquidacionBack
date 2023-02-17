package co.com.ias.apiFormatLiquidacionBack.domain.model.salary.dto;


import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.Liquidacion.dto.Liquidacion;

import java.time.LocalDate;

public class LiquidacionDTO {

    private Long idEmployee;


    private LocalDate fechaFin;


    private String motivo;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LiquidacionDTO(Long idEmployee, LocalDate fechaFin, String motivo) {
        this.idEmployee = idEmployee;
        this.fechaFin = fechaFin;
        this.motivo = motivo;
    }

    public static LiquidacionDTO fromDomain(Liquidacion liquidacion) {
        return new LiquidacionDTO(
                liquidacion.getIdEmployee(),
                liquidacion.getFechaFin(),
                liquidacion.getMotivo());
    }

    public static Liquidacion toDomain(Double salario, Double auxilio, LocalDate fechaInicio, LocalDate fechaFin, String motivo,
                                       int diasLaborados, Double salarioBase, Double primaServicios, Double cesantias, Double interesesCesantias,
                                       Double vacaciones, Double auxTransporte, Double bono, Double totalLiquidacion) {
        return new Liquidacion(salario, auxilio, fechaInicio, fechaFin, motivo, diasLaborados, salarioBase, primaServicios,
                cesantias, interesesCesantias, vacaciones, auxTransporte, bono, totalLiquidacion);
    }

}
