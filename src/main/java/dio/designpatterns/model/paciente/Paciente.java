package dio.designpatterns.model.paciente;

import dio.designpatterns.model.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Entidade que representa um paciente.
 *
 * @author Caio-Pfaltzgraff
 */

@Entity
@Table(name = "tb_pacientes")
@Getter
@EqualsAndHashCode(of = "cpf")
public class Paciente {

    @Id
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private @Setter Endereco endereco;
    private Boolean ativo;

    public Paciente() {
        this.ativo = true;
    }

    public Paciente(String cpf, String nome, String email, String telefone, Endereco endereco, Boolean ativo) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.ativo = true;
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(Paciente paciente) {
        if(paciente.getNome() != null) {
            this.nome = paciente.getNome();
        }
        if(paciente.getEmail() != null) {
            this.email = paciente.getEmail();
        }
        if(paciente.getEndereco() != null) {
            this.endereco.alterarEndereco(paciente.getEndereco());
        }
        if (paciente.getTelefone() != null) {
            this.telefone = paciente.getTelefone();
        }
    }
}
