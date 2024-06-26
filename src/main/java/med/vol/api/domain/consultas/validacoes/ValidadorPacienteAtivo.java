package med.vol.api.domain.consultas.validacoes;

import med.vol.api.domain.ValidacaoException;
import med.vol.api.domain.consultas.DadosAgendamentoConsulta;
import med.vol.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsultas{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo){
            throw new ValidacaoException("Consulta só pode ser agendada se paciente estiver ativo");
        }

    }
}