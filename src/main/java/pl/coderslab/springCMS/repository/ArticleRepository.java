package pl.coderslab.springCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springCMS.Article.Article;

public interface ArticleRepository extends JpaRepository <Article, Long> {



}
