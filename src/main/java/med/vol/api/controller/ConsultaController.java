package med.vol.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.consultas.AgendaDeConsultas;
import med.vol.api.domain.consultas.DadosAgendamentoConsulta;
import med.vol.api.domain.consultas.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {


    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DadosAgendamentoConsulta dados) {
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping()
    @Transactional
    public void cancelamento(@RequestBody @Valid DadosCancelamentoConsulta dados ){
        agenda.cancelar(dados);


    }


}
