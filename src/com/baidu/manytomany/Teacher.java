package com.baidu.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 2017/7/3.
 */
@Entity
@Table(name = "teachertest")
public class Teacher {
    private Integer id;
    private String name;
    private Set<Student> students =new HashSet<>();

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToMany(cascade = CascadeType.REFRESH,mappedBy = "teachers")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;

        Teacher teacher = (Teacher) o;

        if (id != null ? !id.equals(teacher.id) : teacher.id != null) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        return students != null ? students.equals(teacher.students) : teacher.students == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        return result;
    }
}
