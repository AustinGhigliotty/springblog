package com.codeup.springblog.Models;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getBody() {return body;}

    public void setBody(String body) {this.body = body;}

    public Ad getAd() {return ad;}

    public void setAd(Ad ad) {this.ad = ad;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}
}
