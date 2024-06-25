package med.vol.api.domain.consultas.validacoes;

import med.vol.api.domain.ValidacaoException;
import med.vol.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;


@Component
public class ValidadeoHorarioFuncionamento implements ValidadorAgendamentoConsultas {

    public void validar (DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();


        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY); //Verificar se o dia da semana é Domingo
        var antesDaAbertura = dataConsulta.getHour() > 7;  //Verificar o horário que está vindo no DTO
        var depoisDoEncerramento = dataConsulta.getHour() > 18;  //Verificar o horário que está vindo no DTO


        if (domingo || antesDaAbertura || depoisDoEncerramento){
            throw new ValidacaoException("Consulta fora do horário de funcionamento");
        }

    }

}
