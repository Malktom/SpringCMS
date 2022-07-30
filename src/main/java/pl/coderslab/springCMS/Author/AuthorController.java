package pl.coderslab.springCMS.Author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springCMS.Category.Category;

@Controller
@RequestMapping("author")
public class AuthorController {

    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("list")
    public String getList(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "authorsList";

    }


    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("add")
    public String save(Author author) {
        authorDao.save(author);
        return "redirect:/author/list";
    }

    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        Author byId = authorDao.findById(id);
        authorDao.delete(byId);
        return "redirect:/author/list";
    }

    @GetMapping("/edit/{id}")
    public String updatePerson(@PathVariable Long id, Model model) {
        Author byId = authorDao.findById(id);
        model.addAttribute("author", byId);
        return "addAuthor";

    }

    @PostMapping("/edit/{id}")   // {id}?????
    public String edit(Author author) {
        authorDao.update(author);
        return "redirect:/author/list";
    }

}
