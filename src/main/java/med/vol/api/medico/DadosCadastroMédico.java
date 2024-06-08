package med.vol.api.medico;

import med.vol.api.endereco.DadosCadastroEndereco;

public record DadosCadastroMédico(String nome,
                                  String email,
                                  String crm,
                                  Especialidade especialidade,
                                  DadosCadastroEndereco endereco) {

}
