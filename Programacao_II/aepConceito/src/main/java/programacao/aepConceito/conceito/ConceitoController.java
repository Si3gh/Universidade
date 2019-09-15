package programacao.aepConceito.conceito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conceito")
public class ConceitoController {
    @Autowired
    private ConceitoRepository conceitoRepository;

    @PostMapping
    private Conceito postConceito(@RequestBody Conceito conceito){
        return conceitoRepository.save(conceito);
    }

    @GetMapping
    private List<Conceito> getAllConceitos(){
        return conceitoRepository.findAll();
    }

    @GetMapping("/{id}")
    private Conceito getConceitoById(@PathVariable("id")String id) {
        return conceitoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conceito não encontrado."));
    }

    @PutMapping("/{id}")
    private Conceito putConceito(@RequestBody Conceito conceitoAtualizado, @PathVariable("id") String id){
        Optional<Conceito> conceito = conceitoRepository.findById(id);

        if(conceito.isPresent()){
            conceitoAtualizado.setId(id);
            return conceitoRepository.save(conceitoAtualizado);
        }
        throw new RuntimeException("Conceito não foi encontrado");
    }

    @DeleteMapping("/{id}")
    private void deleteConceito(@PathVariable("id") String id){
        conceitoRepository.deleteById(id);
    }

}