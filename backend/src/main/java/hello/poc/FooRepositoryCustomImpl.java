package hello.poc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;

public class FooRepositoryCustomImpl implements FooRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public BigInteger countBars() {
                Query query = em.createNativeQuery("select count(foo_id) from foo_bar");
        return (BigInteger) query.getSingleResult();
    }
}
