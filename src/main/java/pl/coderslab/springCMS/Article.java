package pl.coderslab;

import lombok.Getter;
import lombok.Setter;

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
    private Author author;
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
}
