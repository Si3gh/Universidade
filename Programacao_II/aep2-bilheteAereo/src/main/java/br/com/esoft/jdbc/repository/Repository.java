package br.com.esoft.jdbc.repository;

import java.util.Collection;

public interface Repository<T> {
    void excluirTodos();

    void excluir(int id);

    void alterar(T objeto);

    Collection<T> obterTodas();

    void inserir(T objeto);
}
