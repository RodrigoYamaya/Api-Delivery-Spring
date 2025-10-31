package com.RodSolution.demo.model.enums;

public enum OrderStatus {

    WAITING_PAYMENT("Aguardando Pagamento"),
    PAID("Pago"),
    SHIPPED("Enviado"),
    DELIVERED("Entregue"),
    CANCELLED("Cancelado");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }







}