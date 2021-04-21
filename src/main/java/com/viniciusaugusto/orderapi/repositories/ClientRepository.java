package com.viniciusaugusto.orderapi.repositories;

import com.viniciusaugusto.orderapi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
