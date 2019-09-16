package com.codeup.springblog.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 75)
    private String username;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String password;

    public User() {}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments;
}
