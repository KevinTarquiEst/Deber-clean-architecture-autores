package org.cat.usercleanarchitecture.domain.model;

import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private Integer year;
    private UUID authorId;
    private String authorFirstName;
    private String authorLastName;

    public Book() {
    }

    public Book(UUID id, String title, Integer year, UUID authorId, String authorFirstName, String authorLastName) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.authorId = authorId;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
}
