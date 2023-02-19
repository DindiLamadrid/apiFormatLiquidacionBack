package co.com.ias.apiFormatLiquidacionBack.domain.model.salary;

import static org.springframework.util.Assert.notNull;

public class Salary {

    private Long id;
    private final Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public Salary(Double value) {
        notNull(value, "The salary cannot be empty");
        if (value <= 0) {
            throw new IllegalArgumentException("The salary cannot be empty");
        }
        if (value < 100000) {
            throw new IllegalArgumentException("The salary cannot be less than current SVML");
        }
        if (value > 7000000) {
            throw new IllegalArgumentException("The salary cannot be more than 7.000.000 COP");
        }
        this.value = value;
    }

    public Salary(Long id, double value) {
        this.id = id;
        this.value = value;
    }
}
