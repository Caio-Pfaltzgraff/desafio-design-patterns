package dio.designpatterns.service.paciente;

import dio.designpatterns.model.endereco.Endereco;
import dio.designpatterns.model.paciente.Paciente;
import dio.designpatterns.model.paciente.PacienteRepository;
import dio.designpatterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

/**
 * Implementando os pattern strategy e o singleton nesta classe
 */
@Service
public class PacienteService implements PacienteCrud{
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAllByAtivoTrue().stream().sorted(Comparator.comparing(Paciente::getNome)).toList();
    }

    @Override
    public Paciente findById(String id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Paciente paciente) {
        var cep = paciente.getEndereco().getCep();

        paciente.setEndereco(buscarEnderecoPorCep(cep));
        pacienteRepository.save(paciente);
    }

    @Override
    @Transactional
    public void update(String id, Paciente paciente) {
        var pacienteCadastrado = pacienteRepository.getReferenceById(id);
        var cep = paciente.getEndereco().getCep();

        paciente.setEndereco(buscarEnderecoPorCep(cep));
        pacienteCadastrado.atualizarInformacoes(paciente);
    }

    @Override
    @Transactional
    public void delete(String id) {
        pacienteRepository.getReferenceById(id).excluir();
    }

    public Endereco buscarEnderecoPorCep(String cep) {
        return viaCepService.obterCep(cep);
    }
}
