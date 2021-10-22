package cn.hzxy.springbootuserjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class SBTeacher {
    @Id
    private String id;
    @Column(name = "name", length = 32)
    private String name;
    @Column
    private String password;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
