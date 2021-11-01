package com.doceria.renata.service;

import com.doceria.renata.model.Pedido;
import com.doceria.renata.model.request.PedidoRequest;
import com.doceria.renata.model.response.PedidoResponse;
import com.doceria.renata.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    public PedidoRepository pedidoRepository;

    public PedidoResponse insertPedido(PedidoRequest pedidoRequest){
        Pedido pedido = pedidoRequest.toModel();
        pedidoRepository.save(pedido);
        return PedidoResponse.toResponse(pedido);
    }
}
