package med.vol.api.domain.consultas;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.medico.Especialidade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(

        Long idMedico,
        @NotNull
        Long idPaciente,
        @Future @NotNull
        LocalDateTime data,
        Especialidade especialidade) {
}
