package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    private String id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL,
    mappedBy = "student")
    private Computer computer;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "student")
    private List<Book> book;

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
