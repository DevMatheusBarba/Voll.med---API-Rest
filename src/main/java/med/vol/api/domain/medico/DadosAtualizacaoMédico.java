package med.vol.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.endereco.DadosCadastroEndereco;

public record DadosAtualizacaoMédico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosCadastroEndereco endereco,
        Boolean ativo) {
}
