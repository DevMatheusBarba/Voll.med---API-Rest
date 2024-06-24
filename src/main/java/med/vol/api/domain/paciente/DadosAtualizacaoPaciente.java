package med.vol.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.endereco.DadosCadastroEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String Telefone,
        DadosCadastroEndereco endereco
) {
}
