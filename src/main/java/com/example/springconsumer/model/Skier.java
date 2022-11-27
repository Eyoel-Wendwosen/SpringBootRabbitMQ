package com.example.springconsumer.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skier")
public class Skier {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Integer skierId;
    private String name;
    private Integer age;

    public Skier(int skierId, String name, int age) {
        this.skierId = skierId;
        this.name = name;
        this.age = age;
    }

    public Skier() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSkierId() {
        return skierId;
    }

    public void setSkierId(int skierId) {
        this.skierId = skierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Skier{" +
                "id='" + id + '\'' +
                ", skierId=" + skierId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
