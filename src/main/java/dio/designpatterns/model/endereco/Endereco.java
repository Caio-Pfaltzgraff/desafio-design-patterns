package dio.designpatterns.model.endereco;

import dio.designpatterns.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entidade que representa um endereco que é preenchido pela API do ViaCep.
 *
 * @author Caio-Pfaltzgraff
 */

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Endereco {
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public void alterarEndereco(Endereco endereco) {
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
        this.ibge = endereco.getIbge();
        this.gia = endereco.getGia();
        this.ddd = endereco.getDdd();
        this.siafi = endereco.getSiafi();
    }
}
