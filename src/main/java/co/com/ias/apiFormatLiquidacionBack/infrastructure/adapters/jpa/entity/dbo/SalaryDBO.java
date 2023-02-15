package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Salary")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalary;

    private Double salaryValue;

    @ManyToMany
    @JoinTable(
            name = "employees_list",
            joinColumns = @JoinColumn(name = "idEmployee"),
            inverseJoinColumns = @JoinColumn(name = "idSalary"))
    @JsonIgnoreProperties("salaryList")
//	@ManyToMany(mappedBy = "countriesList")
    private List<SalaryDBO> salaryList;

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
