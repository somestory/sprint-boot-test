package com.amano.springboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto created ID
    private Long id;

    @Column(length=100, nullable=false) // varchar(100) not null
    private String user_id;

    @Column(length=100, nullable=false) // varchar(100) not null
    private String name;

    @Column		// varchar(255)
    private String email;

    @Column
    private Date regist_date;

    public User()
    {

    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegist_date() {
        return regist_date;
    }

    public void setRegist_date(Date regist_date) {
        this.regist_date = regist_date;
    }

    @PrePersist // Auto created date when it's created
    public void prePersist() {
        regist_date = new Date();
    }

}

