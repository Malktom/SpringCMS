package pl.coderslab.springCMS;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springCMS.repository.CategoryRepository;

@Controller

public class HomeController {

   private CategoryRepository categoryRepository;

    public HomeController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    public String start() {
//        return "Spring CMS";
//    }

    @GetMapping("/")
    public String get5LatestArticles(Model model) {
        model.addAttribute("categoriesList", categoryRepository.findAll());
        return "homePageCategories";
    }
}
