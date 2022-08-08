package pl.coderslab.springCMS.Article;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springCMS.Author.Author;
import pl.coderslab.springCMS.Category.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Article> findAll() {
        return entityManager.createQuery("select d from Article d ").getResultList();
    }
        public List<String> getCategoriesNames() {
            return entityManager.createQuery("select d.name from Category d").getResultList();
        }


    public List<Article> get5LatestArticles() {

        return entityManager.createQuery("SELECT b FROM Article b ORDER BY b.created DESC ").setMaxResults(5).getResultList();
    }

    public void save(Article article) {
        entityManager.persist(article);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }
}