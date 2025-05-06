package com.revisao.ecommerce.controllers;

import com.revisao.ecommerce.dto.PagamentoDTO;
import com.revisao.ecommerce.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/new")
    public ResponseEntity<PagamentoDTO> inserir(@RequestBody PagamentoDTO dto) {
        PagamentoDTO novoPagamento = pagamentoService.inserir(dto);
        return ResponseEntity.ok(novoPagamento);
    }
}