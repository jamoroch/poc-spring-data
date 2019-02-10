package hello.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@RestController
@Transactional
public class Service {

    @Autowired
    private Repo repo;

    @GetMapping(value = "/")
    public ResponseEntity getAllFoo(){
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping(value = "foo/{name}")
        public ResponseEntity getFoo(@PathVariable("name") String name){
            Optional<Foo> of = repo.findByName(name);
            if(of.isPresent()) {
                return ResponseEntity.ok(repo.findByName(name).get());
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @GetMapping(value = "foo/bar/{barId}")
    public ResponseEntity getNamesByBar(@PathVariable("barId") UUID barId){
        return ResponseEntity.ok(repo.findBybarsIn(Collections.singletonList(barId)));
    }

    @PostMapping("foo/{name}")
    public ResponseEntity addFoo(@PathVariable("name") String name){

        Foo f = new Foo();

        f.setName(name);


        return ResponseEntity.ok(repo.save(f));
    }

    @PostMapping("/foo/{name}/bar/{barId}")
    public ResponseEntity addBarToFoo(@PathVariable("name") String name, @PathVariable("barId") UUID barId){
        Optional<Foo> f = repo.findByName(name);

        if(!f.isPresent()){
        } else {
            Foo e = f.get();

            e.getBars().add(barId);
            return ResponseEntity.ok(repo.save(e));
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/foo/{name}")
    public ResponseEntity deleteFoo(@PathVariable("name") String name){
        repo.findByName(name).ifPresent(f -> repo.delete(f));
        return ResponseEntity.noContent().build();

    }


}
