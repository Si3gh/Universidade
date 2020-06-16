package rest.api.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.api.demo.entity.Pessoa;
import rest.api.demo.exception.PessoaNotFoundException;
import rest.api.demo.repository.PessoaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository PessoaRepository;

    public UUID saveNewPessoa(Pessoa Pessoa) {
        if(Pessoa.getNome().isEmpty()){
            throw new RuntimeException("Campo vazio. Inválido");
        }
        return PessoaRepository.save(Pessoa).getId();
    }

    public Pessoa getById(UUID id) {
        return PessoaRepository.findById(id).orElseThrow(PessoaNotFoundException::new);
    }

    public List<Pessoa> getAll() {
        return PessoaRepository.findAll();
    }

    public UUID updatePessoa(UUID id, Pessoa Pessoa) {
        return PessoaRepository.save(Pessoa).getId();
    }

    public UUID deletePessoa(UUID uuid) {
        var pessoaRemovida = PessoaRepository.findById(uuid).orElseThrow(PessoaNotFoundException::new);
        PessoaRepository.delete(pessoaRemovida);
        return uuid;
    }
}
