package pl.coderslab.springCMS;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category author){
        entityManager.persist(author);
    }

    public void update(Category author){
        entityManager.merge(author);
    }

    public void delete(Category author){
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }
}