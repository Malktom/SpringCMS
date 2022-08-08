package pl.coderslab.springCMS.Category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springCMS.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("category")
public class CategoryController {
//    private CategoryDao categoryDao;
    private CategoryRepository categoryRepository;


    public CategoryController(CategoryDao categoryDao, CategoryRepository categoryRepository) {
//        this.categoryDao = categoryDao;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("list")
    public String getList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categoriesList";
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("category", new Category());

        return "addCategory";
    }

    @PostMapping("add")
    public String save(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "addCategory";
        }
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @RequestMapping("/delete/{id}")

    public String deletePerson(@PathVariable Long id) {
//        Optional<Category> byId = categoryRepository.findById(id);
        categoryRepository.deleteById(id);
        return "redirect:/category/list";
    }

    @GetMapping("/edit/{id}")
    public String updatePerson(@PathVariable Long id, Model model) {
        Optional<Category> byId = categoryRepository.findById(id);
        model.addAttribute("category", byId);
        return "addCategory";

    }

    @PostMapping("/edit/{id}")   // {id}?????
    public String edit(Category category) {
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

}
