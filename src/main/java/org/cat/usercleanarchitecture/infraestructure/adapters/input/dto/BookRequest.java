package org.cat.usercleanarchitecture.infraestructure.adapters.input.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    private String title;
    private Integer year;
    private UUID authorId;
}
