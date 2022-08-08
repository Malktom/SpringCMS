package pl.coderslab.springCMS.Article;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import pl.coderslab.springCMS.Author.Author;
import pl.coderslab.springCMS.Category.Category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max=200)
    private String title;
    @ManyToOne
    private Author author;
    @ManyToMany(fetch = FetchType.EAGER)   // @Transactional dodany do kontrlera gdy zmieimy EAGER, utrzymanie encji w sesji
    private List<Category> categories;
    @Length(min=5)
    @NotBlank
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return this.title + " " +
                this.author + " " +
                this.created;
    }
}
