package com.example.slstudiomini.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // アカウント
    
    @Column(nullable = false, unique = true)
    @NotBlank(message = "名前は入力必須です")
    // @NotNull(message = "名前は入力必須です")

    @Size(min=4,max=30,message="ユーザー名は4文字以上30文字以内で入力してください")
    private String username;
    
    // パスワード
    @Column(nullable = false)
    @NotBlank(message = "パスワードは入力必須です")
    // @NotNull(message = "パスワードは入力必須です")
    @Size(min=6,message="パスワードは６文字以上で入力してください")
    @Pattern(regexp = "^[a-zA-Z0-9\\\\-_.$%/]+$",message="半角英数と一部の記号（-、_、.$%/）のみ入力可です")
    private String password;

    // 有効・無効フラグ
    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_authority",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;

//     username

// 必須

// 空文字禁止

// 4文字以上30文字以下

// password

// 半角英数と一部の記号（-、_、.、$、%、/）のみ

// 必須

// 空文字禁止

// 6文字以上

    public User() {
    }

    public User(Long id, String username, String password, boolean enabled, Set<Authority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}