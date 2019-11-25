package esoft.programacao.aep.http.pessoa;


import esoft.programacao.aep.http.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Pessoa extends BaseEntity {
    private String nome;

    public Pessoa() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
