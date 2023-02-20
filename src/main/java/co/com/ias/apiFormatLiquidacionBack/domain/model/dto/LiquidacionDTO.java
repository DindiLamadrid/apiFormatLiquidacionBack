package co.com.ias.apiFormatLiquidacionBack.domain.model.dto;


import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.liquidacion.Liquidacion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiquidacionDTO {

    private Long idEmployee;
    private LocalDate fechaFin;
    private String motivo;
    private Integer id;
    private Double aux_transporte;
    private Double auxilio;
    private Double bono;
    private Double cesantias;
    private Integer dias_laborados;
    private LocalDate fecha_fin;
    private LocalDate decha_inicio;
    private Double intereses_cesantias;
    private Double prima_servicios;
    private Double salario;
    private Double salario_base;
    private Double total_liquidacion;
    private Double vacaciones;
    private Integer employee;


    public String getMotivo() {
        return motivo;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public LiquidacionDTO(Long idEmployee, LocalDate fechaFin, String motivo, Integer id, Double aux_transporte, Double auxilio, Double bono, Double cesantias, Integer dias_laborados, LocalDate fecha_fin, LocalDate decha_inicio, Double intereses_cesantias, Double prima_servicios, Double salario, Double salario_base, Double total_liquidacion, Double vacaciones, Integer employee) {
        this.idEmployee = idEmployee;
        this.fechaFin = fechaFin;
        this.motivo = motivo;
        this.id = id;
        this.aux_transporte = aux_transporte;
        this.auxilio = auxilio;
        this.bono = bono;
        this.cesantias = cesantias;
        this.dias_laborados = dias_laborados;
        this.fecha_fin = fecha_fin;
        this.decha_inicio = decha_inicio;
        this.intereses_cesantias = intereses_cesantias;
        this.prima_servicios = prima_servicios;
        this.salario = salario;
        this.salario_base = salario_base;
        this.total_liquidacion = total_liquidacion;
        this.vacaciones = vacaciones;
        this.employee = employee;
    }

    public static LiquidacionDTO fromDomain(Liquidacion liquidacion) {
        return new LiquidacionDTO(
                liquidacion.getEmployee().getIdEmployee(),
                liquidacion.getFechaFin(),
                liquidacion.getMotivo(),
                liquidacion.getDiasLaborados(),
                liquidacion.getAuxTransporte(),
                liquidacion.getAuxilio(),
                liquidacion.getBono(),
                liquidacion.getCesantias(),
                liquidacion.getDiasLaborados(),
                liquidacion.getFechaFin(),
                liquidacion.getFechaInicio(),
                liquidacion.getInteresesCesantias(),
                liquidacion.getPrimaServicios(),
                liquidacion.getSalario(),
                liquidacion.getSalarioBase(),
                liquidacion.getTotalLiquidacion(),
                liquidacion.getVacaciones(),
                liquidacion.getDiasLaborados());
    }

    public static Liquidacion toDomain(Double salario, Double auxilio, LocalDate fechaInicio, LocalDate fechaFin, String motivo,
                                       int diasLaborados, Double salarioBase, Double primaServicios, Double cesantias, Double interesesCesantias,
                                       Double vacaciones, Double auxTransporte, Double bono, Double totalLiquidacion, Employee employee) {
        return new Liquidacion(salario, auxilio, fechaInicio, fechaFin, motivo, diasLaborados, salarioBase, primaServicios,
                cesantias, interesesCesantias, vacaciones, auxTransporte, bono, totalLiquidacion, employee);
    }

}
