package dio.designpatterns.service.consulta;

import dio.designpatterns.model.consulta.Consulta;
import dio.designpatterns.model.consulta.ConsultaAlteraDTO;
import dio.designpatterns.model.consulta.ConsultaRepository;
import dio.designpatterns.model.medico.Medico;
import dio.designpatterns.model.paciente.Paciente;
import dio.designpatterns.service.medico.MedicoService;
import dio.designpatterns.service.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService{
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void agendar(String IdPaciente, Long idMedico, LocalDateTime data) {
        var paciente = pacienteService.findById(IdPaciente);
        var medico = medicoService.findById(idMedico);
        consultaRepository.save(new Consulta(null, medico, paciente, data, false));
    }

    @Override
    public void cancelar(Long idConsulta) {
        consultaRepository.getReferenceById(idConsulta).cancelar();
    }

    @Override
    public void remarcar(Long idConsulta, ConsultaAlteraDTO alteracao) {
        var consulta = consultaRepository.getReferenceById(idConsulta);
        var medico = medicoService.findById(alteracao.getIdMedico());
        consulta.remarcar(medico, alteracao.getNovaData());
    }

    @Override
    public List<Consulta> buscarProximasConsultasPorPaciente(String idPaciente) {
        Paciente paciente = pacienteService.findById(idPaciente);
        return consultaRepository.buscarConsultaPorPaciente(paciente.getCpf());
    }

    public List<Consulta> findAll() {
        return consultaRepository.buscarTodasConsultas().stream().sorted(Comparator.comparing(Consulta::getDataDaConsulta)).toList();
    }

    public Consulta findById(Long idConsulta) {
        return consultaRepository.getReferenceById(idConsulta);
    }

    public Medico getMedico(Long idMedico) {
        return medicoService.findById(idMedico);
    }
}
