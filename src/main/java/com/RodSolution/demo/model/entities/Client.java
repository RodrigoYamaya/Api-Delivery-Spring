package com.RodSolution.demo.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name= "tb_client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name ="phone", nullable = false)
    private String phone;

    @Column(name = "adress", nullable = false)
    private String address;

    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdAt;




}
