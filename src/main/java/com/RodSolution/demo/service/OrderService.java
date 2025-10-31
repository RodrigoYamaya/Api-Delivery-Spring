package com.RodSolution.demo.service;

import com.RodSolution.demo.Exception.RecursoNaoEncontradoException;
import com.RodSolution.demo.mapper.OrderMapper;
import com.RodSolution.demo.model.dtos.OrderRequestDto;
import com.RodSolution.demo.model.dtos.OrderResponseDto;
import com.RodSolution.demo.model.entities.Order;
import com.RodSolution.demo.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;


    @Transactional
    public OrderResponseDto update(OrderRequestDto orderRequestDto, Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado"));

        order.setOrderStatus(orderRequestDto.orderStatus());
        Order updateOrder = orderRepository.save(order);

        return orderMapper.toDto(updateOrder);
    }
}

