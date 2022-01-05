package com.viniciusaugusto.orderapi.dto.responses;


import com.viniciusaugusto.orderapi.entities.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientResponseDTO {

    private Long id;
    private String name;
    private String email;

    public ClientResponseDTO(Client client) {
        id = client.getId();
        name = client.getName();
        email = client.getEmail();
    }
}
