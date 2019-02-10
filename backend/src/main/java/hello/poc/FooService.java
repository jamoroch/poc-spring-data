package hello.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class FooService {

    @Autowired
    FooRepository repository;

    public List<Foo> getAll() {
        return repository.findAll();
    }

    public Optional<Foo> getFooByName(String name) {
        return repository.findByName(name);
    }

    public List<FooNameOnly> getBybarsIn(UUID barId) {
        return repository.findBybarsIn(Collections.singletonList(barId));
    }

    private Foo saveFoo(Foo f) {
        return repository.save(f);
    }

    public Foo saveFoo(String name){
        Foo foo = new Foo();
        foo.setName(name);
        return saveFoo(foo);
    }

    public void deleteFoo(Foo f) {
        repository.delete(f);
    }

    public Foo addBarToFoo(String name, UUID barId) {
        Foo foo = getFooByName(name).orElseThrow(RuntimeException::new);

        foo.getBars().add(barId);
        return saveFoo(foo);
    }
}