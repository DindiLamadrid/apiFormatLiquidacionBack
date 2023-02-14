package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class StartDate {
    private final String value;

    public StartDate(String value) {
        //Debe de estar en formato de YYYY/DD/MM
        //No debe permitir fechas superiores 6 de junio del 2015
        //No debe permitir fechas inferiores al 1 de enero de 2015
        notNull(value, "The name cannot be empty");
        Assert.isTrue(value.length() <= 50, "The name must not exceed 50 characters");//Cambiar para salario máximo en 7 millones
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
