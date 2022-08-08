package pl.coderslab.springCMS.Article;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springCMS.Author.Author;
import pl.coderslab.springCMS.Author.AuthorDao;
import pl.coderslab.springCMS.Category.Category;
import pl.coderslab.springCMS.Category.CategoryDao;
import pl.coderslab.springCMS.repository.ArticleRepository;
import pl.coderslab.springCMS.repository.AuthorRepository;
import pl.coderslab.springCMS.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("article")
public class ArticleController {

    private ArticleRepository articleRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;

    public ArticleController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao, ArticleRepository articleRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {

        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @GetMapping("list")
    public String getList(Model model) {
        List<Article> all = articleRepository.findAll();
        model.addAttribute("articles", all);

        return "articlesList";

    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("article", new Article());

        return "addArticle";
    }

    @PostMapping("add")
    public String save(@Valid Article article, BindingResult result) { // dodane alby wyswietlic kominkat bledu

        if (result.hasErrors()) {
            return "addArticle";
        }
        articleRepository.save(article);
        return "redirect:/article/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return "redirect:/article/list";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable Long id, Model model) {
        Optional<Article> byId = articleRepository.findById(id);
        model.addAttribute("article", byId);
        return "addArticle";

    }

    @PostMapping("/edit/{id}")
    public String edit(Article article) {
        articleRepository.save(article);
        return "redirect:/article/list";
    }


    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorRepository.findAll();

    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();

    }

    @GetMapping("/{categoryName}")
    public String showArticleByCategory(@PathVariable String categoryName, Model model) {
        model.addAttribute("articlesByCategory", articleRepository.findAllByCategoriesName(categoryName));
        return "articlesListByCategory";
    }
}
