package org.cat.usercleanarchitecture.infraestructure.adapters.input.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
