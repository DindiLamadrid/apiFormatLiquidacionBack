package co.com.ias.apiFormatLiquidacionBack.domain.model.gateway;

import co.com.ias.apiFormatLiquidacionBack.domain.model.salary.Salary;

public interface ISalaryRepository {

    Salary findSalaryById(Long salary);

    Salary saveSalary(Salary salary);

}
