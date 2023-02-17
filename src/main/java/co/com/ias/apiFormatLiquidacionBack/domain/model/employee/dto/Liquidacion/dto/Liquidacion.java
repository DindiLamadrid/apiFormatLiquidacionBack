package co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.Liquidacion.dto;

import java.time.LocalDate;

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
    private Long idEmployee;

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getAuxilio() {
        return auxilio;
    }

    public void setAuxilio(Double auxilio) {
        this.auxilio = auxilio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getDiasLaborados() {
        return diasLaborados;
    }

    public void setDiasLaborados(int diasLaborados) {
        this.diasLaborados = diasLaborados;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Double getPrimaServicios() {
        return primaServicios;
    }

    public void setPrimaServicios(Double primaServicios) {
        this.primaServicios = primaServicios;
    }

    public Double getCesantias() {
        return cesantias;
    }

    public void setCesantias(Double cesantias) {
        this.cesantias = cesantias;
    }

    public Double getInteresesCesantias() {
        return interesesCesantias;
    }

    public void setInteresesCesantias(Double interesesCesantias) {
        this.interesesCesantias = interesesCesantias;
    }

    public Double getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(Double vacaciones) {
        this.vacaciones = vacaciones;
    }

    public Double getAuxTransporte() {
        return auxTransporte;
    }

    public void setAuxTransporte(Double auxTransporte) {
        this.auxTransporte = auxTransporte;
    }

    public Double getBono() {
        return bono;
    }

    public void setBono(Double bono) {
        this.bono = bono;
    }

    public Double getTotalLiquidacion() {
        return totalLiquidacion;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setTotalLiquidacion(Double totalLiquidacion) {
        this.totalLiquidacion = totalLiquidacion;
    }

    private Double auxTransporte;
    private Double bono;
    private Double totalLiquidacion;


    public Liquidacion(Double salario, Double auxilio, LocalDate fechaInicio, LocalDate fechaFin, String motivo, int diasLaborados, Double salarioBase, Double primaServicios, Double cesantias, Double interesesCesantias, Double vacaciones, Double auxTransporte, Double bono, Double totalLiquidacion) {
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
    }


}

