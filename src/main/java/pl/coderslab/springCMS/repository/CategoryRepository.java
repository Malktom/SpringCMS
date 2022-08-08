package pl.coderslab.springCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springCMS.Article.Article;
import pl.coderslab.springCMS.Category.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category, Long> {


    List<Category> findAll();
}
