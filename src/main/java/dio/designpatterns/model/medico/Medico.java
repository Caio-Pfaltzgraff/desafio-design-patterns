package dio.designpatterns.model.medico;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dio.designpatterns.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private @Setter Endereco endereco;

    public void atualizarInformacoes(Medico medico) {
        if(medico.nome != null) {
            this.nome = medico.nome;
        }
        if(medico.email != null) {
            this.email = medico.email;
        }
        if(medico.telefone != null) {
            this.telefone = medico.telefone;
        }
        if(medico.endereco != null) {
            this.endereco.alterarEndereco(medico.endereco);
        }
    }
}
