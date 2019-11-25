package esoft.programacao.aep.http.base;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public abstract class BaseController<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>> {
    @Autowired
    private REPOSITORY repo;


    public REPOSITORY getRepo() {
        return repo;
    }

    @GetMapping("/{id}")
    public ENTITY getById(@PathVariable("id") String id) {
        if(!repo.findById(id).isPresent()) {
            ResponseEntity.status(404).body("Não Encontrado");
        }
        ResponseEntity.status(200).body("OK");
        return repo.findById(id).get();
    }

    @GetMapping
    public List<ENTITY> get() {
        if(repo == null) {
            ResponseEntity.status(205).body("Nenhuma informação pôde ser retornada");;
        }
        //ResponseEntity.status(200).body("OK");
        ResponseEntity.status(302).body("Informação Encontrada");
        return repo.findAll();
    }

    @PostMapping
    public String post(@RequestBody ENTITY object) {
        beforePost(object);
        repo.save(object);
        afterPost(object);
        return object.getId();
    }

    public void beforePost(ENTITY object) {
    }
    public void afterPost(ENTITY object) {
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> put(@PathVariable String id, @RequestBody ENTITY object) {
        if (!Objects.equals(id, object.getId())) {
            return ResponseEntity.status(400).body("Requisição inválida! Verifique os IDs da entidade!");
        }
        if (!repo.findById(id).isPresent()) {
            return ResponseEntity.status(404).build();
        }
        repo.save(object);
        return ResponseEntity.status(HttpStatus.OK).build(); //.ok().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        if(!repo.findById(id).isPresent()) {
            ResponseEntity.status(404).body("Não Encontrado");
        }
        ResponseEntity.status(200).body("OK");

        repo.deleteById(id);
    }

}