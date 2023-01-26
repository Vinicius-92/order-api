package com.viniciusaugusto.orderapi.entities;

import com.viniciusaugusto.orderapi.dto.requests.ClientRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    public Client(ClientRequestDTO dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
    }
}
