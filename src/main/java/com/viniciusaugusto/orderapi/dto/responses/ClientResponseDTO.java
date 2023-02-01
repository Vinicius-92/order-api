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
    private String phoneNumber;
    private String streetName;
    private String city;
    private String state;
    private String homeNumber;
    private String zipCode;

    public ClientResponseDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.phoneNumber = client.getPhoneNumber();
        this.streetName = client.getStreetName();
        this.city = client.getCity();
        this.state = client.getState();
        this.homeNumber = client.getHomeNumber();
        this.zipCode = client.getZipCode();
    }
}
