package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo.EmployeeSalaryDBO;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.notNull;

public class EmployeeSalary {
    private final String value;

    public EmployeeSalary(String value) {
        notNull(value, "The name cannot be empty");
        Assert.isTrue(value.length() <= 50, "The name must not exceed 50 characters");//Cambiar para salario máximo en 7 millones
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
