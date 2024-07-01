package med.vol.api.controller;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.consultas.AgendaDeConsultas;
import med.vol.api.domain.consultas.DadosAgendamentoConsulta;
import med.vol.api.domain.consultas.DadosDetalhamentoConsulta;
import med.vol.api.domain.medico.Especialidade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.webservices.server.AutoConfigureMockWebServiceClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc // Configurar o Mock
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc; //Pode simular requisições

    @Autowired
    private JacksonTester<DadosAgendamentoConsulta> dadosAgendamentoConsultaJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoConsulta> dadosDetalhamentoConsultaJson;

    @MockBean
    private AgendaDeConsultas agendaDeConsultas;


    @Test
    @DisplayName("Deveria devolver código HTTP 400 quando informações estão invalidas")
    @WithMockUser //Auteticar um usuário dinamico
    void agenda_cenario1() throws Exception {
        var response = mvc.perform(post("/consultas"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    };


    @Test
    @DisplayName("Deveria devolver código HTTP 200 quando informações estão validas")
    @WithMockUser //Auteticar um usuário dinamico
    void agenda_cenario2() throws Exception {

        Especialidade especialidade = Especialidade.CARDIOLOGIA;
        LocalDateTime data = LocalDateTime.now().plusHours(1);

        var dadosDetalhamento = new DadosDetalhamentoConsulta(null, 2l,5l,data);
        when(agendaDeConsultas.agendar(any())).thenReturn(dadosDetalhamento);

        var response = mvc.perform(post("/consultas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosAgendamentoConsultaJson.write(
                                new DadosAgendamentoConsulta(2l,5l, data, especialidade)
                        ).getJson()) // Fazer o processo de criação de Json de através da class
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = dadosDetalhamentoConsultaJson.write(
                dadosDetalhamento
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    };

}