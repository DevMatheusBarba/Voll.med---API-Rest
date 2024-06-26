package med.vol.api.domain.consultas.validacoes;

import med.vol.api.domain.ValidacaoException;
import med.vol.api.domain.consultas.ConsultaRepository;
import med.vol.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorConsultaHorarioMedico implements ValidadorAgendamentoConsultas{


    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsulta = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsulta){
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}


