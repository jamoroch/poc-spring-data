package hello.poc;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "foo")
public class Foo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "foo_id")
    private Integer fooId;

    @Column(name = "foo_name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "foo_bar",
            joinColumns = @JoinColumn(name = "foo_id", unique = true, foreignKey = @ForeignKey(name = "foo_fk") ))
    @Column(name = "bar_id")
    private Set<UUID> bars = new HashSet<>();

    public Integer getFooId() {
        return fooId;
    }

    public void setFooId(Integer fooId) {
        this.fooId = fooId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UUID> getBars() {
        return bars;
    }

    public void setBars(Set<UUID> bars) {
        this.bars = bars;
    }
}
