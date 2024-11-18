package com.example.fukushu2.model;

import java.util.Set;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="talkrooms")
@SQLRestriction("is_deleted=false")
public class TalkRoom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private boolean isDeleted=false;

    @ManyToMany(mappedBy = "talkrooms")
    private Set<User>users;

    public TalkRoom() {
    }

    

    public TalkRoom(Long id) {
        this.id = id;
    }



    public TalkRoom(Long id, String name, boolean isDeleted, Set<User> users) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    
}
