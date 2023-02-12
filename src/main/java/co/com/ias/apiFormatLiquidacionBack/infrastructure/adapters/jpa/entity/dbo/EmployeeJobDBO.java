package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.notNull;

public class EmployeeJobDBO {
    private final String value;

    public EmployeeJobDBO(String value) {
        notNull(value, "The name cannot be empty");
        Assert.isTrue(value.length() <= 15, "Maximum size of 15 digits");  // cambiarlo para que deje solo un maximo de 15 digitos y crear el de minimo 7 digitos
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", value), "The name can only contain letters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
