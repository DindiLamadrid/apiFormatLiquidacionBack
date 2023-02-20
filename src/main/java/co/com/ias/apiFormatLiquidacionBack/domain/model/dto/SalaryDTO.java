package co.com.ias.apiFormatLiquidacionBack.domain.model.dto;

import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SalaryDTO {
    private Long Id;

    private Double salary;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public SalaryDTO(Long id, Double salary) {
        this.Id = id;
        this.salary = salary;
    }

    public static SalaryDTO fromDomain(Salary salary) {
        return new SalaryDTO(salary.getId(),
                salary.getValue());
    }

    public Salary toDomain(SalaryDTO salaryDTO) {
        return new Salary(
                salaryDTO.getId(),
                salaryDTO.getSalary());
    }
}
