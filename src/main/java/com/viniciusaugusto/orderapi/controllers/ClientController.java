package com.viniciusaugusto.orderapi.controllers;

import com.viniciusaugusto.orderapi.entities.Client;
import com.viniciusaugusto.orderapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Client>> findById(@PathVariable Long id) {
        Optional<Client> client = repository.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> insert (@RequestBody Client client) {
        repository.save(client);
        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
