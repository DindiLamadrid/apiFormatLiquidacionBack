package co.com.ias.apiFormatLiquidacionBack.domain.model.salary.dto;


import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.Employee;
import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.Liquidacion.dto.Liquidacion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAux_transporte() {
        return aux_transporte;
    }

    public void setAux_transporte(Double aux_transporte) {
        this.aux_transporte = aux_transporte;
    }

    public Double getAuxilio() {
        return auxilio;
    }

    public void setAuxilio(Double auxilio) {
        this.auxilio = auxilio;
    }

    public Double getBono() {
        return bono;
    }

    public void setBono(Double bono) {
        this.bono = bono;
    }

    public Double getCesantias() {
        return cesantias;
    }

    public void setCesantias(Double cesantias) {
        this.cesantias = cesantias;
    }

    public Integer getDias_laborados() {
        return dias_laborados;
    }

    public void setDias_laborados(Integer dias_laborados) {
        this.dias_laborados = dias_laborados;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public LocalDate getDecha_inicio() {
        return decha_inicio;
    }

    public void setDecha_inicio(LocalDate decha_inicio) {
        this.decha_inicio = decha_inicio;
    }

    public Double getIntereses_cesantias() {
        return intereses_cesantias;
    }

    public void setIntereses_cesantias(Double intereses_cesantias) {
        this.intereses_cesantias = intereses_cesantias;
    }

    public Double getPrima_servicios() {
        return prima_servicios;
    }

    public void setPrima_servicios(Double prima_servicios) {
        this.prima_servicios = prima_servicios;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(Double salario_base) {
        this.salario_base = salario_base;
    }

    public Double getTotal_liquidacion() {
        return total_liquidacion;
    }

    public void setTotal_liquidacion(Double total_liquidacion) {
        this.total_liquidacion = total_liquidacion;
    }

    public Double getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(Double vacaciones) {
        this.vacaciones = vacaciones;
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
