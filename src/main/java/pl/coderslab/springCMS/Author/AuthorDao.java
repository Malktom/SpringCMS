package pl.coderslab.springCMS.Author;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springCMS.Category.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Author> findAll() {
        return entityManager.createQuery("select d from Author d ").getResultList();

    }

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