package med.vol.api.domain.consultas.validacoes;

import med.vol.api.domain.consultas.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
