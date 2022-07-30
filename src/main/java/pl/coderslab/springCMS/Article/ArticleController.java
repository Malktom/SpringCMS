package pl.coderslab.springCMS.Article;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springCMS.Author.Author;
import pl.coderslab.springCMS.Author.AuthorDao;
import pl.coderslab.springCMS.Category.CategoryDao;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {
 private ArticleDao articleDao;
 private CategoryDao categoryDao;
 private AuthorDao authorDao;



    public ArticleController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
    }

    @GetMapping("list")
    public String getList (Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "articlesList";

    }
    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("article", new Article());
        return "addArticle";
    }
    @PostMapping("add")
    public String save(Article article) {
        articleDao.save(article);
        return "redirect:/article/list";
    }
    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        Article byId = articleDao.findById(id);
        articleDao.delete(byId);
        return "redirect:/article/list";
    }

    @ModelAttribute("authors")   // sprawdzic jaki jest w widoku .jsp
    public List<String> authors() {
        return authorDao.getAuthorNames();


    }
    @ModelAttribute("categories")   // sprawdzic jaki jest w widoku .jsp
    public List<String> categories() {
       return categoryDao.getCategoryNames();


    }
}
