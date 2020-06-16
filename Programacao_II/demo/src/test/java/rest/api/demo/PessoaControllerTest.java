package rest.api.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import rest.api.demo.controller.PessoaController;
import rest.api.demo.entity.Pessoa;
import rest.api.demo.exception.PessoaNotFoundException;
import rest.api.demo.service.PessoaService;

import java.util.ArrayList;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PessoaController.class)
@AutoConfigureMockMvc
public class PessoaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaService PessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test_GetById_With_Valid_Object() throws Exception {
        Pessoa pessoa = new Pessoa("Joao");

        when(PessoaService.getById(any())).thenReturn(pessoa);

        mockMvc.perform(get("/api/Pessoas/c25d3060-e430-4051-875e-f717bdce722c"))
                .andExpect(jsonPath("$.nome").value("Joao"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAll() throws Exception {
        var Pessoas = new ArrayList<Pessoa>(){{
            add(new Pessoa("Joao"));
            add(new Pessoa("Maria"));
        }};

        when(PessoaService.getAll()).thenReturn(Pessoas);

        mockMvc.perform(get("/api/Pessoas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id").isNotEmpty())
                .andExpect(jsonPath("$.[1].id").isNotEmpty())
                .andExpect(jsonPath("$.[0].nome").value("Joao"))
                .andExpect(jsonPath("$.[1].nome").value("Maria"));
    }

    @Test
    void test_Put_With_Valid_Data() throws Exception{
        UUID id = UUID.randomUUID();
        Pessoa novaPessoa = new Pessoa("Joao Pedro");
        novaPessoa.setId(id);

        var object = objectMapper.writeValueAsString(novaPessoa);

        when(PessoaService.updatePessoa(any(), any())).thenReturn(id);

        mockMvc.perform(put("/api/Pessoas/" + id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(object))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$").value(id.toString()));
    }

//    @Test
//    void test_Put_With_Invalid_Data() throws Exception{
//        UUID id = UUID.randomUUID();
//        Pessoa novaPessoa = new Pessoa("Joao Pedro");
//        novaPessoa.setId(id);
//
//        var object = objectMapper.writeValueAsString(novaPessoa);
//
//        when(PessoaService.updatePessoa(any(), any())).thenThrow(PessoaInvalidException.class);
//
//        mockMvc.perform(put("/api/Pessoas/" + id.toString())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(object))
//                .andExpect(status().isUnprocessableEntity());
//    }

    @Test
    void test_Delete_Object() throws Exception{
        UUID id = UUID.randomUUID();

        mockMvc.perform(delete("/api/Pessoas/" + id.toString()))
                .andExpect(status().isAccepted());
    }

    @Test
    void test_Delete_With_Nonexistent_Object() throws Exception{
        UUID id = UUID.randomUUID();

        when(PessoaService.deletePessoa(any())).thenThrow(PessoaNotFoundException.class);

        mockMvc.perform(delete("/api/Pessoas/" + id.toString()))
                .andExpect(status().isNotFound());
    }
}
