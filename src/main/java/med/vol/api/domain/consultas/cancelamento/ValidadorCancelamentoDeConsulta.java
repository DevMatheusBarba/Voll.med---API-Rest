package med.vol.api.domain.consultas.cancelamento;

import med.vol.api.domain.consultas.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
