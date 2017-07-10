package com.baidu.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 2017/7/3.
 */
@Entity
@Table(name="studenttest")
public class Student {
    private Integer id;
    private String name;
    private Set<Teacher> teachers = new HashSet<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "stu-teacher",inverseJoinColumns = @JoinColumn(name = "teacher_id"),joinColumns = @JoinColumn(name = "student_id"))
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
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

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public void removeTeacher(Teacher teacher) {
        if (teachers.contains(teacher)) {
            teachers.remove(teacher);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return teachers != null ? teachers.equals(student.teachers) : student.teachers == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teachers != null ? teachers.hashCode() : 0);
        return result;
    }
}
