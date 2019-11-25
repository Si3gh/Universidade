package esoft.programacao.aep.http.pessoa;

import esoft.programacao.aep.http.base.BaseController;
import esoft.programacao.aep.http.base.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController
@RequestMapping("/api/pessoas")
public class PessoaController extends BaseController<Pessoa, PessoaRepository> {

    @Override
    public void afterPost(Pessoa object) {
        if (object.getId().contains("b")) {
            throw new BusinessException("Letra 'b' não permitida no id!");
        }
    }

    @PostMapping("/fisicas")
    public String post(@RequestBody Fisica nova) {
        return super.post(nova);
    }

    @PostMapping("/juridicas")
    public String post(@RequestBody Juridica nova) {
        return super.post(nova);
    }

    @PutMapping("/fisicas/{id}")
    public ResponseEntity<String> put(@PathVariable("id") String id, @RequestBody Fisica pessoa) {
        return super.put(id, pessoa);
    }

    @PutMapping("/juridicas/{id}")
    public ResponseEntity<String> put(@PathVariable("id") String id, @RequestBody Juridica pessoa) {
        return super.put(id, pessoa);
    }




}