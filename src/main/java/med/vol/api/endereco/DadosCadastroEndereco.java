package med.vol.api.endereco;

public record DadosCadastroEndereco(String logradouro,
                                    String bairro,
                                    String cep,
                                    String cidade,
                                    String uf,
                                    String numero,
                                    String complemento) {
}
