package com.app.rc.getting_started_with_jpa_relationships.shared.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BooksDTO {
    private int id;
    private String name;
    private String category;
    private String shelf;
    private boolean status;
    private Date createdAt;
    private Date updatedAt;
}
