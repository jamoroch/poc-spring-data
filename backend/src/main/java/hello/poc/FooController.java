package hello.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class FooController {

    @Autowired
    private FooService service;

    @GetMapping(value = "/")
    public ResponseEntity getAllFoo(){
        return ResponseEntity.ok(service.getAll());
    }


    @GetMapping(value = "foo/{name}")
    public ResponseEntity getFoo(@PathVariable("name") String name) {
        Optional<Foo> of = service.getFooByName(name);
        if (of.isPresent()) {
            return ResponseEntity.ok(of.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "foo/bar/{barId}")
    public ResponseEntity getNamesByBar(@PathVariable("barId") UUID barId) {
        return ResponseEntity.ok(service.getBybarsIn(barId));
    }

    @PostMapping("foo/{name}")
    public ResponseEntity addFoo(@PathVariable("name") String name){
        return ResponseEntity.ok(service.saveFoo(name));
    }

    @PostMapping("/foo/{name}/bar/{barId}")
    public ResponseEntity addBarToFoo(@PathVariable("name") String name, @PathVariable("barId") UUID barId) {
        if (!service.getFooByName(name).isPresent()) {
        } else {
            Foo body = service.addBarToFoo(name, barId);
            return ResponseEntity.ok(body);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/foo/{name}")
    public ResponseEntity deleteFoo(@PathVariable("name") String name) {
        service.getFooByName(name).ifPresent(f -> service.deleteFoo(f));
        return ResponseEntity.noContent().build();

    }
}
