package com.revisao.ecommerce.services;

import com.revisao.ecommerce.dto.RelatorioPedidoDTO;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.repositories.PedidoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Relatorio {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void gerarRelatorioPDF(String caminho) throws JRException {
        List<Pedido> pedidos = pedidoRepository.findAll();
        System.out.println("Caminho" + caminho);

        List<RelatorioPedidoDTO> dados = pedidos.stream()
                .map(RelatorioPedidoDTO::new)
                .collect(Collectors.toList());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dados);

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("titulo", "Relatorio de Pedidos");

        InputStream reportStream = getClass().getResourceAsStream("/relatorios/Pedidos_relatorios.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, caminho);
    }
}
