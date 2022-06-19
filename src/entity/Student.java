package entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private String id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL,
    mappedBy = "student")
    private Computer computer;

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
