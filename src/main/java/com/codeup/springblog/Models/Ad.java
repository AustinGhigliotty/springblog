package com.codeup.springblog.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ad {
    @Id @GeneratedValue
    private long id;

    @Column (nullable = false, length = 75)
    private String title;

    @Column (nullable = false)
    private String description;

    @Column
    private String image;

    @OneToOne
    private User user;

    public Ad() {}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
    private List<Comment> comments;
}
