package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class Salary {
    private final String value;

    public Salary(String value) {
        notNull(value, "The name cannot be empty");
        Assert.isTrue(value.length() <= 50, "The name must not exceed 50 characters");//Cambiar para salario máximo en 7 millones
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
