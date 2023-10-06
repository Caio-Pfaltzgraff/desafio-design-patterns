package dio.designpatterns.model;

import lombok.Getter;

@Getter
public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected String telefone;

    public String exibirInformacoes() {
        return "nome: " + nome + ", email: " + email + ", telefone: " + telefone;
    }
}
