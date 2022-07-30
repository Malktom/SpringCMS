package pl.coderslab.springCMS.Article;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.springCMS.Category.Category;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    @ManyToOne
    private Category author;
    @OneToMany
    private List<Category> categories;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void prePersist(){
        created = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        updated=LocalDateTime.now();
    }

    @Override
    public String toString() {
        return this.title+" "+
                this.author+ " "+
                this.created;
    }
}
