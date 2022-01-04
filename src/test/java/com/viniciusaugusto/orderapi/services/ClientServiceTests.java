package com.viniciusaugusto.orderapi.services;

import com.viniciusaugusto.orderapi.dto.ClientDTO;
import com.viniciusaugusto.orderapi.entities.Client;
import com.viniciusaugusto.orderapi.exceptions.ClientNotFoundException;
import com.viniciusaugusto.orderapi.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTests {

    private final ClientRepository repository = Mockito.mock(ClientRepository.class);
    private final ClientService service = new ClientService(repository);

    @BeforeEach
    void setUp() {
        var cli = new Client(1L, "Vinicius", "vinicius@gmail.com");
        var list = new ArrayList<Client>();
        list.add(cli);
        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(cli));
        Mockito.when(repository.findAll()).thenReturn(list);
    }

    @Test
    @DisplayName("Should return valid client dto when id is valid")
    void shouldReturnValidClientWhenIdIsValid() {
        var actual = service.findById(1L);
        var expected = new ClientDTO(new Client(1L, "Vinicius", "vinicius@gmail.com"));
        assertAll(() -> actual.getEmail().equals(expected.getEmail()),
                  () -> actual.getName().equals(expected.getName()),
                  () -> actual.getId().equals(expected.getId()));
    };

    @Test
    @DisplayName("Should throw ClientNotFoundException when given invalid id")
    void shouldThrowClientNotFoundExceptionWhenGivenInvalidId() {
        assertThrows(ClientNotFoundException.class, () -> service.findById(10L));
    }

    @Test
    @DisplayName("Should return list of clients")
    void shouldReturnListOfClients() {
        var cli = new Client(1L, "Vinicius", "vinicius@gmail.com");
        var actual = service.findAll();
        Assertions.assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(actual.get(0).getName(), cli.getName()),
                () -> assertEquals(actual.get(0).getEmail(), cli.getEmail()),
                () -> assertEquals(actual.get(0).getId(), cli.getId()));
    }

    @Test
    @DisplayName("ShouldReturnEmptyListWhenDatabaseIsEmpty")
    void ShouldReturnEmptyListWhenDatabaseIsEmpty() {
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<Client>());
        var expected = service.findAll();
        assertTrue(expected.isEmpty());
    }
}
