package pl.coderslab.springCMS.Author;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }


    public String getFullName() {
        return this.firstName+" "+this.lastName;
    }
}


//json
//{
//        "firstName":"James",
//        "lastName":"Bond"
//        }