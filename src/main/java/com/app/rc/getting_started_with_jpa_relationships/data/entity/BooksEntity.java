package com.app.rc.getting_started_with_jpa_relationships.data.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class BooksEntity {

    @Id
    private int id;

    @NotNull
    @Column(unique = true)
    private String name;
    private String category;
    private String shelf;

    @NotNull
    private boolean status;
    @NotNull
    private Date createdAt;
    @NotNull
    private Date updatedAt;

    /**
     * For Creating Record
     * @param name
     * @param category
     * @param shelf
     * @param status
     * @param createdAt
     * @param updatedAt
     */
    public BooksEntity(
            @NotNull String name,
            String category,
            String shelf,
            @NotNull boolean status,
            @NotNull Date createdAt,
            @NotNull Date updatedAt) {
        this.name = name;
        this.category = category;
        this.shelf = shelf;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}