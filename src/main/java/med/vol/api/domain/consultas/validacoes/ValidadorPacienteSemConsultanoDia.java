package med.vol.api.domain.consultas.validacoes;

import med.vol.api.domain.ValidacaoException;
import med.vol.api.domain.consultas.ConsultaRepository;
import med.vol.api.domain.consultas.DadosAgendamentoConsulta;
import med.vol.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorPacienteSemConsultanoDia implements ValidadorAgendamentoConsultas{

    @Autowired
    private ConsultaRepository repository;


    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);

        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada para esse dia");
        }
    }
}
