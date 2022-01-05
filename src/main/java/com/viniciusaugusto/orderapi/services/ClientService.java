package com.viniciusaugusto.orderapi.services;

import com.viniciusaugusto.orderapi.dto.responses.ClientResponseDTO;
import com.viniciusaugusto.orderapi.dto.requests.ClientRequestDTO;
import java.util.List;

public abstract interface ClientService {

    public List<ClientResponseDTO> findAll();

    public ClientResponseDTO findById(Long id);

    public void insert(ClientRequestDTO dto);

     public void delete(Long id);
}




