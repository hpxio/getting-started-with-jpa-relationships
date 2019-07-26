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
    @GeneratedValue
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
}