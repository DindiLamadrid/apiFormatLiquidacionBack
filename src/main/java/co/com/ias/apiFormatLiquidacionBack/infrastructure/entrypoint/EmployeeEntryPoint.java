package co.com.ias.apiFormatLiquidacionBack.infrastructure.entrypoint;

import co.com.ias.apiFormatLiquidacionBack.domain.model.employee.dto.EmployeeDTO;
import co.com.ias.apiFormatLiquidacionBack.domain.usecase.EmployeeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeEntryPoint {

    private final EmployeeUseCase employeeUseCase;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<?> get() {
        List<EmployeeDTO> employee = employeeUseCase.findAllEmployees();
        if (employee.isEmpty()) {
            return new ResponseEntity(employee, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(employee, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") String id) {
        return new ResponseEntity(employeeUseCase.findEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<?> create(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity(employeeUseCase.saveEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<?> update(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity(employeeUseCase.updateEmployee(employeeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return new ResponseEntity(employeeUseCase.deleteEmployee(id), HttpStatus.OK);
    }
}
