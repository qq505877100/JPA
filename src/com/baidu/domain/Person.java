package com.baidu.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dell on 2017/7/2.
 */
@Entity
public class Person {
    private Integer id;
    private String name;

    public Person() {
    }

    public Person(String name) {
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

    public String add() {
        return "ss";
    }
}
