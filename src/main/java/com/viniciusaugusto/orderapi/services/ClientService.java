package com.viniciusaugusto.orderapi.services;

import com.viniciusaugusto.orderapi.dto.ClientDTO;
import com.viniciusaugusto.orderapi.entities.Client;
import com.viniciusaugusto.orderapi.exceptions.ClientNotFoundException;
import com.viniciusaugusto.orderapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public abstract interface ClientService {

    public List<ClientDTO> findAll();

    public ClientDTO findById(Long id);

    public void insert(ClientDTO dto);

     public void delete(Long id);
}




