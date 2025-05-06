package com.revisao.ecommerce.dto;

import java.time.Instant;

public class PagamentoDTO {
    private Instant momento;
    private Long pedidoId;

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public PagamentoDTO(Instant momento, Long pedidoId) {
        this.momento = momento;
        this.pedidoId = pedidoId;
    }
}
