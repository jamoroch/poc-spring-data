package hello.poc;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@JsonInclude
@EntityListeners(AuditingEntityListener.class)
@Table(name = "foo")
public class Foo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "foo_id")
    private Integer fooId;

    @Size(min=2)
    @Column(name = "foo_name")
    private String name;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
