package rest.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rest.api.demo.entity.Pessoa;
import rest.api.demo.service.PessoaService;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Pessoas")
public class PessoaController {
    @Autowired
    private PessoaService PessoaService;

    @GetMapping
    public List<Pessoa> getAll()
    {
        return PessoaService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pessoa getOne(@PathVariable("id")UUID id ){
        return PessoaService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID post(@RequestBody Pessoa Pessoa){
        return PessoaService.saveNewPessoa(Pessoa);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UUID put(@RequestBody Pessoa Pessoa, @PathVariable("id") UUID id){
        if(!id.equals(Pessoa.getId())){
            throw new RuntimeException("Os IDS nao sao compativeis");
        }
        return PessoaService.updatePessoa(id, Pessoa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") UUID uuid){
        PessoaService.deletePessoa(uuid);
    }
}
