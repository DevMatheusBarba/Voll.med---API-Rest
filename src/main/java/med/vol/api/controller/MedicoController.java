package med.vol.api.controller;

import med.vol.api.endereco.Endereco;
import med.vol.api.medico.DadosCadastroMédico;
import med.vol.api.medico.Medico;
import med.vol.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMédico dados){
        Medico medico = new Medico(dados);
        repository.save(medico);
        System.out.println(medico.toString());
    }
}
