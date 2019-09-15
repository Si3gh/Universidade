package programacao.aepConceito.Avaliacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
public class Avaliacao {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "nome")
    @NotNull
    @Size(min=1)
    private String nome;

    @Column(name = "bimestre")
    @NotNull
    private int bimestre;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBimestre() {
        return bimestre;
    }

    public void setBimestre(int bimestre) {
        if(bimestre < 1 || bimestre > 4){
            throw new RuntimeException("Valor para 'Bimestre' deve ser entre 1 e 4");
        }
        this.bimestre = bimestre;

    }

}