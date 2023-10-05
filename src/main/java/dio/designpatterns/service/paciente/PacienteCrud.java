package dio.designpatterns.service.paciente;

import dio.designpatterns.model.paciente.Paciente;

import java.util.List;

/**
 * Interface para implementar o patter Strategy
 *
 * @author Caio-Pfaltzgraff
 */
public interface PacienteCrud {
    List<Paciente> findAll();
    Paciente findById(String id);
    void save(Paciente paciente);
    void update(String id,Paciente paciente);
    void delete(String id);
}
