package com.doceria.renata.controller;

import com.doceria.renata.exception.ErrorApiException;
import com.doceria.renata.model.Pedido;
import com.doceria.renata.model.Produto;
import com.doceria.renata.model.response.ProdutoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/pedidos")
public class PedidoController {

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoResponse consultar(@PathVariable Long id) {

        Optional<Pedido> pedidoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            return ProdutoResponse.toResponse(produtoOptional.get());
        }

        throw new ErrorApiException(HttpStatus.NOT_FOUND, "Produto não encontrado");
    }

}
