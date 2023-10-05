package dio.designpatterns.service.medico;

import dio.designpatterns.model.medico.Medico;
import dio.designpatterns.model.paciente.Paciente;

import java.util.List;

public interface MedicoCrud {
    List<Medico> findAll();
    Medico findById(Long id);
    void save(Medico paciente);
    void update(Long id,Medico paciente);
    void delete(Long id);
}
