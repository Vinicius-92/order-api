package com.viniciusaugusto.orderapi.services.impl;

import com.viniciusaugusto.orderapi.dto.responses.ClientResponseDTO;
import com.viniciusaugusto.orderapi.dto.requests.ClientRequestDTO;
import com.viniciusaugusto.orderapi.entities.Client;
import com.viniciusaugusto.orderapi.exceptions.ClientNotFoundException;
import com.viniciusaugusto.orderapi.repositories.ClientRepository;
import com.viniciusaugusto.orderapi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    public ClientRepository repository;

    @Override
    public List<ClientResponseDTO> findAll() {
        List<Client> list = repository.findAll();
        return list.stream().map(ClientResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClientResponseDTO findById(Long id) throws ClientNotFoundException {
        return new ClientResponseDTO(repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id)));
    }

    @Override
    public ClientResponseDTO insert(ClientRequestDTO dto) {
        Client clientToSave = repository.save(new Client(dto));
        return new ClientResponseDTO(clientToSave);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
