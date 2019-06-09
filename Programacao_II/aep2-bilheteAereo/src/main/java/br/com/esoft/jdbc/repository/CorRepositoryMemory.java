package br.com.esoft.jdbc.repository;

import br.com.esoft.jdbc.entity.Cor;
import br.com.esoft.jdbc.exception.CorJaInseridaException;
import br.com.esoft.jdbc.exception.CorNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CorRepositoryMemory implements Repository<Cor> {

    private Set<Cor> corList;

    public CorRepositoryMemory() {
        this.corList = new HashSet<>();
    }

    @Override
    public void excluirTodos() {
        this.corList.clear();
    }

    @Override
    public void excluir(int id) {
        Cor corRemovida = this.corList.stream()
                .filter(cor -> cor.getId() == id)
                .findAny().orElseThrow(CorNotFoundException::new);

        this.corList.remove(corRemovida);
    }

    @Override
    public void alterar(Cor objeto) {
        excluir(objeto.getId());
        inserir(objeto);
    }

    @Override
    public List<Cor> obterTodas() {
        return (List<Cor>) new HashSet<>(corList);
    }

    @Override
    public void inserir(Cor objeto) {
        corList.stream()
                .filter(cor -> cor.getId() != objeto.getId())
                .findAny().ifPresentOrElse(cor -> {
                    throw new CorJaInseridaException();
                },
                () -> corList.add(objeto)
        );
    }
}