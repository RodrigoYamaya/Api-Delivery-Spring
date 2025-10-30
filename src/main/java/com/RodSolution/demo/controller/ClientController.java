package com.RodSolution.demo.controller;

import com.RodSolution.demo.model.dtos.ClientRequestDto;
import com.RodSolution.demo.model.dtos.ClientResponseDto;
import com.RodSolution.demo.service.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable(value = "id") long id) {
        ClientResponseDto clientResponseDto = clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientResponseDto);

    }

    @GetMapping("/search/{email}")
    public ResponseEntity<ClientResponseDto> findByEmail(@RequestParam String email) {
        ClientResponseDto clientResponseDto = clientService.findByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(clientResponseDto);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ClientResponseDto>> findByNome(@RequestParam String name) {
        List<ClientResponseDto> clients = clientService.findByNome(name);
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @Transactional
    @PostMapping("/save")
    public ResponseEntity<ClientResponseDto> save(@RequestBody @Valid ClientRequestDto clientDto) {
        ClientResponseDto clientResponseDto = clientService.save(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponseDto);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
        clientService.deletarUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("user com o ID " + id + " deletado com sucesso.");
    }

    @Transactional
    @PutMapping("updateClient/{id}")
    public ResponseEntity<ClientResponseDto> updateUser(@PathVariable(value = "id") long id, @RequestBody @Valid ClientRequestDto clientRequestDto) {
        ClientResponseDto clientResponseDto = clientService.update(clientRequestDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(clientResponseDto);
    }




}
