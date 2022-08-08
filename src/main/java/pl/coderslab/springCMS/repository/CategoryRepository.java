package pl.coderslab.springCMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springCMS.Article.Article;
import pl.coderslab.springCMS.Author.Author;
import pl.coderslab.springCMS.Category.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository <Category, Long> {


    List<Category> findAll();

    Optional<Category> findById(Long Id);

    void deleteById(Long id);

    Category save(Category category);


}
