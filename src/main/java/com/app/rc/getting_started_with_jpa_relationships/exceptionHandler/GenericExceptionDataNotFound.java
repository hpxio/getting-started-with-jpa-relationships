package com.app.rc.getting_started_with_jpa_relationships.exceptionHandler;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GenericExceptionDataNotFound extends RuntimeException {

    private String message;
}
