package org.cat.usercleanarchitecture.infraestructure.adapters.input.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutorRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
