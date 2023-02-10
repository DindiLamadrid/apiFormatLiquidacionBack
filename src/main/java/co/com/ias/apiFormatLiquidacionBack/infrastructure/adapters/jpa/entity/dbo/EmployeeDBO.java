package co.com.ias.apiFormatLiquidacionBack.infrastructure.adapters.jpa.entity.dbo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Employee")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDBO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
