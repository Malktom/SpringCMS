package pl.coderslab.springCMS.Category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {
    private CategoryDao categoryDao;


    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("list")
    public String getList(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
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
        categoryDao.save(category);
        return "redirect:/category/list";
    }

    @RequestMapping("/delete/{id}")

    public String deletePerson(@PathVariable Long id) {
        Category byId = categoryDao.findById(id);
        categoryDao.delete(byId);
        return "redirect:/category/list";
    }

    @GetMapping("/edit/{id}")
    public String updatePerson(@PathVariable Long id, Model model) {
        Category byId = categoryDao.findById(id);
        model.addAttribute("category", byId);
        return "addCategory";

    }

    @PostMapping("/edit/{id}")   // {id}?????
    public String edit(Category category) {
        categoryDao.update(category);
        return "redirect:/category/list";
    }

}
