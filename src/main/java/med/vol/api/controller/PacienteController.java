package med.vol.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.medico.DadosDetalhamentoMedico;
import med.vol.api.domain.medico.DadosListagemMedicos;
import med.vol.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder) {
        Paciente paciente = new Paciente(dados);
        repository.save(paciente);

        var uri = uriComponentsBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhamentoPaciente(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity atualizaPaciente(@RequestBody @Valid DadosAtualizacaoPaciente dados){

    }


}
