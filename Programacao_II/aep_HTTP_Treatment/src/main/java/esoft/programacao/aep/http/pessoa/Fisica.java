package esoft.programacao.aep.http.pessoa;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Fisica extends Pessoa {
    private Date nascidaEm;


    public Date getNascidaEm() {
        return nascidaEm;
    }



}