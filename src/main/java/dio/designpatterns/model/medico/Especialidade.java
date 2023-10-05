package dio.designpatterns.model.medico;

import lombok.Getter;

@Getter
public enum Especialidade {
    ORTOPEDIA("Ortopedia"),
    CARDIOLOGIA("Cardiologia"),
    GINECOLOGIA("Ginecologia"),
    DERMATOLOGIA("Dermatologia");

    private String descricao;

    Especialidade(String descricao) {
        this.descricao = descricao;
    }

}
