package com.amano.springboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 50, nullable = false)
    String group_id;

    @Column(length = 100, nullable = false)
    String group_name;

    @Column
    private Date regist_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    @PrePersist // Auto created date when it's created
    public void prePersist() {
        regist_date = new Date();
    }


    @Override
    public String toString() {
        return "UserGroup{" +
                "id=" + id +
                ", group_id='" + group_id + '\'' +
                ", group_name='" + group_name + '\'' +
                '}';
    }


}
