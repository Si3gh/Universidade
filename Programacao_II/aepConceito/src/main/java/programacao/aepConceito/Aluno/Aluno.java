package programacao.aepConceito.Aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class Aluno {

    @Id
    private String id = UUID.randomUUID().toString();


    @Column(name = "nome")
    @NotNull
    @Size(min=1)
    private String nome;

    public String getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}