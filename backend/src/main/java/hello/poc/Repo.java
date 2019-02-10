package hello.poc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Repo  extends JpaRepository<Foo, Integer> {

    Optional<Foo> findByName(String name);

    List<NameOnly> findBybarsIn(List<UUID> barId);
}
