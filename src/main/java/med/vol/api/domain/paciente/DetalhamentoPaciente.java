package med.vol.api.domain.paciente;

import med.vol.api.domain.endereco.Endereco;

public record DetalhamentoPaciente(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
