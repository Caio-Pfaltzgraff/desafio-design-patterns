package dio.designpatterns.model.consulta;


import dio.designpatterns.model.medico.Medico;
import dio.designpatterns.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consultas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_cpf")
    private Paciente paciente;

    private LocalDateTime dataDaConsulta;

    private Boolean consultaCancelada = false;

    public void cancelar() {
        this.consultaCancelada = true;
    }

    public void remarcar(LocalDateTime data) {
        this.dataDaConsulta = data;
    }
}
