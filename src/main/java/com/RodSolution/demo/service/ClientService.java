package com.RodSolution.demo.service;

import com.RodSolution.demo.Exception.RecursoNaoEncontradoException;
import com.RodSolution.demo.mapper.ClientMapper;
import com.RodSolution.demo.model.dtos.ClientRequestDto;
import com.RodSolution.demo.model.dtos.ClientResponseDto;
import com.RodSolution.demo.model.entities.Client;
import com.RodSolution.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientMapper clientMapper;


    public List<ClientResponseDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }


    public ClientResponseDto findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("client com ID " + id + " não encontrado."));
        return clientMapper.toDto(client);
    }

    public ClientResponseDto findByEmail(String email) {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Email" + email + "Não encontrado"));
        return clientMapper.toDto(client);
    }

    public List<ClientResponseDto> findByNome(String nome) {
        List<Client> clients = clientRepository.findBynameContainingIgnoreCase(nome);

            return clients.stream()
                    .map(clientMapper::toDto)
                    .collect(Collectors.toList());
    }

    public ClientResponseDto save(ClientRequestDto dto) {
        Client client = clientMapper.toEntity(dto);
        Client saveClient = clientRepository.save(client);
        return clientMapper.toDto(saveClient);
    }

    public void deletarUser(long id) {
        if(!clientRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("client com o ID " + id + " não encontrado");
        }
        clientRepository.deleteById(id);
    }

    public ClientResponseDto update(ClientRequestDto clientdto, Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Client  com ID" + id + "não encontrado"));

        client.setName(clientdto.name());
        client.setEmail(clientdto.email());
        client.setAddress(clientdto.address());

        Client clientUpdate = clientRepository.save(client);
        return clientMapper.toDto(clientUpdate);

    }

}
