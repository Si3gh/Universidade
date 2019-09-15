package programacao.aepConceito.conceito;

import programacao.aepConceito.Aluno.Aluno;
import programacao.aepConceito.Avaliacao.Avaliacao;
import programacao.aepConceito.Nota.Nota;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Conceito {

    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Nota nota;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Avaliacao avaliacao;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Aluno aluno;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}