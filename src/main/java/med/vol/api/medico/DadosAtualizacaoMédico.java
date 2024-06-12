package med.vol.api.medico;

import jakarta.validation.constraints.NotNull;
import med.vol.api.endereco.DadosCadastroEndereco;

public record DadosAtualizacaoMédico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosCadastroEndereco endereco,
        Boolean ativo) {
}
