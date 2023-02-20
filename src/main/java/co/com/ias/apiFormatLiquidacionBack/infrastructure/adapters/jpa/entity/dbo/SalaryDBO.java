package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Salary")
@Builder
@Getter
@Setter
@NoArgsConstructor
public class SalaryDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalary;
    private Double salaryValue;
    private LocalDateTime fechaModificacion;

    public SalaryDBO(Long idSalary, Double salaryValue, LocalDateTime fechaModificacion) {
        this.idSalary = idSalary;
        this.salaryValue = salaryValue;
        this.fechaModificacion = fechaModificacion;
    }

    public static Salary toDomain(SalaryDBO salaryDBO) {
        return new Salary(salaryDBO.getIdSalary(), salaryDBO.getSalaryValue(), salaryDBO.getFechaModificacion()
        );
    }
    public static SalaryDBO fromDomain(Salary salary) {
        return new SalaryDBO(
                salary.getId(),
                salary.getValue(), salary.getFechaModificacion()
        );
    }
}

