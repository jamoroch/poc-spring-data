package hello.poc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FooRepository extends JpaRepository<Foo, Integer> {

    Optional<Foo> findByName(String name);

    List<FooNameOnly> findBybarsIn(List<UUID> barId);
}
