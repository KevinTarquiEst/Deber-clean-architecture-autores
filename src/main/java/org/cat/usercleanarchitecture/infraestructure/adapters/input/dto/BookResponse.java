package org.cat.usercleanarchitecture.infraestructure.adapters.input.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private UUID id;
    private String title;
    private Integer year;
    private UUID authorId;
    private String authorFirstName;
    private String authorLastName;
}
