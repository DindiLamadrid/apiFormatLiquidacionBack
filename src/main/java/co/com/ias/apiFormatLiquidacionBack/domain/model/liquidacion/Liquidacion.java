package co.com.ias.apiFormatLiquidacionBack.domain.model.liquidacion;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class Liquidacion {
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
    private Employee employee;

    public Double getSalario() {
        return salario;
    }

    public Double getAuxilio() {
        return auxilio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getMotivo() {
        return motivo;
    }

    public int getDiasLaborados() {
        return diasLaborados;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public Double getPrimaServicios() {
        return primaServicios;
    }

    public Double getCesantias() {
        return cesantias;
    }

    public Double getInteresesCesantias() {
        return interesesCesantias;
    }

    public Double getVacaciones() {
        return vacaciones;
    }

    public Double getAuxTransporte() {
        return auxTransporte;
    }

    public Double getBono() {
        return bono;
    }

    public Double getTotalLiquidacion() {
        return totalLiquidacion;
    }

    public Employee getEmployee() {
        return employee;
    }

    private Double auxTransporte;
    private Double bono;
    private Double totalLiquidacion;


    public Liquidacion(Double salario, Double auxilio, LocalDate fechaInicio, LocalDate fechaFin, String motivo,
                       int diasLaborados, Double salarioBase, Double primaServicios, Double cesantias,
                       Double interesesCesantias, Double vacaciones, Double auxTransporte,
                       Double bono, Double totalLiquidacion, Employee employee) {
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
        this.employee = employee;
    }


}

