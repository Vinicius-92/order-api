package com.viniciusaugusto.orderapi.dto.responses;


import com.viniciusaugusto.orderapi.entities.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
