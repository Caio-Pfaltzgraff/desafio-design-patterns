package dio.designpatterns.model.consulta;

import dio.designpatterns.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query("""
            SELECT c
            FROM Consulta c
            WHERE c.paciente.cpf = :cpf
            AND c.dataDaConsulta >= NOW()
            AND c.consultaCancelada = false
            ORDER BY c.dataDaConsulta
            """)
    List<Consulta> buscarConsultaPorPaciente(String cpf);

    @Query("""
            SELECT c 
            FROM Consulta c
            WHERE c.consultaCancelada = false
            """)
    List<Consulta> buscarTodasConsultas();
}
