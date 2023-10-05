package dio.designpatterns.controller;

import dio.designpatterns.model.consulta.Consulta;
import dio.designpatterns.service.consulta.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaServiceImpl consultaServiceImpl;

    @GetMapping
    public ResponseEntity<List<Consulta>> listaConsutas() {
        return ResponseEntity.ok(consultaServiceImpl.findAll());
    }

    @GetMapping("{idPaciente}")
    public ResponseEntity<List<Consulta>> buscarConsultasDePaciente(@PathVariable("idPaciente") String idPaciente) {
        return ResponseEntity.ok(consultaServiceImpl.buscarProximasConsultasPorPaciente(idPaciente));
    }

    @PostMapping
    public ResponseEntity<Consulta> agendar(@RequestBody Consulta consulta) {
        consultaServiceImpl.agendar(consulta.getPaciente().getCpf(), consulta.getMedico().getId(), consulta.getDataDaConsulta());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idConsulta}")
    public ResponseEntity<Consulta> remarcar(@PathVariable("idConsulta") Long id, LocalDateTime dataDaConsulta) {
        var consulta = consultaServiceImpl.findById(id);
        consulta.remarcar(dataDaConsulta);
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("{idConsulta}")
    public ResponseEntity<Consulta> cancelar(@PathVariable("idConsulta") Long idConsulta) {
        consultaServiceImpl.cancelar(idConsulta);
        return ResponseEntity.ok().build();
    }
}
