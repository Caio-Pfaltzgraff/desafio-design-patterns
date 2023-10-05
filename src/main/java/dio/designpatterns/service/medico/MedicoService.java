package dio.designpatterns.service.medico;

import dio.designpatterns.model.endereco.Endereco;
import dio.designpatterns.model.medico.Medico;
import dio.designpatterns.model.medico.MedicoRepository;
import dio.designpatterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MedicoService implements MedicoCrud{

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<Medico> findAll() {
        return medicoRepository.findAll().stream().sorted(Comparator.comparing(Medico::getNome)).toList();
    }

    @Override
    public Medico findById(Long id) {
        return medicoRepository.getReferenceById(id);
    }

    @Override
    public void save(Medico medico) {
        String cep = medico.getEndereco().getCep();
        medico.setEndereco(viaCepService.obterCep(cep));
        medicoRepository.save(medico);
    }

    @Override
    public void update(Long id, Medico medico) {
        var medicoCadastrado = medicoRepository.getReferenceById(id);
        var cep = medico.getEndereco().getCep();

        medico.setEndereco(viaCepService.obterCep(cep));
        medicoCadastrado.atualizarInformacoes(medico);
    }

    @Override
    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }
}
