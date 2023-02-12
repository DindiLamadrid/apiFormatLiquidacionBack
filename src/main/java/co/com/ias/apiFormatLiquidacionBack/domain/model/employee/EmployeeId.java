package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.notNull;

public class EmployeeId {

    private final String value;

    public EmployeeId(Long value) {
        notNull(value, "The name cannot be empty");
        Assert.isTrue(value.longValue() <= 15, "Maximum size of 15 digits");  // cambiarlo para que deje solo un maximo de 15 digitos y crear el de minimo 7 digitos
        //Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", value), "The name can only contain letters");
        this.value = String.valueOf(value);
    }
    public String getValue() {
        return value;
    }

}