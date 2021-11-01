package com.doceria.renata.controller;

import com.doceria.renata.exception.ErrorApiException;
import com.doceria.renata.model.Pedido;
import com.doceria.renata.model.Produto;
import com.doceria.renata.model.request.PedidoRequest;
import com.doceria.renata.model.request.ProdutoRequest;
import com.doceria.renata.model.response.PedidoResponse;
import com.doceria.renata.model.response.ProdutoResponse;
import com.doceria.renata.repository.PedidoRepository;
import com.doceria.renata.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/pedidos")
public class  PedidoController {

    @Autowired
    public PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResponse insert(@RequestBody @Valid PedidoRequest pedidoRequest){
        return pedidoService.insertPedido(pedidoRequest);
    }

}
