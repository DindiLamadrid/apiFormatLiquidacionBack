package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.util.Assert.notNull;

public class StartDate {
    private final LocalDate value;
    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/dd/MM");
    DateTimeFormatter df  = DateTimeFormatter.ofPattern("d-MMM-yyyy");

    public StartDate(LocalDate value) {
        LocalDate dateMax = LocalDate.of(2015, 6, 6); //
        LocalDate dateMin = LocalDate.of(2015, 1, 1); //

        String format = null;
        LocalDate ld = LocalDate.parse(format);
        notNull(value, "The name cannot be empty");

        if (value.isAfter(dateMax)) {
            throw new IllegalArgumentException("Date cannot be after 06/06/2015");
        }
        if (value.isBefore(dateMin)) {
            throw new IllegalArgumentException("Date cannot be before 01/01/2015");
        }
        //format = FORMATTER.format(value);

        this.value = ld;
    }

    public LocalDate getValue() {
        return value;
    }

}
