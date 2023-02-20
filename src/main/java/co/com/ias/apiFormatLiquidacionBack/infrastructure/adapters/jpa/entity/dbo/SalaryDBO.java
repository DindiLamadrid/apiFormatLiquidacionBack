package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;
import jakarta.persistence.*;
import lombok.*;

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

    public SalaryDBO(Long idSalary, Double salaryValue) {
        this.idSalary = idSalary;
        this.salaryValue = salaryValue;
    }

    public static Salary toDomain(SalaryDBO salaryDBO) {
        return new Salary(salaryDBO.getIdSalary(), salaryDBO.getSalaryValue()
        );
    }
    public static SalaryDBO fromDomain(Salary salary) {
        return new SalaryDBO(
                salary.getId(),
                salary.getValue()
        );
    }
}

