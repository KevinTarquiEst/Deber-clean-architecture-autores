package org.cat.usercleanarchitecture.infraestructure.adapters.input;

import org.cat.usercleanarchitecture.aplication.ports.input.IAutorUseCase;
import org.cat.usercleanarchitecture.domain.model.Autor;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AutorRequest;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.dto.AutorResponse;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper.UserRequestMapper;
import org.cat.usercleanarchitecture.infraestructure.adapters.input.mapper.UserResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class AutorController {

    private final IAutorUseCase userUseCase;

    public AutorController(IAutorUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public ResponseEntity<AutorResponse> create(@RequestBody AutorRequest request) {
        Autor autor = userUseCase.create(UserRequestMapper.INSTANCE.toUser(request));
        return new ResponseEntity<>(
                UserResponseMapper.INSTANCE.toUserRequest(autor),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<AutorResponse>> findByLastName(@RequestParam String lastName) {
        List<Autor> autors = userUseCase.findByLastName(lastName);
        List<AutorResponse> autorResponse = autors.stream()
                .map(UserResponseMapper.INSTANCE::toUserRequest)
                .toList();
        return new ResponseEntity<>(autorResponse, HttpStatus.OK);
    }
}
