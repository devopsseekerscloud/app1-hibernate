package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
    @Id
    private String subjectId;
    private String subjectTitle;

    public Subject(String subjectId, String subjectTitle, Set<Student> students) {
        this.subjectId = subjectId;
        this.subjectTitle = subjectTitle;
        this.students = students;
    }

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students=
            new HashSet<>();

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
