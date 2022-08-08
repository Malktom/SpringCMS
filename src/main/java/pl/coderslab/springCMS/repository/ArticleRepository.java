package pl.coderslab.springCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springCMS.Article.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository <Article, Long> {


List<Article> findAllByCategoriesName (String categoryName );
}
