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

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public List<String> getAuthorNames() {
        return entityManager.createQuery("select d.firstName from Author d").getResultList();
    }
}