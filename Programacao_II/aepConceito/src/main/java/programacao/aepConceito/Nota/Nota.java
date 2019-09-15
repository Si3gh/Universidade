package programacao.aepConceito.Nota;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Nota {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private float valor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getvalor() {
        return valor;
    }

    public void setValor(float nota) {
        if(nota < 0 || nota > 10){
            throw new NotaInvalidaException("Nota invalida");
        }
        this.valor = nota;
    }
}
