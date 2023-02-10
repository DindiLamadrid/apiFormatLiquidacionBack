package co.com.ias.apiFormatLiquidacionBack.application.configuration;

import co.com.ias.apiFormatLiquidacionBack.domain.model.gateway.IEmployeeRepository;
import co.com.ias.apiFormatLiquidacionBack.domain.usecase.EmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public EmployeeUseCase employeeUseCase(IEmployeeRepository iEmployeeRepository) {
        return new EmployeeUseCase(iEmployeeRepository);
    }

}
