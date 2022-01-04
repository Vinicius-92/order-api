package com.viniciusaugusto.orderapi.services;

import com.viniciusaugusto.orderapi.dto.ClientDTO;
import com.viniciusaugusto.orderapi.entities.Client;
import com.viniciusaugusto.orderapi.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTests {

    private final ClientRepository repository = Mockito.mock(ClientRepository.class);
    private final ClientService service = new ClientService(repository);

    @BeforeEach
    void setUp() {
        var cli = new Client(1L, "Vinicius", "vinicius@gmail.com");
        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(cli));
    }

    @Test
    void shouldReturnValidClientWhenIdIsValid() {
        var actual = service.findById(1L);
        var expected = new ClientDTO(new Client(1L, "Vinicius", "vinicius@gmail.com"));
        Assertions.assertAll(() -> Objects.equals(actual.getEmail(), expected.getEmail()),
                             () -> Objects.equals(actual.getName(), expected.getName()),
                             () -> Objects.equals(actual.getId(), expected.getId()));
    };
}
