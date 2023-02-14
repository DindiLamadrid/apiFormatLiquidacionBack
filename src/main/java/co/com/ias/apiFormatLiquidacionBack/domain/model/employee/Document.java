package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class Document {

    private final String value;

    public Document(String value) {
        notNull(value, "The id cannot be empty");
        String val = value.toString();
        if (val.length() < 7) {
            throw new IllegalArgumentException("Minimun size of 7 digits");
        }
        if(val.length() > 15){
            throw new IllegalArgumentException("Maximun size of 15 digits");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}