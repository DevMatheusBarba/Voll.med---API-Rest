package med.vol.api.domain.endereco;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(DadosCadastroEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.numero();
        this.numero = dadosEndereco.numero();
        this.complemento = dadosEndereco.complemento();
    }

    public void atualizarEndereco(DadosCadastroEndereco dados) {
        if (dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }if (dados.bairro() != null){
            this.bairro = dados.bairro();
        }if (dados.logradouro() != null){
            this.cep = dados.cep();
        }if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }if (dados.uf() != null){
            this.uf = dados.uf();
        }if (dados.numero() != null){
            this.numero = dados.numero();
        }if (dados.complemento() != null){
            this.complemento = dados.complemento();
        }

    }
}
