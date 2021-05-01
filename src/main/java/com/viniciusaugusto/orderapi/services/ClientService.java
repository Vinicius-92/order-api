package com.viniciusaugusto.orderapi.services;

import com.viniciusaugusto.orderapi.dto.ClientDTO;
import com.viniciusaugusto.orderapi.entities.Client;
import com.viniciusaugusto.orderapi.exceptions.ClientNotFoundException;
import com.viniciusaugusto.orderapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    public ClientRepository repository;

    public List<ClientDTO> findAll() {
        List<Client> list = repository.findAll();
        return list.stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    public ClientDTO findById(Long id) throws ClientNotFoundException {
            return new ClientDTO(repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id)));
     }

     public ClientDTO insert(ClientDTO dto) {
        Client clientToSave = new Client();
        clientToSave.setName(dto.getName());
        clientToSave.setEmail(dto.getEmail());
        repository.save(clientToSave);
        return new ClientDTO(clientToSave);
     }

     public void delete(Long id) {
        repository.deleteById(id);
     }
}




