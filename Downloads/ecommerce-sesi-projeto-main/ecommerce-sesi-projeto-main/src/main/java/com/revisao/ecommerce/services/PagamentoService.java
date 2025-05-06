package com.revisao.ecommerce.services;

import com.revisao.ecommerce.dto.PagamentoDTO;
import com.revisao.ecommerce.entities.Pagamento;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.repositories.PagamentoRepository;
import com.revisao.ecommerce.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public PagamentoDTO inserir(PagamentoDTO dto) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(dto.getPedidoId());

        if (pedidoOpt.isEmpty()) {
            throw new RuntimeException("Pedido não encontrado com id: " + dto.getPedidoId());
        }

        Pedido pedido = pedidoOpt.get();

        // Cria o pagamento e associa ao pedido
        Pagamento pagamento = new Pagamento();
        pagamento.setMomento(dto.getMomento());
        pagamento.setPedido(pedido);

        // Salva o pagamento (ID será o mesmo do pedido)
        pagamento = pagamentoRepository.save(pagamento);

        // Atualiza o pedido com o pagamento (se ainda não estiver setado)
        pedido.setPagamento(pagamento);
        pedidoRepository.save(pedido);

        return new PagamentoDTO(pagamento.getMomento(), pedido.getId());
    }
}

