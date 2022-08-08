package pl.coderslab.springCMS.Category;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(min=5)
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String description;

    @Override
    public String toString() {
        return this.name;
    }
}
