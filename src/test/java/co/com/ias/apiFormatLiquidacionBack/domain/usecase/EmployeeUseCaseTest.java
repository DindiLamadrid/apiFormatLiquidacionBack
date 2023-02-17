package co.com.ias.apiFormatLiquidacionBack.domain.usecase;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class EmployeeUseCaseTest {

    @InjectMocks
    EmployeeUseCase employeeUseCase;

    @Test
    void minimumSizeDocumentTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("1234L");

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
        employeeDTO.setDocument("12345678910101416L");

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
