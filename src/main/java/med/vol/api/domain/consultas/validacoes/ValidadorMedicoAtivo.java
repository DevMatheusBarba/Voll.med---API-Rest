package med.vol.api.domain.consultas.validacoes;

import med.vol.api.domain.ValidacaoException;
import med.vol.api.domain.consultas.DadosAgendamentoConsulta;
import med.vol.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsultas{

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

       if (dados.idMedico() == null){
            return;
       }

       var medicoAtivo = repository.findAtivoById(dados.idMedico());
       if (!medicoAtivo){
            throw new ValidacaoException("Médico precisa estar ativo para agendar consulta");
       }

    }
}