package com.viniciusaugusto.orderapi.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientRequestDTO {
    private String name;
    private String email;
}
