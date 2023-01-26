package com.viniciusaugusto.orderapi.services;

import com.viniciusaugusto.orderapi.dto.requests.ClientRequestDTO;
import com.viniciusaugusto.orderapi.dto.responses.ClientResponseDTO;
import com.viniciusaugusto.orderapi.entities.Client;
import com.viniciusaugusto.orderapi.exceptions.ClientNotFoundException;
import com.viniciusaugusto.orderapi.repositories.ClientRepository;
import com.viniciusaugusto.orderapi.services.impl.ClientServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTests {

    private ClientServiceImpl service;
    private final ClientRepository repository = Mockito.mock(ClientRepository.class);
    private final Client templateClient = new Client(1L, "Vinicius", "vinicius@gmail.com");

    @BeforeEach
    void setUp() {
        service = new ClientServiceImpl(repository);
        var list = new ArrayList<Client>(List.of(templateClient));
        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.of(templateClient));
        Mockito.when(repository.findAll()).thenReturn(list);
    }

    private void assertClientsAreEqual(ClientResponseDTO actual, ClientResponseDTO expected) {
        assertAll(() -> actual.getEmail().equals(expected.getEmail()),
                () -> actual.getName().equals(expected.getName()),
                () -> actual.getId().equals(expected.getId()));
    }

    @Test
    @DisplayName("Should return valid client dto when id is valid")
    void shouldReturnValidClientWhenIdIsValid() {
        var actual = service.findById(1L);
        var expected = new ClientResponseDTO(new Client(1L, "Vinicius", "vinicius@gmail.com"));
        assertClientsAreEqual(actual, expected);
    }

    @Test
    @DisplayName("Should throw ClientNotFoundException when given invalid id")
    void shouldThrowClientNotFoundExceptionWhenGivenInvalidId() {
        assertThrows(ClientNotFoundException.class, () -> service.findById(10L));
    }

    @Test
    @DisplayName("Should return list of clients")
    void shouldReturnListOfClients() {
        var actual = service.findAll();
        Assertions.assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(actual.get(0).getName(), templateClient.getName()),
                () -> assertEquals(actual.get(0).getEmail(), templateClient.getEmail()),
                () -> assertEquals(actual.get(0).getId(), templateClient.getId()));
    }

    @Test
    @DisplayName("Should return empty list when database is empty")
    void ShouldReturnEmptyListWhenDatabaseIsEmpty() {
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<Client>());
        var expected = service.findAll();
        assertTrue(expected.isEmpty());
    }

    // TODO: Implement return, mock repository to return registry with id
    @Test
    @Disabled
    @DisplayName("Should insert new client and return ClientResponse when valid args")
    void ShouldInsertNewClientAndReturnClientResponseWhenValidArgs() {
        assertTrue(true);
    }
}
