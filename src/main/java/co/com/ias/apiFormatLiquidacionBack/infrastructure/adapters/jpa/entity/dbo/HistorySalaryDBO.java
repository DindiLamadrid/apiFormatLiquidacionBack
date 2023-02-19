package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.apiFormatLiquidacionBack.domain.model.historysalary.HistorySalary;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HistorySalary")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistorySalaryDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idEmployee;
    private Long idSalary;

    public HistorySalaryDBO(Long idSalary, Long idEmployee) {
        this.idSalary = idSalary;
        this.idEmployee = idEmployee;
    }

    public static HistorySalary toDomain(HistorySalaryDBO historySalaryDBO) {
        return new HistorySalary(
                historySalaryDBO.getIdEmployee(),
                historySalaryDBO.getIdSalary()
        );
    }

    public static HistorySalaryDBO fromDomain(HistorySalary historySalary) {
        return new HistorySalaryDBO(
                historySalary.getIdSalary(), historySalary.getIdEmployee()
        );
    }
}

