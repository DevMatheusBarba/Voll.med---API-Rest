package med.vol.api.domain.consultas.validacoes;

import med.vol.api.domain.ValidacaoException;
import med.vol.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedendiaDeAgendamento implements ValidadorAgendamentoConsultas{


    public void validar(DadosAgendamentoConsulta dados) {

        var agendamento = dados.data();
        var agora = LocalDateTime.now();

        var diferença = Duration.between(agora,agendamento).toMinutes();

        if (diferença < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecdência mínima de 30 minutos");
        }

    }

}
