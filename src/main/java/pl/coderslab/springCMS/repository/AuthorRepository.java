package pl.coderslab.springCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springCMS.Article.Article;
import pl.coderslab.springCMS.Author.Author;

public interface AuthorRepository extends JpaRepository <Author, Long> {



}
