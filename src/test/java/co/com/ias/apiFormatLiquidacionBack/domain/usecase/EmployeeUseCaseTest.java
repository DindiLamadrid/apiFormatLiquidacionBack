package co.com.ias.apiFormatLiquidacionBack.domain.usecase;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.EmployeeDTO;
import co.com.ias.apiFormatLiquidacionBack.infrastructure.entrypoint.EmployeeEntryPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EmployeeUseCaseTest {

    @InjectMocks
    EmployeeUseCase employeeUseCase;

    @Test
    void minimumSizeDocumentTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("1234");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "Minimun size of 7 digits";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void maximunSizeDocumentTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("12345678910101416");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "Maximun size of 15 digits";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void emptyDocumentTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "The id cannot be empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
