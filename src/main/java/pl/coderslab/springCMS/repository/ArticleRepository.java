package pl.coderslab.springCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springCMS.Article.Article;
import pl.coderslab.springCMS.Author.Author;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository <Article, Long> {


List<Article> findAllByCategoriesName (String categoryName );

    List<Article> findAll();

    Optional<Article> findById(Long Id);

    void deleteById(Long id);

    Article save(Article article);


}
