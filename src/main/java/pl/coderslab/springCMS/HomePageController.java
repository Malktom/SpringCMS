package pl.coderslab.springCMS;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.springCMS.Article.Article;
import pl.coderslab.springCMS.Article.ArticleDao;

import java.util.List;

@Controller

public class HomePageController {

    private ArticleDao articleDao;


    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/list")
    public String get5LatestArticles(Model model) {
        model.addAttribute("articles", articleDao.get5LatestArticles());
        return "homePageArticles";
    }
}
