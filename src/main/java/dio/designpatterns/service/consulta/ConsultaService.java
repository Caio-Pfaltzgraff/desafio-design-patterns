package dio.designpatterns.service.consulta;

import dio.designpatterns.model.consulta.Consulta;
import dio.designpatterns.model.consulta.ConsultaAlteraDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaService {
    void agendar(String IdPaciente, Long idMedico, LocalDateTime data);
    void cancelar(Long idConsulta);
    void remarcar(Long idConsulta, ConsultaAlteraDTO alteracao);
    List<Consulta> buscarProximasConsultasPorPaciente(String IdPaciente);
}
