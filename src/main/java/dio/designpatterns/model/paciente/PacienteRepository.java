package dio.designpatterns.model.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
    List<Paciente> findAllByAtivoTrue();
}
