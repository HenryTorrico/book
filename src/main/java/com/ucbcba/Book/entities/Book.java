package com.ucbcba.Book.entities;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotNull
    String title;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="book_category_id")
    public BookCategory bookCategory;

    @ManyToOne(cascade = CascadeType.REFRESH)
    //@JoinColumn(name="user_id")
    @JoinTable(name = "user_book",joinColumns={@JoinColumn(name="book_id")})
    public User user;


    @Min(value = 0, message ="El valor debe ser mayor a 0")
    private Integer likes=0;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookCategory getBookCategory() {
        return this.bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
