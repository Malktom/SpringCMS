package pl.coderslab.springCMS.Category;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> findAll() {
        return entityManager.createQuery("select d from Category d").getResultList();

    }

    public List<String> getCategoryNames() {
        return entityManager.createQuery("select d.name from Category d").getResultList();
    }

    public void save(Category category) {
        entityManager.persist(category);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }
}