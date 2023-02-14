package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.notNull;

public class Job {

    private final String value;

    public Job(String value) {
        notNull(value, "The name cannot be empty"); //Cambiarlo a puede estar vacio para crear
        Assert.isTrue(value.length() <= 30, "The name must not exceed 50 characters"); //cambiarlo a tamaño maximo de 30 caracteres y minimo de 10 caracteres
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", value), "The name can only contain letters");
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    }


