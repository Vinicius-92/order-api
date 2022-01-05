package com.viniciusaugusto.orderapi.services.impl;

import com.viniciusaugusto.orderapi.dto.ClientDTO;
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
    public List<ClientDTO> findAll() {
        List<Client> list = repository.findAll();
        return list.stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClientDTO findById(Long id) throws ClientNotFoundException {
        return new ClientDTO(repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id)));
    }

    @Override
    public void insert(ClientDTO dto) {
        Client clientToSave = repository.save(new Client(dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}