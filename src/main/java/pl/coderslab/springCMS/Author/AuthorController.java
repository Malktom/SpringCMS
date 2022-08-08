package pl.coderslab.springCMS.Author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springCMS.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("author")
public class AuthorController {

//    private AuthorDao authorDao;
    private AuthorRepository authorRepository;

    public AuthorController(AuthorDao authorDao, AuthorRepository authorRepository) {
//        this.authorDao = authorDao;
        this.authorRepository = authorRepository;
    }

    @GetMapping("list")
    public String getList(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authorsList";

    }


    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("add")
    public String save(@Valid Author author, BindingResult result) { // dodac @RequestBody dla JSON
        if (result.hasErrors()) {
            return "addAuthor";
        }
        authorRepository.save(author);
        return "redirect:/author/list";
    }

    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
//        Optional<Author> byId = authorRepository.findById(id);
        authorRepository.deleteById(id);
        return "redirect:/author/list";
    }

    @GetMapping("/edit/{id}")
    public String updatePerson(@PathVariable Long id, Model model) {
        Optional<Author> byId = authorRepository.findById(id);
        model.addAttribute("author", byId);
        return "addAuthor";

    }

    @PostMapping("/edit/{id}")   // {id}?????
    public String edit(Author author) {
        authorRepository.save(author);
        return "redirect:/author/list";
    }

}
