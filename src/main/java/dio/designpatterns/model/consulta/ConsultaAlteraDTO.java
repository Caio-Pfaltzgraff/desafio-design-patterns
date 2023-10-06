package dio.designpatterns.model.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaAlteraDTO {
    private Long idMedico;
    private LocalDateTime novaData;
}
