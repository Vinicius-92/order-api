package com.viniciusaugusto.orderapi.dto;


import com.viniciusaugusto.orderapi.entities.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    private String name;
    private String email;

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        email = client.getEmail();
    }
}
