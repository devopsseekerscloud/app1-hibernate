package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Book> book;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_subject",
            joinColumns = {
                    @JoinColumn(name = "student_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "subject_id")
            }
    )
    Set<Subject> subjects =
            new HashSet<>();

    public Student(String id, String name, Computer computer, Set<Book> book, Set<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.computer = computer;
        this.book = book;
        this.subjects = subjects;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    private Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
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
