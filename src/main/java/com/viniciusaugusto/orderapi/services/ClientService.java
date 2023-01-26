package com.viniciusaugusto.orderapi.services;

import com.viniciusaugusto.orderapi.dto.responses.ClientResponseDTO;
import com.viniciusaugusto.orderapi.dto.requests.ClientRequestDTO;
import java.util.List;

public interface ClientService {

    List<ClientResponseDTO> findAll();

    ClientResponseDTO findById(Long id);

    ClientResponseDTO insert(ClientRequestDTO dto);

     void delete(Long id);
}




