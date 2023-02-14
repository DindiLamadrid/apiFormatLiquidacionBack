package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.notNull;

public class Name {
    private final String value;

    public Name(String value) {
        notNull(value, "The name cannot be empty");
        Assert.isTrue(value.length() <= 50, "The name must not exceed 50 characters");
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", value), "The name can only contain letters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
