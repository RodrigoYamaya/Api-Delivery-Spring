package com.RodSolution.demo.model.entities;

import com.RodSolution.demo.model.enums.OrderStatus;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.Instant;


@Entity
@Table(name= "tb_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private OrderStatus orderStatus;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;





}