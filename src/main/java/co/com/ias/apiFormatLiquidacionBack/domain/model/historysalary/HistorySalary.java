package co.com.ias.apiFormatLiquidacionBack.domain.model.historysalary;

public class HistorySalary {

    private final Long idSalary;
    private final Long idEmployee;

    public Long getIdSalary() {
        return idSalary;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public HistorySalary(Long idSalary, Long idEmployee) {
        this.idSalary = idSalary;
        this.idEmployee = idEmployee;
    }


}
