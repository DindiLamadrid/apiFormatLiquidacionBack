package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class Document {

    private final Long value;

    public Document(Long value) {
        notNull(value, "The id cannot be empty");
        Assert.isTrue(value.longValue() >= 15, "Maximum size of 15 digits");  // cambiarlo para que deje solo un maximo de 15 digitos y crear el de minimo 7 digitos
        Assert.isTrue(value.longValue() <= 7, "Minimun size of 7 digits");
        this.value = value;
    }
    public Long getValue() {
        return value;
    }

}