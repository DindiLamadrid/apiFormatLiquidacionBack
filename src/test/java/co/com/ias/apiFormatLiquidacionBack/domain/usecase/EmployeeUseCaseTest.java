package co.com.ias.apiFormatLiquidacionBack.domain.usecase;

import co.com.ias.apiFormatLiquidacionBack.domain.model.dto.EmployeeDTO;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IEmployeeRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.ISalaryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class EmployeeUseCaseTest {

    @InjectMocks
    EmployeeUseCase employeeUseCase;
    @Mock
    ISalaryRepository iSalaryRepository;
    @Mock
    IEmployeeRepository iEmployeeRepository;

    //TEST DOCUMENT
    @Test
    void minimumSizeDocumentTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "The document must contain 7 digits";
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
        String expectedMessage = "The document must contain 15 digits";
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
        String expectedMessage = "The document cannot be empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    //TEST JOB
    @Test
    void minimumSizeJobTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("123456789");
        employeeDTO.setJob("12222");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "The job must contain more than 10 digits";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void emptyJobTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("123456789");
        employeeDTO.setJob("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "The job must contain more than 10 digits";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void maximunSizeJobTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("123456789");
        employeeDTO.setJob("fgdgbnvbnvnvbnffhfghfhfhgdghdhglllll");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "The job must contain less than 30 digits";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    //TEST NAME
    @Test
    void emptyNameTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("123456789");
        employeeDTO.setJob("Ingeniero de sistemas");
        employeeDTO.setName("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        System.out.println(exception);
        String expectedMessage = "The name cannot be empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void maximunSizeNameTest() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("123456789");
        employeeDTO.setJob("Ingeniero de sistemas");
        employeeDTO.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "The name must contain less than 50 digits";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    //TEST START DATE
    @Test
    void maximunStartDateTest() {
        LocalDate date = LocalDate.of(2015, 7, 6);

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("123456789");
        employeeDTO.setJob("Ingeniero de sistemas");
        employeeDTO.setName("Dindi");
        employeeDTO.setStartDate(date);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "The start date cannot be after 06/06/2015";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void minimunStartDateTest() {
        LocalDate date = LocalDate.of(2014, 7, 6);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDocument("123456789");
        employeeDTO.setJob("Ingeniero de sistemas");
        employeeDTO.setName("Dindi");
        employeeDTO.setStartDate(date);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeUseCase.saveEmployee(employeeDTO);
        });
        String expectedMessage = "The start date cannot be before 01/01/2015";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

        @Test
        void emptyStartDateTest() {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setDocument("123456789");
            employeeDTO.setJob("Ingeniera de software");
            employeeDTO.setName("Dindi");
            employeeDTO.setStartDate(null);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                employeeUseCase.saveEmployee(employeeDTO);
            });
            String expectedMessage = "The start date cannot be empty";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

    }

