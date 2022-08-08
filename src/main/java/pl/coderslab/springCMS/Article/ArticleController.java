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

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {
    private ArticleDao articleDao;
    private CategoryDao categoryDao;
    private AuthorDao authorDao;

    private ArticleRepository articleRepository;


    public ArticleController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao, ArticleRepository articleRepository) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
        this.articleRepository = articleRepository;
    }

    @Transactional
    @GetMapping("list")
    public String getList(Model model) {
        List<Article> all = articleDao.findAll();
        model.addAttribute("articles", all);

        return "articlesList";

    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("article", new Article());
//        model.addAttribute("authors", authorDao.findAll());
//        model.addAttribute("categories", categoryDao.findAll());

        return "addArticle";
    }

    @PostMapping("add")
    public String save(@Valid Article article, BindingResult result) { // dodane alby wyswietlic kominkat bledu

        if (result.hasErrors()) {
            return "addArticle";
        }
        articleDao.save(article);
        return "redirect:/article/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Article byId = articleDao.findById(id);
        articleDao.delete(byId);
        return "redirect:/article/list";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable Long id, Model model) {
        Article byId = articleDao.findById(id);
        model.addAttribute("article", byId);
        return "addArticle";

    }

    @PostMapping("/edit/{id}")
    public String edit(Article article) {
        articleDao.update(article);
        return "redirect:/article/list";
    }


    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAll();

    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryDao.findAll();

    }

    @GetMapping("/{categoryName}")
    public String showArticleByCategory(@PathVariable String categoryName, Model model) {
        model.addAttribute("articlesByCategory",articleRepository.findAllByCategoriesName(categoryName));
        return "articlesListByCategory";
    }
}
