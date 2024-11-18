package com.example.fukushu2.model;

import java.util.Set;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
@SQLRestriction("is_deleted=false")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private boolean isDeleted=false;

    @ManyToMany
    @JoinTable(
        name="talkroom_user",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="talkroom_id")
    )
    private Set<TalkRoom>talkrooms;

    public User() {
    }
    

    public User(Long id) {
        this.id = id;
    }


    public User(Long id, String name, boolean isDeleted, Set<TalkRoom> talkrooms) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
        this.talkrooms = talkrooms;
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

    public Set<TalkRoom> getTalkrooms() {
        return talkrooms;
    }

    public void setTalkrooms(Set<TalkRoom> talkrooms) {
        this.talkrooms = talkrooms;
    }

    

}
