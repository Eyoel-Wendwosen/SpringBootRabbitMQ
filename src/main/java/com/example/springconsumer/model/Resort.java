package com.example.springconsumer.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resort")
public class Resort {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Integer resortId;
    private String name;
    private String address;

    public Resort() {
    }

    public Resort(int resortId, String name, String address) {
        this.resortId = resortId;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Resort{" +
                "id='" + id + '\'' +
                ", resortId=" + resortId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
