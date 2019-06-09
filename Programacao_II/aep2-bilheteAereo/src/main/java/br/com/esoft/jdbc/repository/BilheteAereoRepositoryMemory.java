package br.com.esoft.jdbc.repository;

import br.com.esoft.jdbc.entity.BilheteAereo;
import br.com.esoft.jdbc.exception.BilheteAereoNotFound;

import java.util.ArrayList;
import java.util.List;

public class BilheteAereoRepositoryMemory implements Repository<BilheteAereo> {

    private List<BilheteAereo> repositoryList;

    public BilheteAereoRepositoryMemory() {
        this.repositoryList = new ArrayList<>();
    }

    @Override
    public void excluir(int id) {
        BilheteAereo bilheteRemovido = this.repositoryList.stream()
                .filter(bilheteAereo -> bilheteAereo.getId().equals(id))
                .findAny().orElseThrow(BilheteAereoNotFound::new);
        this.repositoryList.remove(bilheteRemovido);
    }

    @Override
    public void excluirTodos() {
        this.repositoryList.clear();
    }


    @Override
    public void alterar(BilheteAereo objeto) {
        excluir(objeto.getId());
        inserir(objeto);
    }

    @Override
    public List<BilheteAereo> obterTodas() {
        return new ArrayList<>(this.repositoryList);
    }

    @Override
    public void inserir(BilheteAereo objeto) {
        this.repositoryList.add(objeto);
    }
}
